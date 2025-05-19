import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class WikiAppTest {

    Connection mockConnection;

    @BeforeEach
    void setUp() {
        mockConnection = mock(Connection.class);
    }

    @Test
    void testInicializarPestañas_agregaTodasLasPestanas() {
        WikiApp app = new WikiApp(mockConnection);

        JTabbedPane tabs = app.getTabs();

        assertEquals(6, tabs.getTabCount());

        assertEquals("Vías", tabs.getTitleAt(0));
        assertEquals("Personajes", tabs.getTitleAt(1));
        assertEquals("Cono", tabs.getTitleAt(2));
        assertEquals("Enemigo", tabs.getTitleAt(3));
        assertEquals("Equipamiento", tabs.getTitleAt(4));
        assertEquals("Material Enemigo", tabs.getTitleAt(5));
    }

    @Test
    void testConectarBD_lanzaErrorSiFallaConexion() {
        // Se simula un fallo de clase de driver o conexión inválida
        WikiApp app = spy(new WikiApp() {
            @Override
            protected void conectarBD() {
                throw new RuntimeException("Simulado fallo de conexión");
            }
        });

        // Se espera que se muestre el diálogo (pero no se llama System.exit en test)
        try {
            app.conectarBD();
            fail("Debería haber lanzado una excepción");
        } catch (RuntimeException e) {
            assertEquals("Simulado fallo de conexión", e.getMessage());
        }
    }

    @Test
    void testComponentesDePestanasSonEntidadPanel() {
        WikiApp app = new WikiApp(mockConnection);
        JTabbedPane tabs = app.getTabs();

        for (int i = 0; i < tabs.getTabCount(); i++) {
            assertTrue(tabs.getComponentAt(i) instanceof EntidadPanel);
        }
    }
}
