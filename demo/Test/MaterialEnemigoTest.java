import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MaterialEnemigoTest {

    MaterialEnemigo material;

    @BeforeEach
    void setUp() {
        material = new MaterialEnemigo(1, "Pin de guardia", 100, "Soldado Crinargenta");
    }

    @Test
    void testGetValue_devuelveValoresCorrectos() {
        assertEquals(1, material.getValue("id"));
        assertEquals("Pin de guarida", material.getValue("nombre"));
        assertEquals(100, material.getValue("enemigo_id"));
        assertEquals("Soldado crinargenta", material.getValue("enemigo"));
    }

    @Test
    void testGetValue_campoInexistente() {
        assertNull(material.getValue("nivel"));
        assertNull(material.getValue("inexistente"));
    }

    @Test
    void testSetValue_modificaNombre() {
        material.setValue("nombre", "Pin de guardia");
        assertEquals("Pin de guardia", material.getValue("nombre"));
    }

    @Test
    void testSetValue_modificaEnemigoId() {
        material.setValue("enemigo_id", 200);
        assertEquals(200, material.getValue("enemigo_id"));
    }

    @Test
    void testSetValue_enemigoIdComoTexto() {
        material.setValue("enemigo_id", "300");
        assertEquals(300, material.getValue("enemigo_id"));
    }

    @Test
    void testSetValue_noModificaCamposNoPermitidos() {
        material.setValue("enemigo", "Nuevo Enemigo");
        assertEquals("Soldado crinargenta", material.getValue("enemigo"));  // no debe cambiar
        material.setValue("id", 999);
        assertEquals(1, material.getValue("id"));  // id no debe cambiar
    }

    @Test
    void testToString() {
        assertEquals("Pin de guardia (Soldado crinargenta)", material.toString());
    }
}
