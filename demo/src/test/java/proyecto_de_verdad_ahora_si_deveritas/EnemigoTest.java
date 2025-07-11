package proyecto_de_verdad_ahora_si_deveritas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase Enemigo.
 * 
 * <p>Estas pruebas verifican el correcto funcionamiento de:</p>
 * <ul>
 *   <li>Constructores (incluyendo anotaciones Lombok)</li>
 *   <li>Getters y setters</li>
 *   <li>Métodos de la interfaz Registro</li>
 *   <li>Método toString</li>
 * </ul>
 * 
 * @version 1.0
 * @since 2025-07-09
 */
class EnemigoTest {

    /**
     * Prueba el constructor por defecto (Lombok @NoArgsConstructor).
     */
    @Test
    void testConstructorPorDefecto() {
        Enemigo enemigo = new Enemigo();
        assertEquals(0, enemigo.getId());
        assertEquals(0, enemigo.getNivel());
        assertEquals(0, enemigo.getTipoEnemigoId());
        assertNull(enemigo.getNombre());
        assertNull(enemigo.getTipoNombre());
    }

    /**
     * Prueba el constructor completo (Lombok @AllArgsConstructor).
     */
    @Test
    void testConstructorCompleto() {
        Enemigo enemigo = new Enemigo(1, 50, 2, "Soldado Antimaterial", "Autómata");
        assertEquals(1, enemigo.getId());
        assertEquals(50, enemigo.getNivel());
        assertEquals(2, enemigo.getTipoEnemigoId());
        assertEquals("Soldado Antimaterial", enemigo.getNombre());
        assertEquals("Autómata", enemigo.getTipoNombre());
    }

    /**
     * Prueba el constructor básico con ID y nombre.
     */
    @Test
    void testConstructorBasico() {
        Enemigo enemigo = new Enemigo(5, "Araña Cuántica");
        assertEquals(5, enemigo.getId());
        assertEquals("Araña Cuántica", enemigo.getNombre());
        assertEquals(0, enemigo.getNivel());
        assertEquals(0, enemigo.getTipoEnemigoId());
        assertNull(enemigo.getTipoNombre());
    }

    /**
     * Prueba los getters y setters (Lombok @Getter @Setter).
     */
    @Test
    void testGettersYSetters() {
        Enemigo enemigo = new Enemigo();
        
        enemigo.setId(10);
        enemigo.setNombre("Grizzly Autómata");
        enemigo.setNivel(75);
        enemigo.setTipoEnemigoId(3);
        enemigo.setTipoNombre("Mech");
        
        assertEquals(10, enemigo.getId());
        assertEquals("Grizzly Autómata", enemigo.getNombre());
        assertEquals(75, enemigo.getNivel());
        assertEquals(3, enemigo.getTipoEnemigoId());
        assertEquals("Mech", enemigo.getTipoNombre());
    }

    /**
     * Prueba el método getValue con propiedades válidas.
     */
    @Test
    void testGetValueConPropiedadesValidas() {
        Enemigo enemigo = new Enemigo(15, 60, 4, "Centurión Dorado", "Elite");
        
        assertEquals(15, enemigo.getValue("id"));
        assertEquals("Centurión Dorado", enemigo.getValue("nombre"));
        assertEquals(60, enemigo.getValue("nivel"));
        assertEquals(4, enemigo.getValue("tipoEnemigoId"));
        assertEquals("Elite", enemigo.getValue("tipoNombre"));
    }

    /**
     * Prueba el método getValue con propiedad inválida.
     */
    @Test
    void testGetValueConPropiedadInvalida() {
        Enemigo enemigo = new Enemigo(1, "Test");
        
        assertNull(enemigo.getValue("propiedadInexistente"));
    }

    /**
     * Prueba el método setValue con propiedad válida (solo nombre).
     */
    @Test
    void testSetValueConPropiedadValida() {
        Enemigo enemigo = new Enemigo();
        
        enemigo.setValue("nombre", "Lobo Fragmentado");
        
        assertEquals("Lobo Fragmentado", enemigo.getNombre());
    }

    /**
     * Prueba el método setValue con propiedad inválida.
     */
    @Test
    void testSetValueConPropiedadInvalida() {
        Enemigo enemigo = new Enemigo(1, 50, 2, "Enemigo Original", "Tipo Original");
        String nombreOriginal = enemigo.getNombre();
        int nivelOriginal = enemigo.getNivel();
        
        enemigo.setValue("propiedadInexistente", "valor");
        enemigo.setValue("nivel", 100); // no debería cambiar
        
        assertEquals(nombreOriginal, enemigo.getNombre());
        assertEquals(nivelOriginal, enemigo.getNivel());
    }

    /**
     * Prueba que setValue solo permita modificar el nombre.
     */
    @Test
    void testSetValueSoloPermiteModificarNombre() {
        Enemigo enemigo = new Enemigo(1, 50, 2, "Test", "Tipo Test");
        int idOriginal = enemigo.getId();
        int nivelOriginal = enemigo.getNivel();
        
        enemigo.setValue("id", 999);
        enemigo.setValue("nivel", 200);
        enemigo.setValue("tipoEnemigoId", 999);
        
        assertEquals(idOriginal, enemigo.getId());
        assertEquals(nivelOriginal, enemigo.getNivel());
        assertEquals(2, enemigo.getTipoEnemigoId());
    }

    /**
     * Prueba el método toString.
     */
    @Test
    void testToString() {
        Enemigo enemigo = new Enemigo(1, 40, 1, "Vagabundo", "Humanoide");
        
        assertEquals("Vagabundo (Humanoide)", enemigo.toString());
    }

    /**
     * Prueba el método toString con valores null.
     */
    @Test
    void testToStringConValoresNull() {
        Enemigo enemigo = new Enemigo();
        
        assertEquals("null (null)", enemigo.toString());
    }

    /**
     * Prueba setValue con diferentes tipos de datos.
     */
    @Test
    void testSetValueConDiferentesTipos() {
        Enemigo enemigo = new Enemigo();
        
        enemigo.setValue("nombre", "Nuevo Nombre");
        assertEquals("Nuevo Nombre", enemigo.getNombre());
        
        enemigo.setValue("nombre", 12345); // debería convertir a String
        assertEquals("12345", enemigo.getNombre());
    }

    /**
     * Prueba diferentes niveles de enemigo.
     */
    @Test
    void testDiferentesNiveles() {
        Enemigo enemigo1 = new Enemigo(1, 10, 1, "Débil", "Común");
        Enemigo enemigo2 = new Enemigo(2, 50, 2, "Fuerte", "Elite");
        Enemigo enemigo3 = new Enemigo(3, 90, 3, "Jefe", "Boss");
        
        assertEquals(10, enemigo1.getNivel());
        assertEquals(50, enemigo2.getNivel());
        assertEquals(90, enemigo3.getNivel());
    }
}
