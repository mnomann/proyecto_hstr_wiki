package proyecto_de_verdad_ahora_si_deveritas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase Via.
 * 
 * <p>Estas pruebas verifican el correcto funcionamiento de:</p>
 * <ul>
 *   <li>Constructores</li>
 *   <li>Getters y setters</li>
 *   <li>Métodos de la interfaz Registro</li>
 *   <li>Método toString</li>
 * </ul>
 * 
 * @version 1.0
 * @since 2025-07-09
 */
class ViaTest {

    /**
     * Prueba el constructor por defecto.
     */
    @Test
    void testConstructorPorDefecto() {
        Via via = new Via();
        assertEquals(0, via.getId());
        assertNull(via.getNombre());
    }

    /**
     * Prueba el constructor con parámetros.
     */
    @Test
    void testConstructorConParametros() {
        Via via = new Via(1, "Destrucción");
        assertEquals(1, via.getId());
        assertEquals("Destrucción", via.getNombre());
    }

    /**
     * Prueba los getters y setters.
     */
    @Test
    void testGettersYSetters() {
        Via via = new Via();
        
        via.setId(2);
        via.setNombre("Preservación");
        
        assertEquals(2, via.getId());
        assertEquals("Preservación", via.getNombre());
    }

    /**
     * Prueba el método getValue con propiedades válidas.
     */
    @Test
    void testGetValueConPropiedadesValidas() {
        Via via = new Via(3, "Erudición");
        
        assertEquals(3, via.getValue("id"));
        assertEquals("Erudición", via.getValue("nombre"));
    }

    /**
     * Prueba el método getValue con propiedad inválida.
     */
    @Test
    void testGetValueConPropiedadInvalida() {
        Via via = new Via(1, "Armonía");
        
        assertNull(via.getValue("propiedadInexistente"));
    }

    /**
     * Prueba el método setValue con propiedad válida.
     */
    @Test
    void testSetValueConPropiedadValida() {
        Via via = new Via(1, "Cacería");
        
        via.setValue("nombre", "Abundancia");
        
        assertEquals("Abundancia", via.getNombre());
    }

    /**
     * Prueba el método setValue con propiedad inválida.
     */
    @Test
    void testSetValueConPropiedadInvalida() {
        Via via = new Via(1, "Nihilidad");
        String nombreOriginal = via.getNombre();
        
        via.setValue("propiedadInexistente", "valor");
        
        assertEquals(nombreOriginal, via.getNombre());
    }

    /**
     * Prueba el método toString.
     */
    @Test
    void testToString() {
        Via via = new Via(1, "Destrucción");
        
        assertEquals("Destrucción", via.toString());
    }

    /**
     * Prueba el método toString con nombre null.
     */
    @Test
    void testToStringConNombreNull() {
        Via via = new Via();
        
        assertNull(via.toString());
    }
}
