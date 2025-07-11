package proyecto_de_verdad_ahora_si_deveritas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase Equipamiento.
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
class EquipamientoTest {

    /**
     * Prueba el constructor por defecto.
     */
    @Test
    void testConstructorPorDefecto() {
        Equipamiento equipamiento = new Equipamiento();
        assertNull(equipamiento.getId());
        assertNull(equipamiento.getNombre());
        assertNull(equipamiento.getRareza());
    }

    /**
     * Prueba el constructor sin ID.
     */
    @Test
    void testConstructorSinId() {
        Equipamiento equipamiento = new Equipamiento("Espada de Fuego", 4);
        assertNull(equipamiento.getId());
        assertEquals("Espada de Fuego", equipamiento.getNombre());
        assertEquals(4, equipamiento.getRareza());
    }

    /**
     * Prueba el constructor completo.
     */
    @Test
    void testConstructorCompleto() {
        Equipamiento equipamiento = new Equipamiento(1, "Reliquia Ancestral", 5);
        assertEquals(1, equipamiento.getId());
        assertEquals("Reliquia Ancestral", equipamiento.getNombre());
        assertEquals(5, equipamiento.getRareza());
    }

    /**
     * Prueba los getters y setters.
     */
    @Test
    void testGettersYSetters() {
        Equipamiento equipamiento = new Equipamiento();
        
        equipamiento.setId(10);
        equipamiento.setNombre("Casco de Hierro");
        equipamiento.setRareza(3);
        
        assertEquals(10, equipamiento.getId());
        assertEquals("Casco de Hierro", equipamiento.getNombre());
        assertEquals(3, equipamiento.getRareza());
    }

    /**
     * Prueba el método getValue con propiedades válidas.
     */
    @Test
    void testGetValueConPropiedadesValidas() {
        Equipamiento equipamiento = new Equipamiento(5, "Armadura Divina", 5);
        
        assertEquals(5, equipamiento.getValue("id"));
        assertEquals("Armadura Divina", equipamiento.getValue("nombre"));
        assertEquals(5, equipamiento.getValue("rareza"));
    }

    /**
     * Prueba el método getValue con propiedad inválida.
     */
    @Test
    void testGetValueConPropiedadInvalida() {
        Equipamiento equipamiento = new Equipamiento("Test", 1);
        
        assertNull(equipamiento.getValue("propiedadInexistente"));
    }

    /**
     * Prueba el método setValue con propiedades válidas.
     */
    @Test
    void testSetValueConPropiedadesValidas() {
        Equipamiento equipamiento = new Equipamiento();
        
        equipamiento.setValue("nombre", "Anillo Mágico");
        equipamiento.setValue("rareza", "4");
        
        assertEquals("Anillo Mágico", equipamiento.getNombre());
        assertEquals(4, equipamiento.getRareza());
    }

    /**
     * Prueba el método setValue con propiedad inválida.
     */
    @Test
    void testSetValueConPropiedadInvalida() {
        Equipamiento equipamiento = new Equipamiento("Escudo Original", 2);
        String nombreOriginal = equipamiento.getNombre();
        
        equipamiento.setValue("propiedadInexistente", "valor");
        
        assertEquals(nombreOriginal, equipamiento.getNombre());
    }

    /**
     * Prueba que setValue no permita modificar el ID.
     */
    @Test
    void testSetValueNoPermiteModificarId() {
        Equipamiento equipamiento = new Equipamiento(1, "Test", 1);
        Integer idOriginal = equipamiento.getId();
        
        equipamiento.setValue("id", 999);
        
        assertEquals(idOriginal, equipamiento.getId());
    }

    /**
     * Prueba el método toString.
     */
    @Test
    void testToString() {
        Equipamiento equipamiento = new Equipamiento(1, "Bastón de Poder", 5);
        
        String expected = "Equipamiento{id=1, nombre='Bastón de Poder', rareza=5}";
        assertEquals(expected, equipamiento.toString());
    }

    /**
     * Prueba el método toString con valores null.
     */
    @Test
    void testToStringConValoresNull() {
        Equipamiento equipamiento = new Equipamiento();
        
        String expected = "Equipamiento{id=null, nombre='null', rareza=null}";
        assertEquals(expected, equipamiento.toString());
    }

    /**
     * Prueba setValue con números como string.
     */
    @Test
    void testSetValueConNumeroString() {
        Equipamiento equipamiento = new Equipamiento();
        
        equipamiento.setValue("rareza", "3");
        
        assertEquals(3, equipamiento.getRareza());
    }

    /**
     * Prueba setValue con números como Integer.
     */
    @Test
    void testSetValueConNumeroInteger() {
        Equipamiento equipamiento = new Equipamiento();
        
        equipamiento.setValue("rareza", 2);
        
        assertEquals(2, equipamiento.getRareza());
    }

    /**
     * Prueba con diferentes niveles de rareza.
     */
    @Test
    void testDiferentesNivelesRareza() {
        Equipamiento equipamiento1 = new Equipamiento("Común", 1);
        Equipamiento equipamiento2 = new Equipamiento("Épico", 4);
        Equipamiento equipamiento3 = new Equipamiento("Legendario", 5);
        
        assertEquals(1, equipamiento1.getRareza());
        assertEquals(4, equipamiento2.getRareza());
        assertEquals(5, equipamiento3.getRareza());
    }
}
