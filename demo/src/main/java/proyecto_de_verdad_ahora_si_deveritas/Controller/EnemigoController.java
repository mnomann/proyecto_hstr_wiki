package proyecto_de_verdad_ahora_si_deveritas.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proyecto_de_verdad_ahora_si_deveritas.Enemigo;
import proyecto_de_verdad_ahora_si_deveritas.Service.EnemigoService;

/**
 * Controlador REST para la gestión de enemigos en la aplicación Wiki HSR.
 * Proporciona endpoints para operaciones básicas sobre entidades Enemigo.
 * 
 * @version 1.0
 * @since 2025-07-09
 */
@RestController
@RequestMapping("/api/enemigos")
public class EnemigoController {

    /** Servicio para la lógica de negocio de enemigos. */
    private final EnemigoService service;

    /**
     * Constructor que inicializa el controlador con el servicio de enemigos.
     * 
     * @param service el servicio que maneja la lógica de negocio de enemigos
     */
    public EnemigoController(EnemigoService service) {
        this.service = service;
    }

    /**
     * Obtiene la lista completa de enemigos.
     * 
     * @return lista de todos los enemigos disponibles
     */
    @GetMapping
    public List<Enemigo> getAll() {
        return service.findAll();
    }

    /**
     * Obtiene un enemigo específico por su ID.
     * 
     * @param id el ID del enemigo a buscar
     * @return el enemigo encontrado
     */
    @GetMapping("/{id}")
    public Enemigo getById(@PathVariable int id) {
        return service.findById(id);
    }

    /**
     * Crea un nuevo enemigo.
     * 
     * @param enemigo el enemigo a crear
     * @return el enemigo creado con su ID asignado
     */
    @PostMapping
    public Enemigo create(@RequestBody Enemigo enemigo) {
        return service.save(enemigo);
    }
}
