import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ViaTest {

    Via via;

    @BeforeEach
    void setUp() {
        via = new Via(1, "Cacería");
    }

    @Test
    void testGetValue_devuelveValoresCorrectos() {
        assertEquals(1, via.getValue("id"));
        assertEquals("Cacería", via.getValue("nombre"));
    }

    @Test
    void testGetValue_campoInvalido() {
        assertNull(via.getValue("rareza"));
        assertNull(via.getValue("otro"));
    }

    @Test
    void testSetValue_modificaNombre() {
        via.setValue("nombre", "Erudición");
        assertEquals("Erudición", via.getValue("nombre"));
    }

    @Test
    void testSetValue_conversionDesdeTexto() {
        via.setValue("nombre", new StringBuilder("Destrucción")); // cualquier tipo .toString()
        assertEquals("Destrucción", via.getValue("nombre"));
    }

    @Test
    void testSetValue_noModificaCamposInvalidos() {
        via.setValue("id", 10); // debería ignorarse
        assertEquals(1, via.getValue("id"));
    }

    @Test
    void testToString() {
        assertEquals("Cacería", via.toString());
    }
}
