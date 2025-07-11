package proyecto_de_verdad_ahora_si_deveritas.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proyecto_de_verdad_ahora_si_deveritas.Equipamiento;
import proyecto_de_verdad_ahora_si_deveritas.Service.EquipamientoService;

/**
 * Controlador REST para la gestión de equipamiento en la aplicación Wiki HSR.
 * Proporciona endpoints para operaciones CRUD completas sobre entidades Equipamiento.
 * 
 * @version 1.0
 * @since 2025-07-09
 */
@RestController
@RequestMapping("/api/equipamiento")
public class EquipamientoController {

    /** Servicio para la lógica de negocio de equipamiento. */
    private final EquipamientoService servicio;

    /**
     * Constructor que inicializa el controlador con el servicio de equipamiento.
     * 
     * @param servicio el servicio que maneja la lógica de negocio de equipamiento
     */
    public EquipamientoController(EquipamientoService servicio) {
        this.servicio = servicio;
    }

    /**
     * Obtiene la lista completa de equipamiento.
     * 
     * @return lista de todo el equipamiento disponible
     */
    @GetMapping
    public List<Equipamiento> listar() {
        return servicio.listar();
    }

    /**
     * Crea un nuevo equipamiento.
     * 
     * @param e el equipamiento a crear
     * @return el equipamiento creado con su ID asignado
     */
    @PostMapping
    public Equipamiento crear(@RequestBody Equipamiento e) {
        return servicio.guardar(e);
    }

    /**
     * Obtiene un equipamiento específico por su ID.
     * 
     * @param id el ID del equipamiento a buscar
     * @return el equipamiento encontrado
     */
    @GetMapping("/{id}")
    public Equipamiento obtener(@PathVariable int id) {
        return servicio.obtener(id);
    }

    /**
     * Actualiza un equipamiento existente.
     * 
     * @param id el ID del equipamiento a actualizar
     * @param actualizado los datos actualizados del equipamiento
     * @return el equipamiento actualizado
     */
    @PutMapping("/{id}")
    public Equipamiento actualizar(@PathVariable int id, @RequestBody Equipamiento actualizado) {
        actualizado.setId(id);
        return servicio.guardar(actualizado);
    }

    /**
     * Elimina un equipamiento por su ID.
     * 
     * @param id el ID del equipamiento a eliminar
     */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        servicio.eliminar(id);
    }
}