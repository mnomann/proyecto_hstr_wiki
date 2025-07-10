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

import proyecto_de_verdad_ahora_si_deveritas.MaterialEnemigo;
import proyecto_de_verdad_ahora_si_deveritas.Service.MaterialEnemigoService;

/**
 * Controlador REST para la gestión de materiales de enemigo en la aplicación Wiki HSR.
 * Proporciona endpoints para operaciones CRUD completas sobre entidades MaterialEnemigo.
 * 
 * @version 1.0
 * @since 2025-07-09
 */
@RestController
@RequestMapping("/api/materiales")
public class MaterialEnemigoController {

    /** Servicio para la lógica de negocio de materiales de enemigo. */
    private final MaterialEnemigoService servicio;

    /**
     * Constructor que inicializa el controlador con el servicio de materiales de enemigo.
     * 
     * @param servicio el servicio que maneja la lógica de negocio de materiales de enemigo
     */
    public MaterialEnemigoController(MaterialEnemigoService servicio) {
        this.servicio = servicio;
    }

    /**
     * Obtiene la lista completa de materiales de enemigo.
     * 
     * @return lista de todos los materiales de enemigo disponibles
     */
    @GetMapping
    public List<MaterialEnemigo> listar() {
        return servicio.listar();
    }

    /**
     * Crea un nuevo material de enemigo.
     * 
     * @param m el material de enemigo a crear
     * @return el material de enemigo creado con su ID asignado
     */
    @PostMapping
    public MaterialEnemigo crear(@RequestBody MaterialEnemigo m) {
        return servicio.guardar(m);
    }

    /**
     * Obtiene un material de enemigo específico por su ID.
     * 
     * @param id el ID del material de enemigo a buscar
     * @return el material de enemigo encontrado
     */
    @GetMapping("/{id}")
    public MaterialEnemigo obtener(@PathVariable int id) {
        return servicio.obtener(id);
    }

    /**
     * Actualiza un material de enemigo existente.
     * 
     * @param id el ID del material de enemigo a actualizar
     * @param actualizado los datos actualizados del material de enemigo
     * @return el material de enemigo actualizado
     */
    @PutMapping("/{id}")
    public MaterialEnemigo actualizar(@PathVariable int id, @RequestBody MaterialEnemigo actualizado) {
        actualizado.setId(id);
        return servicio.guardar(actualizado);
    }

    /**
     * Elimina un material de enemigo por su ID.
     * 
     * @param id el ID del material de enemigo a eliminar
     */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        servicio.eliminar(id);
    }
}