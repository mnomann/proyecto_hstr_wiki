package proyecto_de_verdad_ahora_si_deveritas.Controller;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

import proyecto_de_verdad_ahora_si_deveritas.Service.ViaService;
import proyecto_de_verdad_ahora_si_deveritas.Via;

/**
 * Pruebas unitarias para la clase ViaController.
 * Verifica que todas las operaciones CRUD del API REST funcionen correctamente.
 * 
 * @version 1.0
 * @since 2025-07-09
 */
@WebMvcTest(ViaController.class)
@AutoConfigureMockMvc(addFilters = false) // Deshabilita filtros de seguridad para las pruebas
@SuppressWarnings("removal") // Suprime advertencias de deprecación para @MockBean
class ViaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ViaService viaService;

    @Autowired
    private ObjectMapper objectMapper;

    private ViaController controller;
    private Via viaEjemplo;
    private List<Via> listaVias;

    /**
     * Configuración inicial antes de cada prueba.
     */
    @BeforeEach
    void setUp() {
        controller = new ViaController(viaService);
        
        // Crear datos de prueba
        viaEjemplo = new Via(1, "Destrucción");
        Via via2 = new Via(2, "Caza");
        Via via3 = new Via(3, "Erudición");
        
        listaVias = Arrays.asList(viaEjemplo, via2, via3);
    }

    /**
     * Pruebas para el endpoint GET /api/vias (listar todas las vías)
     */
    @Test
    @DisplayName("GET /api/vias - Debe devolver todas las vías")
    void testListar() throws Exception {
        // Configurar mock
        when(viaService.listar()).thenReturn(listaVias);

        // Ejecutar y verificar
        mockMvc.perform(get("/api/vias"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].nombre").value("Destrucción"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].nombre").value("Caza"))
                .andExpect(jsonPath("$[2].id").value(3))
                .andExpect(jsonPath("$[2].nombre").value("Erudición"));

        // Verificar que se llamó al servicio
        verify(viaService, times(1)).listar();
    }

    @Test
    @DisplayName("GET /api/vias - Debe devolver lista vacía cuando no hay vías")
    void testListarVacia() throws Exception {
        // Configurar mock para lista vacía
        when(viaService.listar()).thenReturn(Arrays.asList());

        // Ejecutar y verificar
        mockMvc.perform(get("/api/vias"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(0)));

        verify(viaService, times(1)).listar();
    }

    /**
     * Pruebas para el endpoint POST /api/vias (crear nueva vía)
     */
    @Test
    @DisplayName("POST /api/vias - Debe crear una nueva vía")
    void testCrear() throws Exception {
        // Configurar mock
        when(viaService.guardar(any(Via.class))).thenReturn(viaEjemplo);

        // Ejecutar y verificar
        mockMvc.perform(post("/api/vias")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(viaEjemplo)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nombre").value("Destrucción"));

        // Verificar que se llamó al servicio
        verify(viaService, times(1)).guardar(any(Via.class));
    }

    @Test
    @DisplayName("POST /api/vias - Debe manejar vía con datos mínimos")
    void testCrearViaMinima() throws Exception {
        Via viaMinima = new Via(0, "Abundancia");
        Via viaGuardada = new Via(4, "Abundancia");
        
        when(viaService.guardar(any(Via.class))).thenReturn(viaGuardada);

        mockMvc.perform(post("/api/vias")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(viaMinima)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(4))
                .andExpect(jsonPath("$.nombre").value("Abundancia"));

        verify(viaService, times(1)).guardar(any(Via.class));
    }

    /**
     * Pruebas para el endpoint DELETE /api/vias/{id} (eliminar vía)
     */
    @Test
    @DisplayName("DELETE /api/vias/{id} - Debe eliminar la vía con el ID especificado")
    void testEliminar() throws Exception {
        // Configurar mock (método void no necesita retorno)
        doNothing().when(viaService).eliminar(1);

        // Ejecutar y verificar
        mockMvc.perform(delete("/api/vias/1"))
                .andExpect(status().isOk());

        // Verificar que se llamó al servicio
        verify(viaService, times(1)).eliminar(1);
    }

    @Test
    @DisplayName("DELETE /api/vias/{id} - Debe manejar eliminación de vía no existente")
    void testEliminarNoExistente() throws Exception {
        // Configurar mock para no hacer nada (comportamiento normal)
        doNothing().when(viaService).eliminar(999);

        // Ejecutar y verificar
        mockMvc.perform(delete("/api/vias/999"))
                .andExpect(status().isOk());

        verify(viaService, times(1)).eliminar(999);
    }

    /**
     * Pruebas unitarias directas de los métodos del controlador (sin MockMvc)
     */
    @Test
    @DisplayName("Método listar() debe devolver la lista del servicio")
    void testListarMethod() {
        // Configurar mock
        when(viaService.listar()).thenReturn(listaVias);

        // Ejecutar
        List<Via> resultado = controller.listar();

        // Verificar
        assertNotNull(resultado);
        assertEquals(3, resultado.size());
        assertEquals("Destrucción", resultado.get(0).getNombre());
        assertEquals("Caza", resultado.get(1).getNombre());
        assertEquals("Erudición", resultado.get(2).getNombre());
        
        verify(viaService, times(1)).listar();
    }

    @Test
    @DisplayName("Método crear() debe delegar al servicio")
    void testCrearMethod() {
        // Configurar mock
        when(viaService.guardar(viaEjemplo)).thenReturn(viaEjemplo);

        // Ejecutar
        Via resultado = controller.crear(viaEjemplo);

        // Verificar
        assertNotNull(resultado);
        assertEquals(1, resultado.getId());
        assertEquals("Destrucción", resultado.getNombre());
        
        verify(viaService, times(1)).guardar(viaEjemplo);
    }

    @Test
    @DisplayName("Método obtener() debe devolver la vía del servicio")
    void testObtenerMethod() {
        // Configurar mock
        when(viaService.buscarPorId(1)).thenReturn(viaEjemplo);

        // Ejecutar
        Via resultado = controller.obtener(1);

        // Verificar
        assertNotNull(resultado);
        assertEquals(1, resultado.getId());
        assertEquals("Destrucción", resultado.getNombre());
        
        verify(viaService, times(1)).buscarPorId(1);
    }

    @Test
    @DisplayName("Método eliminar() debe delegar al servicio")
    void testEliminarMethod() {
        // Configurar mock
        doNothing().when(viaService).eliminar(1);

        // Ejecutar
        controller.eliminar(1);

        // Verificar que se llamó al servicio
        verify(viaService, times(1)).eliminar(1);
    }

    @Test
    @DisplayName("Debe manejar correctamente IDs con diferentes valores")
    void testDiferentesIds() throws Exception {
        Via viaId0 = new Via(0, "Vía Temporal");
        Via viaIdNegativo = new Via(-1, "Vía Negativa");
        
        when(viaService.buscarPorId(0)).thenReturn(viaId0);
        when(viaService.buscarPorId(-1)).thenReturn(viaIdNegativo);

        // Probar ID = 0
        mockMvc.perform(get("/api/vias/0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(0))
                .andExpect(jsonPath("$.nombre").value("Vía Temporal"));

        // Probar ID negativo
        mockMvc.perform(get("/api/vias/-1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(-1))
                .andExpect(jsonPath("$.nombre").value("Vía Negativa"));
    }
}
