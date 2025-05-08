package proyecto_de_verdad_ahora_si_deveritas;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.List;

/**
 * Panel genérico CRUD para cualquier tabla de base de datos.
 * 
 * <p>Esta clase implementa un panel de usuario que permite realizar operaciones
 * básicas de Crear, Leer, Actualizar y Eliminar (CRUD) sobre una tabla
 * de base de datos usando JDBC. Se basa en un modelo de datos genérico
 * que extiende la interfaz {@code Registro} y se construye dinámicamente
 * con los nombres de columnas y una fábrica de registros.
 *
 * @param <T> el tipo de registro que se mostrará y manipulará en este panel
 */
class EntidadPanel<T extends Registro> extends JPanel {

    /** Modelo de lista que contiene los registros cargados desde la base de datos. */
    protected final DefaultListModel<T> model = new DefaultListModel<>();

    /** Lista gráfica que muestra los registros. */
    private final JList<T> list = new JList<>(model);

    /** Campos de entrada correspondientes a las columnas de la tabla. */
    private final JTextField[] fields;

    /** Botón para crear un nuevo registro. */
    private final JButton btnNuevo = new JButton("Nuevo");

    /** Botón para guardar (actualizar) un registro existente. */
    private final JButton btnGuardar = new JButton("Guardar");

    /** Botón para eliminar un registro seleccionado. */
    private final JButton btnEliminar = new JButton("Eliminar");

    /** Nombre de la tabla asociada en la base de datos. */
    private final String tabla;

    /** Lista con los nombres de las columnas de la tabla. */
    private final List<String> cols;

    /** Fábrica para construir instancias de registros genéricos. */
    protected final RegistroFactory<T> factory;

    /** Conexión JDBC a la base de datos. */
    private final Connection conn;

    /**
     * Crea un nuevo panel de entidad para manipular una tabla dada.
     *
     * @param conn conexión activa a la base de datos
     * @param tabla nombre de la tabla
     * @param cols lista con los nombres de las columnas de la tabla
     * @param factory fábrica de registros para crear instancias desde {@code ResultSet}
     */
    public EntidadPanel(Connection conn, String tabla, List<String> cols, RegistroFactory<T> factory) {
        super(new BorderLayout());
        this.conn = conn;
        this.tabla = tabla;
        this.cols  = cols;
        this.factory = factory;

        // Crear formulario dinámico
        JPanel form = new JPanel(new GridLayout(cols.size(), 2, 5, 5));
        fields = new JTextField[cols.size()];
        for (int i = 0; i < cols.size(); i++) {
            form.add(new JLabel(cols.get(i)));
            fields[i] = new JTextField();
            // El campo ID (índice 0) no es editable
            fields[i].setEnabled(i != 0);
            form.add(fields[i]);
        }

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                new JScrollPane(list), form);
        split.setDividerLocation(200);

        JPanel botones = new JPanel();
        botones.add(btnNuevo);
        botones.add(btnGuardar);
        botones.add(btnEliminar);

        add(split, BorderLayout.CENTER);
        add(botones, BorderLayout.SOUTH);

        cargarTodos();
        inicializarListeners();
    }

    /**
     * Carga todos los registros desde la tabla en la base de datos y los muestra en la lista.
     */
    protected void cargarTodos() {
        model.clear();
        String sql = "SELECT " + String.join(",", cols) + " FROM " + tabla;
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                model.addElement(factory.fromResultSet(rs));
            }
        } catch (SQLException e) {
            mostrarError(e);
        }
    }

    /**
     * Inicializa los listeners para los botones y la lista de selección.
     * Controla las acciones de selección, inserción, actualización y eliminación.
     */
    private void inicializarListeners() {
        list.addListSelectionListener(e -> {
            if (e.getValueIsAdjusting()) return;
            T r = list.getSelectedValue();
            if (r == null) return;
            for (int i = 0; i < cols.size(); i++) {
                Object v = r.getValue(cols.get(i));
                fields[i].setText(v == null ? "" : v.toString());
            }
        });

        btnGuardar.addActionListener(e -> {
            T r = list.getSelectedValue();
            if (r == null) return;
            // Actualizar valores en el objeto
            for (int i = 1; i < cols.size(); i++) {
                r.setValue(cols.get(i), fields[i].getText());
            }

            // Construir sentencia UPDATE
            StringBuilder setC = new StringBuilder();
            for (int i = 1; i < cols.size(); i++) {
                if (i > 1) setC.append(",");
                setC.append(cols.get(i)).append("=?");
            }
            String sql = "UPDATE " + tabla + " SET " + setC +
                         " WHERE " + cols.get(0) + "=?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                int idx = 1;
                for (int i = 1; i < cols.size(); i++) {
                    ps.setString(idx++, fields[i].getText());
                }
                ps.setString(idx, fields[0].getText());
                ps.executeUpdate();
                cargarTodos();
            } catch (SQLException ex) {
                mostrarError(ex);
            }
        });

        btnNuevo.addActionListener(e -> {
            T r = factory.createEmpty();
            for (int i = 1; i < cols.size(); i++) {
                String val = JOptionPane.showInputDialog(this,
                        "Valor para " + cols.get(i));
                if (val == null) return;
                r.setValue(cols.get(i), val);
            }

            // Construir sentencia INSERT
            StringBuilder colNames = new StringBuilder();
            StringBuilder ph = new StringBuilder();
            for (int i = 1; i < cols.size(); i++) {
                if (i > 1) {
                    colNames.append(",");
                    ph.append(",");
                }
                colNames.append(cols.get(i));
                ph.append("?");
            }
            String sql = "INSERT INTO " + tabla +
                         "(" + colNames + ") VALUES(" + ph + ")";
            try (PreparedStatement ps = conn.prepareStatement(
                    sql, Statement.RETURN_GENERATED_KEYS)) {
                for (int i = 1; i < cols.size(); i++) {
                    ps.setString(i, r.getValue(cols.get(i)).toString());
                }
                ps.executeUpdate();
                ResultSet keys = ps.getGeneratedKeys();
                if (keys.next()) {
                    r.setValue(cols.get(0), keys.getString(1));
                }
                cargarTodos();
            } catch (SQLException ex) {
                mostrarError(ex);
            }
        });

        btnEliminar.addActionListener(e -> {
            T r = list.getSelectedValue();
            if (r == null) return;
            if (JOptionPane.showConfirmDialog(this, "¿Eliminar?") 
                    != JOptionPane.YES_OPTION) return;
            String sql = "DELETE FROM " + tabla +
                         " WHERE " + cols.get(0) + "=?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, fields[0].getText());
                ps.executeUpdate();
                cargarTodos();
            } catch (SQLException ex) {
                mostrarError(ex);
            }
        });
    }

    /**
     * Muestra un mensaje de error al usuario en caso de excepción.
     *
     * @param e la excepción lanzada
     */
    protected void mostrarError(Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this,
            e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
