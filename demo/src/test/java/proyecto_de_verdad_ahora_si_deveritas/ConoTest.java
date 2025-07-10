package proyecto_de_verdad_ahora_si_deveritas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase Cono.
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
class ConoTest {

    /**
     * Prueba el constructor por defecto (Lombok @NoArgsConstructor).
     */
    @Test
    void testConstructorPorDefecto() {
        Cono cono = new Cono();
        assertEquals(0, cono.getId());
        assertEquals(0, cono.getRareza());
        assertEquals(0, cono.getNivel());
        assertNull(cono.getNombre());
    }

    /**
     * Prueba el constructor completo (Lombok @AllArgsConstructor).
     */
    @Test
    void testConstructorCompleto() {
        Cono cono = new Cono(1, "Paso a Paso", 3, 80);
        assertEquals(1, cono.getId());
        assertEquals("Paso a Paso", cono.getNombre());
        assertEquals(3, cono.getRareza());
        assertEquals(80, cono.getNivel());
    }

    /**
     * Prueba los getters y setters (Lombok @Getter @Setter).
     */
    @Test
    void testGettersYSetters() {
        Cono cono = new Cono();
        
        cono.setId(5);
        cono.setNombre("Baile de Sables");
        cono.setRareza(4);
        cono.setNivel(70);
        
        assertEquals(5, cono.getId());
        assertEquals("Baile de Sables", cono.getNombre());
        assertEquals(4, cono.getRareza());
        assertEquals(70, cono.getNivel());
    }

    /**
     * Prueba el método getValue con propiedades válidas.
     */
    @Test
    void testGetValueConPropiedadesValidas() {
        Cono cono = new Cono(10, "Noche en el Cosmos", 5, 80);
        
        assertEquals(10, cono.getValue("id"));
        assertEquals("Noche en el Cosmos", cono.getValue("nombre"));
        assertEquals(5, cono.getValue("rareza"));
        assertEquals(80, cono.getValue("nivel"));
    }

    /**
     * Prueba el método getValue con propiedad inválida.
     */
    @Test
    void testGetValueConPropiedadInvalida() {
        Cono cono = new Cono(1, "Test", 3, 50);
        
        assertNull(cono.getValue("propiedadInexistente"));
    }

    /**
     * Prueba el método setValue con propiedades válidas.
     */
    @Test
    void testSetValueConPropiedadesValidas() {
        Cono cono = new Cono();
        
        cono.setValue("nombre", "Algo Irremplaazable");
        cono.setValue("rareza", "5");
        cono.setValue("nivel", "80");
        
        assertEquals("Algo Irremplaazable", cono.getNombre());
        assertEquals(5, cono.getRareza());
        assertEquals(80, cono.getNivel());
    }

    /**
     * Prueba el método setValue con propiedad inválida.
     */
    @Test
    void testSetValueConPropiedadInvalida() {
        Cono cono = new Cono(1, "Original", 3, 50);
        String nombreOriginal = cono.getNombre();
        
        cono.setValue("propiedadInexistente", "valor");
        
        assertEquals(nombreOriginal, cono.getNombre());
    }

    /**
     * Prueba que setValue no permita modificar el ID.
     */
    @Test
    void testSetValueNoPermiteModificarId() {
        Cono cono = new Cono(1, "Test", 3, 50);
        int idOriginal = cono.getId();
        
        cono.setValue("id", 999);
        
        assertEquals(idOriginal, cono.getId());
    }

    /**
     * Prueba el método toString (Lombok @ToString).
     */
    @Test
    void testToString() {
        Cono cono = new Cono(1, "Momento de la Victoria", 4, 60);
        
        String resultado = cono.toString();
        assertTrue(resultado.contains("Cono"));
        assertTrue(resultado.contains("id=1"));
        assertTrue(resultado.contains("nombre=Momento de la Victoria"));
        assertTrue(resultado.contains("rareza=4"));
        assertTrue(resultado.contains("nivel=60"));
    }

    /**
     * Prueba setValue con números como string.
     */
    @Test
    void testSetValueConNumerosString() {
        Cono cono = new Cono();
        
        cono.setValue("rareza", "3");
        cono.setValue("nivel", "65");
        
        assertEquals(3, cono.getRareza());
        assertEquals(65, cono.getNivel());
    }

    /**
     * Prueba setValue con números como Integer.
     */
    @Test
    void testSetValueConNumerosInteger() {
        Cono cono = new Cono();
        
        cono.setValue("rareza", 4);
        cono.setValue("nivel", 75);
        
        assertEquals(4, cono.getRareza());
        assertEquals(75, cono.getNivel());
    }

    /**
     * Prueba diferentes niveles de rareza.
     */
    @Test
    void testDiferentesNivelesRareza() {
        Cono cono3 = new Cono(1, "Cono 3 Estrellas", 3, 50);
        Cono cono4 = new Cono(2, "Cono 4 Estrellas", 4, 60);
        Cono cono5 = new Cono(3, "Cono 5 Estrellas", 5, 80);
        
        assertEquals(3, cono3.getRareza());
        assertEquals(4, cono4.getRareza());
        assertEquals(5, cono5.getRareza());
    }

    /**
     * Prueba diferentes niveles de cono.
     */
    @Test
    void testDiferentesNiveles() {
        Cono conoBasico = new Cono(1, "Básico", 3, 1);
        Cono conoMedio = new Cono(2, "Medio", 4, 40);
        Cono conoAvanzado = new Cono(3, "Avanzado", 5, 80);
        
        assertEquals(1, conoBasico.getNivel());
        assertEquals(40, conoMedio.getNivel());
        assertEquals(80, conoAvanzado.getNivel());
    }

    /**
     * Prueba el comportamiento con valores límite.
     */
    @Test
    void testValoresLimite() {
        Cono cono = new Cono();
        
        cono.setValue("rareza", "1");
        cono.setValue("nivel", "1");
        
        assertEquals(1, cono.getRareza());
        assertEquals(1, cono.getNivel());
        
        cono.setValue("rareza", "5");
        cono.setValue("nivel", "80");
        
        assertEquals(5, cono.getRareza());
        assertEquals(80, cono.getNivel());
    }
}
