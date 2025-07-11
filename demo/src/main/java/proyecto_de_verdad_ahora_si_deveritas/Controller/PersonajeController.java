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

import proyecto_de_verdad_ahora_si_deveritas.Personaje;
import proyecto_de_verdad_ahora_si_deveritas.Service.PersonajeService;

/**
 * Controlador REST para la gestión de personajes en la aplicación Wiki HSR.
 * Proporciona endpoints para operaciones CRUD completas sobre entidades Personaje.
 * 
 * @version 1.0
 * @since 2025-07-09
 */
@RestController
@RequestMapping("/api/personajes")
public class PersonajeController {

    /** Servicio para la lógica de negocio de personajes. */
    private final PersonajeService servicio;

    /**
     * Constructor que inicializa el controlador con el servicio de personajes.
     * 
     * @param servicio el servicio que maneja la lógica de negocio de personajes
     */
    public PersonajeController(PersonajeService servicio) {
        this.servicio = servicio;
    }

    /**
     * Obtiene la lista completa de personajes.
     * 
     * @return lista de todos los personajes disponibles
     */
    @GetMapping
    public List<Personaje> listar() {
        return servicio.listar();
    }

    /**
     * Crea un nuevo personaje.
     * 
     * @param p el personaje a crear
     * @return el personaje creado con su ID asignado
     */
    @PostMapping
    public Personaje crear(@RequestBody Personaje p) {
        return servicio.guardar(p);
    }

    /**
     * Obtiene un personaje específico por su ID.
     * 
     * @param id el ID del personaje a buscar
     * @return el personaje encontrado
     */
    @GetMapping("/{id}")
    public Personaje obtener(@PathVariable int id) {
        return servicio.obtener(id);
    }

    /**
     * Actualiza un personaje existente.
     * 
     * @param id el ID del personaje a actualizar
     * @param actualizado los datos actualizados del personaje
     * @return el personaje actualizado
     */
    @PutMapping("/{id}")
    public Personaje actualizar(@PathVariable int id, @RequestBody Personaje actualizado) {
        actualizado.setId(id);
        return servicio.guardar(actualizado);
    }

    /**
     * Elimina un personaje por su ID.
     * 
     * @param id el ID del personaje a eliminar
     */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        servicio.eliminar(id);
    }
}