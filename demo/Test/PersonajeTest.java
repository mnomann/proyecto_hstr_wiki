import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonajeTest {

    Personaje personaje;

    @BeforeEach
    void setUp() {
        personaje = new Personaje(1, "Kafka", 5, 80);
    }

    @Test
    void testGetValue_devuelveValoresCorrectos() {
        assertEquals(1, personaje.getValue("id"));
        assertEquals("Kafka", personaje.getValue("nombre"));
        assertEquals(5, personaje.getValue("rareza"));
        assertEquals(80, personaje.getValue("nivel"));
    }

    @Test
    void testGetValue_campoInvalido() {
        assertNull(personaje.getValue("elemento"));
        assertNull(personaje.getValue("otro"));
    }

    @Test
    void testSetValue_modificaNombre() {
        personaje.setValue("nombre", "Silver Wolf");
        assertEquals("Silver Wolf", personaje.getValue("nombre"));
    }

    @Test
    void testSetValue_modificaRareza() {
        personaje.setValue("rareza", 4);
        assertEquals(4, personaje.getValue("rareza"));
    }

    @Test
    void testSetValue_modificaNivel() {
        personaje.setValue("nivel", 90);
        assertEquals(90, personaje.getValue("nivel"));
    }

    @Test
    void testSetValue_conversionDesdeTexto() {
        personaje.setValue("rareza", "3");
        personaje.setValue("nivel", "60");
        assertEquals(3, personaje.getValue("rareza"));
        assertEquals(60, personaje.getValue("nivel"));
    }

    @Test
    void testSetValue_noModificaCamposInvalidos() {
        personaje.setValue("id", 99);
        assertEquals(1, personaje.getValue("id")); // no debe cambiar
    }

    @Test
    void testToString() {
        assertEquals("Kafka", personaje.toString());
    }
}
