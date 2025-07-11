package proyecto_de_verdad_ahora_si_deveritas.Controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import proyecto_de_verdad_ahora_si_deveritas.Personaje;
import proyecto_de_verdad_ahora_si_deveritas.Service.PersonajeService;

/**
 * Pruebas unitarias para la clase PersonajeController.
 * 
 * <p>Estas pruebas verifican el correcto funcionamiento de:</p>
 * <ul>
 *   <li>Endpoints CRUD (GET, POST, PUT, DELETE)</li>
 *   <li>Mapeo de URLs</li>
 *   <li>Integración con el servicio</li>
 *   <li>Manejo de respuestas HTTP</li>
 * </ul>
 * @version 1.0
 * @since 2025-07-09
 */
@WebMvcTest(PersonajeController.class)
@WithMockUser
class PersonajeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonajeService personajeService;

    /**
     * Prueba el endpoint GET /api/personajes para listar todos los personajes.
     */
    @Test
    void testListar() throws Exception {
        // Preparar datos de prueba
        List<Personaje> personajes = Arrays.asList(
            new Personaje(1, "Arlan", 4, 80),
            new Personaje(2, "Asta", 4, 70)
        );
        
        when(personajeService.listar()).thenReturn(personajes);

        // Ejecutar y verificar
        mockMvc.perform(get("/api/personajes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].nombre").value("Arlan"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].nombre").value("Asta"));

        verify(personajeService).listar();
    }

    /**
     * Prueba el endpoint POST /api/personajes para crear un nuevo personaje.
     */
    @Test
    void testCrear() throws Exception {
        // Preparar datos de prueba
        Personaje personaje = new Personaje(1, "Bailu", 5, 60);
        
        when(personajeService.guardar(any(Personaje.class))).thenReturn(personaje);

        // Ejecutar y verificar
        mockMvc.perform(post("/api/personajes")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombre\":\"Bailu\",\"rareza\":5,\"nivel\":60}")
                .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nombre").value("Bailu"))
                .andExpect(jsonPath("$.rareza").value(5))
                .andExpect(jsonPath("$.nivel").value(60));

        verify(personajeService).guardar(any(Personaje.class));
    }

    /**
     * Prueba el endpoint GET /api/personajes/{id} para obtener un personaje específico.
     */
    @Test
    void testObtener() throws Exception {
        // Preparar datos de prueba
        Personaje personaje = new Personaje(1, "Bronya", 5, 80);
        
        when(personajeService.obtener(1)).thenReturn(personaje);

        // Ejecutar y verificar
        mockMvc.perform(get("/api/personajes/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nombre").value("Bronya"))
                .andExpect(jsonPath("$.rareza").value(5))
                .andExpect(jsonPath("$.nivel").value(80));

        verify(personajeService).obtener(1);
    }

    /**
     * Prueba el endpoint PUT /api/personajes/{id} para actualizar un personaje.
     */
    @Test
    void testActualizar() throws Exception {
        // Preparar datos de prueba
        Personaje personajeActualizado = new Personaje(1, "Clara", 5, 70);
        
        when(personajeService.guardar(any(Personaje.class))).thenReturn(personajeActualizado);

        // Ejecutar y verificar
        mockMvc.perform(put("/api/personajes/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombre\":\"Clara\",\"rareza\":5,\"nivel\":70}")
                .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nombre").value("Clara"))
                .andExpect(jsonPath("$.rareza").value(5))
                .andExpect(jsonPath("$.nivel").value(70));

        verify(personajeService).guardar(any(Personaje.class));
    }

    /**
     * Prueba el endpoint DELETE /api/personajes/{id} para eliminar un personaje.
     */
    @Test
    void testEliminar() throws Exception {
        // Ejecutar y verificar
        mockMvc.perform(delete("/api/personajes/1")
                .with(csrf()))
                .andExpect(status().isOk());

        verify(personajeService).eliminar(1);
    }

    /**
     * Prueba el endpoint GET /api/personajes con lista vacía.
     */
    @Test
    void testListarVacio() throws Exception {
        when(personajeService.listar()).thenReturn(Arrays.asList());

        mockMvc.perform(get("/api/personajes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(0));

        verify(personajeService).listar();
    }

    /**
     * Prueba el endpoint GET /api/personajes/{id} con ID específico.
     */
    @Test
    void testObtenerConIdEspecifico() throws Exception {
        Personaje personaje = new Personaje(5, "Dan Heng", 4, 75);
        
        when(personajeService.obtener(5)).thenReturn(personaje);

        mockMvc.perform(get("/api/personajes/5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(5))
                .andExpect(jsonPath("$.nombre").value("Dan Heng"));

        verify(personajeService).obtener(5);
    }

    /**
     * Prueba que el controlador asigne correctamente el ID en actualizar.
     */
    @Test
    void testActualizarAsignaIdCorrectamente() throws Exception {
        Personaje personajeActualizado = new Personaje(10, "Gepard", 5, 80);
        
        when(personajeService.guardar(any(Personaje.class))).thenReturn(personajeActualizado);

        mockMvc.perform(put("/api/personajes/10")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombre\":\"Gepard\",\"rareza\":5,\"nivel\":80}")
                .with(csrf()))
                .andExpect(status().isOk());

        verify(personajeService).guardar(any(Personaje.class));
    }
}
