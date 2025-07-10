package proyecto_de_verdad_ahora_si_deveritas.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proyecto_de_verdad_ahora_si_deveritas.Service.ViaService;
import proyecto_de_verdad_ahora_si_deveritas.Via;

/**
 * Controlador REST para la gestión de vías en la aplicación Wiki HSR.
 * 
 * <p>Este controlador proporciona endpoints para realizar operaciones CRUD
 * (Create, Read, Update, Delete) sobre las entidades Via. Las vías representan
 * los diferentes caminos o especializaciones que pueden seguir los personajes
 * en el juego Honkai: Star Rail.</p>
 * 
 * <p>Todos los endpoints están bajo la ruta base "/api/vias" y devuelven
 * respuestas en formato JSON.</p>
 * 
 * 
 * @author [Tu nombre]
 * @version 1.0
 * @since 2025-07-09
 * @see Via
 * @see ViaService
 */
@RestController
@RequestMapping("/api/vias")
public class ViaController {

    /** Servicio para la lógica de negocio relacionada con las vías. */
    private final ViaService service;

    /**
     * Constructor que inicializa el controlador con el servicio de vías.
     * 
     * @param service el servicio que maneja la lógica de negocio de las vías
     * @throws IllegalArgumentException si el servicio es null
     */
    public ViaController(ViaService service) {
        this.service = service;
    }

    /**
     * Obtiene la lista completa de todas las vías disponibles.
     * 
     * <p>Este endpoint devuelve todas las vías almacenadas en la base de datos.
     * Si no hay vías disponibles, retorna una lista vacía.</p>
     * 
     * @return una lista de objetos {@link Via} con todas las vías disponibles.
     *         La lista puede estar vacía si no hay vías registradas.
     * @throws RuntimeException si ocurre un error al acceder a la base de datos
     * 
     */
    @GetMapping
    public List<Via> listar() {
        return service.listar();
    }

    /**
     * Crea una nueva vía en el sistema.
     * 
     * <p>Este endpoint permite crear una nueva vía proporcionando los datos
     * necesarios en el cuerpo de la petición en formato JSON.</p>
     * 
     * @param via el objeto {@link Via} que contiene los datos de la nueva vía.
     *            No debe ser null y debe contener al menos el nombre.
     * @return la vía creada con el ID asignado por la base de datos
     * @throws IllegalArgumentException si la vía es null o contiene datos inválidos
     * @throws RuntimeException si ocurre un error al guardar en la base de datos
     * 
     */
    @PostMapping
    public Via crear(@RequestBody Via via) {
        return service.guardar(via);
    }

    /**
     * Obtiene una vía específica por su identificador único.
     * 
     * <p>Este endpoint permite recuperar los datos de una vía específica
     * proporcionando su ID como parámetro de ruta.</p>
     * 
     * @param id el identificador único de la vía a buscar. Debe ser un entero positivo.
     * @return la vía encontrada con el ID especificado, o null si no se encuentra
     * @throws IllegalArgumentException si el ID es null o negativo
     * @throws RuntimeException si ocurre un error al acceder a la base de datos
     * 
     */
    @GetMapping("/{id}")
    public Via obtener(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    /**
     * Elimina una vía del sistema por su identificador único.
     * 
     * <p>Este endpoint permite eliminar permanentemente una vía de la base de datos.
     * La operación es irreversible y eliminará todos los datos asociados a la vía.</p>
     * 
     * <p><strong>Precaución:</strong> Esta operación es irreversible. Asegúrate de que
     * la vía no esté siendo utilizada por otros elementos del sistema antes de eliminarla.</p>
     * 
     * @param id el identificador único de la vía a eliminar. Debe ser un entero positivo.
     * @throws IllegalArgumentException si el ID es null o negativo
     * @throws RuntimeException si ocurre un error al acceder a la base de datos
     * 
     */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}