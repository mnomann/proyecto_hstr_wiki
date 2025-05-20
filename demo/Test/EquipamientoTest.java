import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EquipamientoTest {

    Equipamiento equipamiento;

    @BeforeEach
    void setUp() {
        equipamiento = new Equipamiento(1, "Forjador de lava", 5);
    }

    @Test
    void testGetValue_devuelveValoresCorrectos() {
        assertEquals(1, equipamiento.getValue("id"));
        assertEquals("Forjador de lava", equipamiento.getValue("nombre"));
        assertEquals(5, equipamiento.getValue("rareza"));
    }

    @Test
    void testGetValue_conCampoInvalido_retornaNull() {
        assertNull(equipamiento.getValue("nivel"));
        assertNull(equipamiento.getValue("inexistente"));
    }

    @Test
    void testSetValue_modificaNombre() {
        equipamiento.setValue("nombre", "Diferenciador celestial");
        assertEquals("Diferenciador celestial", equipamiento.getValue("nombre"));
    }

    @Test
    void testSetValue_modificaRareza() {
        equipamiento.setValue("rareza", 3);
        assertEquals(3, equipamiento.getValue("rareza"));
    }

    @Test
    void testSetValue_aceptaEnteroComoTexto() {
        equipamiento.setValue("rareza", "4");
        assertEquals(4, equipamiento.getValue("rareza"));
    }

    @Test
    void testSetValue_noModificaId() {
        equipamiento.setValue("id", 99);
        assertEquals(1, equipamiento.getValue("id"));  // id no se puede cambiar
    }

    @Test
    void testToString_devuelveNombre() {
        assertEquals("Forjador de lava", equipamiento.toString());
    }
}
