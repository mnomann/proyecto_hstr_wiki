import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnemigoTest {

    Enemigo enemigo;

    @BeforeEach
    void setUp() {
        enemigo = new Enemigo(10, "Saqueador del vacio");
        enemigo.tipoNombre = "Enemigo Medio";
        enemigo.nivel = 50;
        enemigo.tipoEnemigoId = 3;
    }

    @Test
    void testGetValue_devuelveValoresCorrectos() {
        assertEquals(10, enemigo.getValue("id"));
        assertEquals("saqueador", enemigo.getValue("nombre"));
    }

    @Test
    void testGetValue_conCampoInvalido_retornaNull() {
        assertNull(enemigo.getValue("nivel"));  // no expuesto por getValue
        assertNull(enemigo.getValue("tipoNombre")); // tampoco
        assertNull(enemigo.getValue("noExiste"));
    }

    @Test
    void testSetValue_modificaNombre() {
        enemigo.setValue("nombre", "Barion");
        assertEquals("Barion", enemigo.getValue("nombre"));
    }

    @Test
    void testSetValue_noModificaOtrosCampos() {
        enemigo.setValue("id", 999); // no debe tener efecto
        assertEquals(10, enemigo.getValue("id"));
    }

    @Test
    void testToString_formatoCorrecto() {
        assertEquals("Saqueador (Enemigo medio)", enemigo.toString());
    }

    @Test
    void testToString_conTipoNombreNull() {
        enemigo.tipoNombre = null;
        assertEquals("Saqueador (null)", enemigo.toString()); // Comportamiento actual
    }
}
