package proyecto_de_verdad_ahora_si_deveritas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase MaterialEnemigo.
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
class MaterialEnemigoTest {

    /**
     * Prueba el constructor por defecto.
     */
    @Test
    void testConstructorPorDefecto() {
        MaterialEnemigo material = new MaterialEnemigo();
        assertNull(material.getId());
        assertNull(material.getNombre());
        assertNull(material.getEnemigoId());
        assertNull(material.getEnemigo());
    }

    /**
     * Prueba el constructor sin ID.
     */
    @Test
    void testConstructorSinId() {
        MaterialEnemigo material = new MaterialEnemigo("Fragmento Etéreo", 1, "Soldado Antimaterial");
        assertNull(material.getId());
        assertEquals("Fragmento Etéreo", material.getNombre());
        assertEquals(1, material.getEnemigoId());
        assertEquals("Soldado Antimaterial", material.getEnemigo());
    }

    /**
     * Prueba el constructor completo.
     */
    @Test
    void testConstructorCompleto() {
        MaterialEnemigo material = new MaterialEnemigo(5, "Engranaje Oxidado", 2, "Autómata Grizzly");
        assertEquals(5, material.getId());
        assertEquals("Engranaje Oxidado", material.getNombre());
        assertEquals(2, material.getEnemigoId());
        assertEquals("Autómata Grizzly", material.getEnemigo());
    }

    /**
     * Prueba los getters y setters.
     */
    @Test
    void testGettersYSetters() {
        MaterialEnemigo material = new MaterialEnemigo();
        
        material.setId(10);
        material.setNombre("Núcleo Artificial");
        material.setEnemigoId(3);
        material.setEnemigo("Autómata Centurión");
        
        assertEquals(10, material.getId());
        assertEquals("Núcleo Artificial", material.getNombre());
        assertEquals(3, material.getEnemigoId());
        assertEquals("Autómata Centurión", material.getEnemigo());
    }

    /**
     * Prueba el método getValue con propiedades válidas.
     */
    @Test
    void testGetValueConPropiedadesValidas() {
        MaterialEnemigo material = new MaterialEnemigo(15, "Chip Cuántico", 4, "Araña Quantum");
        
        assertEquals(15, material.getValue("id"));
        assertEquals("Chip Cuántico", material.getValue("nombre"));
        assertEquals(4, material.getValue("enemigo_id"));
        assertEquals("Araña Quantum", material.getValue("enemigo"));
    }

    /**
     * Prueba el método getValue con propiedad inválida.
     */
    @Test
    void testGetValueConPropiedadInvalida() {
        MaterialEnemigo material = new MaterialEnemigo(1, "Material Test", 1, "Enemigo Test");
        
        assertNull(material.getValue("propiedadInexistente"));
    }

    /**
     * Prueba el método setValue con propiedades válidas.
     */
    @Test
    void testSetValueConPropiedadesValidas() {
        MaterialEnemigo material = new MaterialEnemigo();
        
        material.setValue("nombre", "Esencia Elemental");
        material.setValue("enemigo_id", "7");
        
        assertEquals("Esencia Elemental", material.getNombre());
        assertEquals(7, material.getEnemigoId());
    }

    /**
     * Prueba el método setValue con propiedad inválida.
     */
    @Test
    void testSetValueConPropiedadInvalida() {
        MaterialEnemigo material = new MaterialEnemigo("Material Original", 1, "Enemigo Original");
        String nombreOriginal = material.getNombre();
        
        material.setValue("propiedadInexistente", "valor");
        
        assertEquals(nombreOriginal, material.getNombre());
    }

    /**
     * Prueba el método toString.
     */
    @Test
    void testToString() {
        MaterialEnemigo material = new MaterialEnemigo(1, "Fragmento Etéreo", 1, "Soldado Antimaterial");
        
        assertEquals("Fragmento Etéreo (de: Soldado Antimaterial)", material.toString());
    }

    /**
     * Prueba el método toString con valores null.
     */
    @Test
    void testToStringConValoresNull() {
        MaterialEnemigo material = new MaterialEnemigo();
        
        assertEquals("null (de: null)", material.toString());
    }

    /**
     * Prueba setValue con números como string.
     */
    @Test
    void testSetValueConNumeroString() {
        MaterialEnemigo material = new MaterialEnemigo();
        
        material.setValue("enemigo_id", "25");
        
        assertEquals(25, material.getEnemigoId());
    }

    /**
     * Prueba setValue con números como Integer.
     */
    @Test
    void testSetValueConNumeroInteger() {
        MaterialEnemigo material = new MaterialEnemigo();
        
        material.setValue("enemigo_id", 30);
        
        assertEquals(30, material.getEnemigoId());
    }

    /**
     * Prueba que setValue no afecte campos no modificables.
     */
    @Test
    void testSetValueNoAfectaCamposNoModificables() {
        MaterialEnemigo material = new MaterialEnemigo(1, "Test", 1, "Test Enemigo");
        String enemigoOriginal = material.getEnemigo();
        
        material.setValue("enemigo", "Nuevo Enemigo");
        
        assertEquals(enemigoOriginal, material.getEnemigo());
    }
}
