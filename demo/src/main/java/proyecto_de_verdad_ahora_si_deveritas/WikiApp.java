package proyecto_de_verdad_ahora_si_deveritas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Arrays;
import java.util.List;

/** Interfaz común a todas las entidades */
interface Registro {
    Object getValue(String col);
    void setValue(String col, Object val);
}

/** Factoría de registros desde ResultSet o vacía */
interface RegistroFactory<T extends Registro> {
    T fromResultSet(ResultSet rs) throws SQLException;
    T createEmpty();
}

/** Panel genérico CRUD para cualquier tabla */
class EntidadPanel<T extends Registro> extends JPanel {
    private final DefaultListModel<T> model = new DefaultListModel<>();
    private final JList<T> list = new JList<>(model);
    private final JTextField[] fields;
    private final JButton btnNuevo = new JButton("Nuevo"),
                          btnGuardar = new JButton("Guardar"),
                          btnEliminar= new JButton("Eliminar");
    private final String tabla;
    private final List<String> cols;
    private final RegistroFactory<T> factory;
    private final Connection conn;

    public EntidadPanel(Connection conn, String tabla, List<String> cols, RegistroFactory<T> factory) {
        super(new BorderLayout());
        this.conn = conn;
        this.tabla = tabla;
        this.cols  = cols;
        this.factory = factory;

        // Formulario dinámico
        JPanel form = new JPanel(new GridLayout(cols.size(), 2, 5, 5));
        fields = new JTextField[cols.size()];
        for (int i = 0; i < cols.size(); i++) {
            form.add(new JLabel(cols.get(i)));
            fields[i] = new JTextField();
            // campo 0 (id o llave compuesta) no editable
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

    private void cargarTodos() {
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
            // Actualizar objeto
            for (int i = 1; i < cols.size(); i++) {
                r.setValue(cols.get(i), fields[i].getText());
            }
            // Construir UPDATE
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
            // Construir INSERT
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

    private void mostrarError(Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this,
            e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

/** Implementaciones para la tabla `via` */
class Via implements Registro {





    
    int id; String nombre;
    Via() {}
    Via(int id, String nombre) { this.id = id; this.nombre = nombre; }
    public Object getValue(String c) {
        if ("id".equals(c)) return id;
        if ("nombre".equals(c)) return nombre;
        return null;
    }
    public void setValue(String c, Object v) {
        if ("nombre".equals(c)) nombre = v.toString();
    }
    public String toString() { return nombre; }
}
class ViaFactory implements RegistroFactory<Via> {
    public Via fromResultSet(ResultSet rs) throws SQLException {
        return new Via(rs.getInt("id"), rs.getString("nombre"));
    }
    public Via createEmpty() { return new Via(0, ""); }
}

/** Implementaciones para la tabla `personaje` */
class Personaje implements Registro {
    int id, rareza, nivel; String nombre;
    Personaje() {}
    Personaje(int id, String nombre, int rareza, int nivel) {
        this.id = id; this.nombre = nombre;
        this.rareza = rareza; this.nivel = nivel;
    }
    public Object getValue(String c) {
        if ("id".equals(c)) return id;
        if ("nombre".equals(c)) return nombre;
        if ("rareza".equals(c)) return rareza;
        if ("nivel".equals(c)) return nivel;
        return null;
    }
    public void setValue(String c, Object v) {
        if ("nombre".equals(c)) nombre = v.toString();
        else if ("rareza".equals(c)) rareza = Integer.parseInt(v.toString());
        else if ("nivel".equals(c)) nivel = Integer.parseInt(v.toString());
    }
    public String toString() { return nombre; }
}
class PersonajeFactory implements RegistroFactory<Personaje> {
    public Personaje fromResultSet(ResultSet rs) throws SQLException {
        return new Personaje(
            rs.getInt("id"), rs.getString("nombre"),
            rs.getInt("rareza"), rs.getInt("nivel")
        );
    }
    public Personaje createEmpty() {
        return new Personaje(0, "", 0, 0);
    }
}

/** Clase principal */
public class WikiApp extends JFrame {
    private Connection conn;
    private JTabbedPane tabs = new JTabbedPane();

    public WikiApp() {
        super("HSR Wiki DB Client");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        conectarBD();
        inicializarPestañas();
        add(tabs);
    }

    private void conectarBD() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/proyecto_db", "root", "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Error de conexión:\n" + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    private void inicializarPestañas() {
        tabs.addTab("Vías",
            new EntidadPanel<Via>(
                conn,
                "via",
                Arrays.asList("id", "nombre"),
                new ViaFactory()
            ));
        tabs.addTab("Personajes",
            new EntidadPanel<Personaje>(
                conn,
                "personaje",
                Arrays.asList("id", "nombre", "rareza", "nivel"),
                new PersonajeFactory()
            ));
        // … aquí repites para cada tabla de tu diagrama:
        // tabs.addTab("Conos", new EntidadPanel<Cono>(conn, "cono",
        //     Arrays.asList("id","nombre","rareza","nivel","material_xp_id"),
        //     new ConoFactory()));
        // etc.
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
            new WikiApp().setVisible(true)
        );
    }
}
