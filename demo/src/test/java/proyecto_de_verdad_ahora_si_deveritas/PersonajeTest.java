package proyecto_de_verdad_ahora_si_deveritas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase Personaje.
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
class PersonajeTest {

    /**
     * Prueba el constructor por defecto.
     */
    @Test
    void testConstructorPorDefecto() {
        Personaje personaje = new Personaje();
        assertNull(personaje.getId());
        assertNull(personaje.getNombre());
        assertNull(personaje.getRareza());
        assertNull(personaje.getNivel());
    }

    /**
     * Prueba el constructor con parámetros (sin id).
     */
    @Test
    void testConstructorSinId() {
        Personaje personaje = new Personaje("Arlan", 4, 80);
        assertNull(personaje.getId());
        assertEquals("Arlan", personaje.getNombre());
        assertEquals(4, personaje.getRareza());
        assertEquals(80, personaje.getNivel());
    }

    /**
     * Prueba el constructor con todos los parámetros.
     */
    @Test
    void testConstructorCompleto() {
        Personaje personaje = new Personaje(1, "Asta", 4, 70);
        assertEquals(1, personaje.getId());
        assertEquals("Asta", personaje.getNombre());
        assertEquals(4, personaje.getRareza());
        assertEquals(70, personaje.getNivel());
    }

    /**
     * Prueba los getters y setters.
     */
    @Test
    void testGettersYSetters() {
        Personaje personaje = new Personaje();
        
        personaje.setId(5);
        personaje.setNombre("Bailu");
        personaje.setRareza(5);
        personaje.setNivel(60);
        
        assertEquals(5, personaje.getId());
        assertEquals("Bailu", personaje.getNombre());
        assertEquals(5, personaje.getRareza());
        assertEquals(60, personaje.getNivel());
    }

    /**
     * Prueba el método getValue con propiedades válidas.
     */
    @Test
    void testGetValueConPropiedadesValidas() {
        Personaje personaje = new Personaje(10, "Bronya", 5, 80);
        
        assertEquals(10, personaje.getValue("id"));
        assertEquals("Bronya", personaje.getValue("nombre"));
        assertEquals(5, personaje.getValue("rareza"));
        assertEquals(80, personaje.getValue("nivel"));
    }

    /**
     * Prueba el método getValue con propiedad inválida.
     */
    @Test
    void testGetValueConPropiedadInvalida() {
        Personaje personaje = new Personaje(1, "Clara", 5, 70);
        
        assertNull(personaje.getValue("propiedadInexistente"));
    }

    /**
     * Prueba el método setValue con propiedades válidas.
     */
    @Test
    void testSetValueConPropiedadesValidas() {
        Personaje personaje = new Personaje();
        
        personaje.setValue("nombre", "Dan Heng");
        personaje.setValue("rareza", "4");
        personaje.setValue("nivel", "75");
        
        assertEquals("Dan Heng", personaje.getNombre());
        assertEquals(4, personaje.getRareza());
        assertEquals(75, personaje.getNivel());
    }

    /**
     * Prueba el método setValue con propiedad inválida.
     */
    @Test
    void testSetValueConPropiedadInvalida() {
        Personaje personaje = new Personaje("Gepard", 5, 80);
        String nombreOriginal = personaje.getNombre();
        
        personaje.setValue("propiedadInexistente", "valor");
        
        assertEquals(nombreOriginal, personaje.getNombre());
    }

    /**
     * Prueba el método toString.
     */
    @Test
    void testToString() {
        Personaje personaje = new Personaje("Herta", 5, 80);
        
        assertEquals("Herta", personaje.toString());
    }

    /**
     * Prueba el método toString con nombre null.
     */
    @Test
    void testToStringConNombreNull() {
        Personaje personaje = new Personaje();
        
        assertNull(personaje.toString());
    }

    /**
     * Prueba setValue con números como string.
     */
    @Test
    void testSetValueConNumerosString() {
        Personaje personaje = new Personaje();
        
        personaje.setValue("rareza", "3");
        personaje.setValue("nivel", "50");
        
        assertEquals(3, personaje.getRareza());
        assertEquals(50, personaje.getNivel());
    }

    /**
     * Prueba setValue con números como Integer.
     */
    @Test
    void testSetValueConNumerosInteger() {
        Personaje personaje = new Personaje();
        
        personaje.setValue("rareza", 4);
        personaje.setValue("nivel", 65);
        
        assertEquals(4, personaje.getRareza());
        assertEquals(65, personaje.getNivel());
    }
}
