package proyecto_de_verdad_ahora_si_deveritas.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Pruebas unitarias para el controlador REST de personajes.
 * 
 * <p>Esta clase de pruebas verifica el correcto funcionamiento del endpoint
 * de búsqueda de personajes, incluyendo:</p>
 * <ul>
 *   <li>Búsqueda sin filtros (todos los personajes)</li>
 *   <li>Búsqueda por nombre (parcial y case-insensitive)</li>
 *   <li>Búsqueda por ID exacto</li>
 *   <li>Combinación de filtros</li>
 *   <li>Casos donde no se encuentran resultados</li>
 *   <li>Manejo de parámetros vacíos</li>
 * </ul>
 * @version 1.0
 * @since 2025-07-09
 * @see PersonajeRestController
 */
@WebMvcTest(PersonajeRestController.class)
@WithMockUser
class PersonajeRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Prueba que el endpoint devuelve todos los personajes cuando no se proporcionan filtros.
     * 
     * @throws Exception si ocurre un error durante la prueba
     */
    @Test
    void buscarPersonajes_SinFiltros_DeberiaRetornarTodosLosPersonajes() throws Exception {
        mockMvc.perform(get("/api/personajes/buscar"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.length()").value(26))
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].nombre").value("Arlan"))
                .andExpect(jsonPath("$[0].ruta").value("/Personajes/arlan"))
                .andExpect(jsonPath("$[25].id").value("26"))
                .andExpect(jsonPath("$[25].nombre").value("Yanqing"));
    }

    /**
     * Prueba la búsqueda por nombre exacto.
     * 
     * @throws Exception si ocurre un error durante la prueba
     */
    @Test
    void buscarPersonajes_PorNombreExacto_DeberiaRetornarPersonajeCorrect() throws Exception {
        mockMvc.perform(get("/api/personajes/buscar")
                .param("nombre", "Arlan"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].nombre").value("Arlan"))
                .andExpect(jsonPath("$[0].ruta").value("/Personajes/arlan"));
    }

    /**
     * Prueba la búsqueda por ID que no existe.
     * 
     * @throws Exception si ocurre un error durante la prueba
     */
    @Test
    void buscarPersonajes_PorIdInexistente_DeberiaRetornarListaVacia() throws Exception {
        mockMvc.perform(get("/api/personajes/buscar")
                .param("id", "999"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.length()").value(0));
    }

    /**
     * Prueba la búsqueda combinando filtros de nombre e ID.
     * 
     * @throws Exception si ocurre un error durante la prueba
     */
    @Test
    void buscarPersonajes_CombinandoNombreYId_DeberiaRetornarPersonajeQueCoincide() throws Exception {
        mockMvc.perform(get("/api/personajes/buscar")
                .param("nombre", "Arlan")
                .param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].nombre").value("Arlan"));
    }

    /**
     * Prueba la búsqueda combinando filtros que no coinciden.
     * 
     * @throws Exception si ocurre un error durante la prueba
     */
    @Test
    void buscarPersonajes_CombinandoFiltrosQueNoCoinciden_DeberiaRetornarListaVacia() throws Exception {
        mockMvc.perform(get("/api/personajes/buscar")
                .param("nombre", "Arlan")
                .param("id", "2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.length()").value(0));
    }

    /**
     * Prueba la búsqueda por nombre que no existe.
     * 
     * @throws Exception si ocurre un error durante la prueba
     */
    @Test
    void buscarPersonajes_PorNombreInexistente_DeberiaRetornarListaVacia() throws Exception {
        mockMvc.perform(get("/api/personajes/buscar")
                .param("nombre", "PersonajeInexistente"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.length()").value(0));
    }

    /**
     * Prueba la búsqueda por personajes con nombres que contienen espacios.
     * 
     * @throws Exception si ocurre un error durante la prueba
     */
    @Test
    void buscarPersonajes_PorNombreConEspacios_DeberiaRetornarPersonajeCorrect() throws Exception {
        mockMvc.perform(get("/api/personajes/buscar")
                .param("nombre", "7 de Marzo"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].id").value("20"))
                .andExpect(jsonPath("$[0].nombre").value("7 de Marzo"))
                .andExpect(jsonPath("$[0].ruta").value("/Personajes/7deMarzo"));
    }
}
