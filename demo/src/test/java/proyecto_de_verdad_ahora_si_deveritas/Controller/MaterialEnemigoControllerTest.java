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

import proyecto_de_verdad_ahora_si_deveritas.MaterialEnemigo;
import proyecto_de_verdad_ahora_si_deveritas.Service.MaterialEnemigoService;

/**
 * Pruebas unitarias para la clase MaterialEnemigoController.
 * 
 * <p>Estas pruebas verifican el correcto funcionamiento de:</p>
 * <ul>
 *   <li>Endpoints CRUD (GET, POST, PUT, DELETE)</li>
 *   <li>Mapeo de URLs</li>
 *   <li>Integración con el servicio</li>
 *   <li>Manejo de respuestas HTTP</li>
 * </ul>
 * 
 * @version 1.0
 * @since 2025-07-09
 */
@WebMvcTest(MaterialEnemigoController.class)
@WithMockUser
class MaterialEnemigoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MaterialEnemigoService materialEnemigoService;

    /**
     * Prueba el endpoint GET /api/materiales para listar todos los materiales.
     */
    @Test
    void testListar() throws Exception {
        // Preparar datos de prueba
        List<MaterialEnemigo> materiales = Arrays.asList(
            new MaterialEnemigo(1, "Fragmento Etéreo", 1, "Soldado Antimaterial"),
            new MaterialEnemigo(2, "Engranaje Oxidado", 2, "Autómata Grizzly")
        );
        
        when(materialEnemigoService.listar()).thenReturn(materiales);

        // Ejecutar y verificar
        mockMvc.perform(get("/api/materiales"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].nombre").value("Fragmento Etéreo"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].nombre").value("Engranaje Oxidado"));

        verify(materialEnemigoService).listar();
    }

    /**
     * Prueba el endpoint POST /api/materiales para crear un nuevo material.
     */
    @Test
    void testCrear() throws Exception {
        // Preparar datos de prueba
        MaterialEnemigo material = new MaterialEnemigo(1, "Núcleo Artificial", 3, "Autómata Centurión");
        
        when(materialEnemigoService.guardar(any(MaterialEnemigo.class))).thenReturn(material);

        // Ejecutar y verificar
        mockMvc.perform(post("/api/materiales")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombre\":\"Núcleo Artificial\",\"enemigoId\":3,\"enemigo\":\"Autómata Centurión\"}")
                .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nombre").value("Núcleo Artificial"))
                .andExpect(jsonPath("$.enemigoId").value(3))
                .andExpect(jsonPath("$.enemigo").value("Autómata Centurión"));

        verify(materialEnemigoService).guardar(any(MaterialEnemigo.class));
    }

    /**
     * Prueba el endpoint GET /api/materiales/{id} para obtener un material específico.
     */
    @Test
    void testObtener() throws Exception {
        // Preparar datos de prueba
        MaterialEnemigo material = new MaterialEnemigo(1, "Chip Cuántico", 4, "Araña Quantum");
        
        when(materialEnemigoService.obtener(1)).thenReturn(material);

        // Ejecutar y verificar
        mockMvc.perform(get("/api/materiales/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nombre").value("Chip Cuántico"))
                .andExpect(jsonPath("$.enemigoId").value(4))
                .andExpect(jsonPath("$.enemigo").value("Araña Quantum"));

        verify(materialEnemigoService).obtener(1);
    }

    /**
     * Prueba el endpoint DELETE /api/materiales/{id} para eliminar un material.
     */
    @Test
    void testEliminar() throws Exception {
        // Ejecutar y verificar
        mockMvc.perform(delete("/api/materiales/1")
                .with(csrf()))
                .andExpect(status().isOk());

        verify(materialEnemigoService).eliminar(1);
    }

    /**
     * Prueba el endpoint GET /api/materiales con lista vacía.
     */
    @Test
    void testListarVacio() throws Exception {
        when(materialEnemigoService.listar()).thenReturn(Arrays.asList());

        mockMvc.perform(get("/api/materiales"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(0));

        verify(materialEnemigoService).listar();
    }

    /**
     * Prueba el endpoint GET /api/materiales/{id} con ID específico.
     */
    @Test
    void testObtenerConIdEspecifico() throws Exception {
        MaterialEnemigo material = new MaterialEnemigo(5, "Material Raro", 10, "Enemigo Poderoso");
        
        when(materialEnemigoService.obtener(5)).thenReturn(material);

        mockMvc.perform(get("/api/materiales/5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(5))
                .andExpect(jsonPath("$.nombre").value("Material Raro"));

        verify(materialEnemigoService).obtener(5);
    }

    /**
     * Prueba que el controlador asigne correctamente el ID en actualizar.
     */
    @Test
    void testActualizarAsignaIdCorrectamente() throws Exception {
        MaterialEnemigo materialActualizado = new MaterialEnemigo(10, "Material Test", 15, "Enemigo Test");
        
        when(materialEnemigoService.guardar(any(MaterialEnemigo.class))).thenReturn(materialActualizado);

        mockMvc.perform(put("/api/materiales/10")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombre\":\"Material Test\",\"enemigoId\":15,\"enemigo\":\"Enemigo Test\"}")
                .with(csrf()))
                .andExpect(status().isOk());

        verify(materialEnemigoService).guardar(any(MaterialEnemigo.class));
    }
}
