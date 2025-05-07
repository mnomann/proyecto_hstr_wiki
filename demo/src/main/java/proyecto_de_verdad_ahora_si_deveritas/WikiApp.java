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
                "jdbc:mariadb://localhost:3306/proyecto2", "root", "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Error de conexión:\n" + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    private void inicializarPestañas() {
        tabs.addTab("Vías",
            new EntidadPanel<>(
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
        tabs.addTab("Cono",
            new EntidadPanel<Cono>(
                conn,
                "Cono",
                Arrays.asList("id","nombre","rareza","nivel"),
                new ConoFactory()
            ));
        tabs.addTab("Enemigo",
            new EntidadPanel<Enemigo>(
                conn,
                "Enemigo",
                Arrays.asList("id","nombre"),
                new EnemigoFactory()
            ));
        tabs.addTab("Equipamiento",
            new EntidadPanel<Equipamiento>(
                conn,
                "Equipamiento",
                Arrays.asList("id","nombre","rareza"),
                new EquipamientoFactory()
            ));
        tabs.addTab("Material Enemigo", new EntidadPanel<MaterialEnemigo>(
            conn,
            "material_enemigo",
            Arrays.asList("id", "nombre", "enemigo_id", "enemigo"),
            new MaterialEnemigoFactory()
        ) {
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
            new WikiApp().setVisible(true)
        );
    }
}

