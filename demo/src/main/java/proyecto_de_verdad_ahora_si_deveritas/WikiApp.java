package proyecto_de_verdad_ahora_si_deveritas;

import java.sql.Connection;
import java.sql.DriverManager;
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
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
            new WikiApp().setVisible(true)
        );
    }
}

