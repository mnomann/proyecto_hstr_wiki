package proyecto_de_verdad_ahora_si_deveritas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

/**
 * La clase {@code WikiApp} representa una aplicación gráfica de escritorio
 * que actúa como cliente para consultar y editar registros en una base de datos MariaDB.
 * <p>
 * Esta interfaz permite visualizar y editar distintas entidades como Vías, Personajes,
 * Conos, Enemigos, Equipamiento y Material de Enemigo usando pestañas.
 * </p>
 * 
 * Extiende {@link JFrame} para proporcionar una ventana principal con interfaz gráfica.
 */
public class WikiApp extends JFrame {

    /** Conexión a la base de datos. */
    private Connection conn;

    /** Contenedor de pestañas para las diferentes entidades. */
    private JTabbedPane tabs = new JTabbedPane();

    /**
     * Constructor principal de la aplicación. 
     * Inicializa la ventana, se conecta a la base de datos e inicializa las pestañas.
     */
    public WikiApp() {
        super("HSR Wiki DB Client");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        conectarBD();
        inicializarPestañas();
        add(tabs);
    }

    /**
     * Establece la conexión con la base de datos MariaDB.
     * <p>
     * En caso de error al conectar, muestra un mensaje y termina la ejecución.
     * </p>
     */
    private void conectarBD() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/proyecto2", "root", "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Error de conexión:\n" + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    /**
     * Inicializa las pestañas correspondientes a cada entidad de la base de datos.
     * <p>
     * Crea una instancia de {@link EntidadPanel} para cada tabla y la añade al
     * contenedor de pestañas.
     * </p>
     */
    private void inicializarPestañas() {
        tabs.addTab("Vías",
            new EntidadPanel<>(
                conn,
                "via",
                Arrays.asList("id", "nombre"),
                new ViaFactory()
            ));

        tabs.addTab("Personajes",
            new EntidadPanel<>(
                conn,
                "personaje",
                Arrays.asList("id", "nombre", "rareza", "nivel"),
                new PersonajeFactory()
            ));

        tabs.addTab("Cono",
            new EntidadPanel<>(
                conn,
                "Cono",
                Arrays.asList("id", "nombre", "rareza", "nivel"),
                new ConoFactory()
            ));

        tabs.addTab("Enemigo",
            new EntidadPanel<>(
                conn,
                "Enemigo",
                Arrays.asList("id", "nombre"),
                new EnemigoFactory()
            ));

        tabs.addTab("Equipamiento",
            new EntidadPanel<>(
                conn,
                "Equipamiento",
                Arrays.asList("id", "nombre", "rareza"),
                new EquipamientoFactory()
            ));

        // Pestaña personalizada para Material Enemigo con JOIN
        tabs.addTab("Material Enemigo", new EntidadPanel<MaterialEnemigo>(
            conn,
            "material_enemigo",
            Arrays.asList("id", "nombre", "enemigo_id", "enemigo"),
            new MaterialEnemigoFactory()
        ) {
            /**
             * Carga todos los registros de materiales enemigos, incluyendo el nombre del enemigo relacionado.
             */
            @Override
            protected void cargarTodos() {
                model.clear();
                String sql = """
                    SELECT m.id, m.nombre, m.enemigo_id, e.nombre AS enemigo
                    FROM material_enemigo m
                    JOIN enemigo e ON m.enemigo_id = e.id
                """;
                try (Statement st = conn.createStatement();
                     ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        model.addElement(factory.fromResultSet(rs));
                    }
                } catch (SQLException ex) {
                    mostrarError(ex);
                }
            }
        });
    }

    /**
     * Punto de entrada de la aplicación.
     * Lanza la interfaz gráfica en el hilo de eventos de Swing.
     *
     * @param args argumentos de la línea de comandos (no se usan)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
            new WikiApp().setVisible(true)
        );
    }
}


