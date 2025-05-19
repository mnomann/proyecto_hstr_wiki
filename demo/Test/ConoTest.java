import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConoTest {

    Cono cono;

    @BeforeEach
    void setUp() {
        cono = new Cono(1, "Sagacidad", 4, 20);
    }

    @Test
    void testGetValue() {
        assertEquals(1, cono.getValue("id"));
        assertEquals("Sagacidad", cono.getValue("nombre"));
        assertEquals(4, cono.getValue("rareza"));
        assertEquals(20, cono.getValue("nivel"));
    }

    @Test
    void testSetValue_modificaCamposCorrectos() {
        cono.setValue("nombre", "Mediacion");
        cono.setValue("rareza", 5);
        cono.setValue("nivel", 30);

        assertEquals("Mediacion", cono.getValue("nombre"));
        assertEquals(5, cono.getValue("rareza"));
        assertEquals(30, cono.getValue("nivel"));
    }

    @Test
    void testSetValue_noModificaId() {
        cono.setValue("id", 999);  // No debería tener efecto
        assertEquals(1, cono.getValue("id")); // El ID sigue siendo 1
    }

    @Test
    void testToString() {
        assertEquals("Sagacidad", cono.toString());
    }

    @Test
    void testSetValue_conValoresDeTexto() {
        cono.setValue("rareza", "3");
        cono.setValue("nivel", "10");

        assertEquals(3, cono.getValue("rareza"));
        assertEquals(10, cono.getValue("nivel"));
    }

    @Test
    void testGetValueCampoInvalido_retornaNull() {
        assertNull(cono.getValue("inexistente"));
    }
}
