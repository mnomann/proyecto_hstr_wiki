package proyecto_de_verdad_ahora_si_deveritas;

import javax.swing.*;
import java.sql.*;
import java.util.Arrays;

interface Registro {
    Object getValue(String col);
    void setValue(String col, Object val);
}

interface RegistroFactory<T extends Registro> {
    T fromResultSet(ResultSet rs) throws SQLException;
    T createEmpty();
}


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
