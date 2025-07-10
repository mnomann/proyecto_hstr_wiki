package proyecto_de_verdad_ahora_si_deveritas.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proyecto_de_verdad_ahora_si_deveritas.Cono;
import proyecto_de_verdad_ahora_si_deveritas.Service.ConoService;

/**
 * Controlador REST para la gestión de conos en la aplicación Wiki HSR.
 * Proporciona endpoints para operaciones básicas sobre entidades Cono.
 * 
 * @version 1.0
 * @since 2025-07-09
 */
@RestController
@RequestMapping("/api/conos")
public class ConoController {

    /** Servicio para la lógica de negocio de conos. */
    private final ConoService service;

    /**
     * Constructor que inicializa el controlador con el servicio de conos.
     * 
     * @param service el servicio que maneja la lógica de negocio de conos
     */
    public ConoController(ConoService service) {
        this.service = service;
    }

    /**
     * Obtiene la lista completa de conos.
     * 
     * @return lista de todos los conos disponibles
     */
    @GetMapping
    public List<Cono> getAll() {
        return service.findAll();
    }

    /**
     * Obtiene un cono específico por su ID.
     * 
     * @param id el ID del cono a buscar
     * @return el cono encontrado
     */
    @GetMapping("/{id}")
    public Cono getById(@PathVariable int id) {
        return service.findById(id);
    }

    /**
     * Crea un nuevo cono.
     * 
     * @param cono el cono a crear
     * @return el cono creado con su ID asignado
     */
    @PostMapping
    public Cono create(@RequestBody Cono cono) {
        return service.save(cono);
    }
}
