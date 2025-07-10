package proyecto_de_verdad_ahora_si_deveritas.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST para la búsqueda y gestión de personajes en la aplicación Wiki HSR.
 * 
 * <p>Este controlador proporciona endpoints para realizar búsquedas de personajes
 * de Honkai: Star Rail. Mantiene una lista estática de personajes con sus datos
 * básicos y permite realizar búsquedas filtradas por diferentes criterios.</p>
 * 
 * <p>El controlador utiliza una estructura de datos en memoria con mapas que
 * contienen información básica de cada personaje, incluyendo ID, nombre y ruta
 * de navegación hacia su página de detalle.</p>
 * 
 * <h3>Endpoints disponibles:</h3>
 * <ul>
 *   <li>GET /api/personajes/buscar - Búsqueda de personajes con filtros opcionales</li>
 * </ul>
 * 
 * <h3>Estructura de datos de personaje:</h3>
 * <pre>
 * {
 *   "id": "1",
 *   "nombre": "Arlan",
 *   "ruta": "/Personajes/arlan"
 * }
 * </pre>
 * 
 * @author [Tu nombre]
 * @version 1.0
 * @since 2025-07-09
 * @see Map
 * @implNote Esta implementación utiliza datos estáticos en memoria.
 *           Para un entorno de producción, se recomienda migrar a una base de datos.
 */
@RestController
public class PersonajeRestController {

    /**
     * Lista estática de personajes disponibles en la aplicación.
     * 
     * <p>Cada personaje está representado como un {@link Map} con las siguientes claves:</p>
     * <ul>
     *   <li><strong>id</strong>: Identificador único del personaje (String)</li>
     *   <li><strong>nombre</strong>: Nombre del personaje (String)</li>
     *   <li><strong>ruta</strong>: Ruta URL hacia la página de detalle del personaje (String)</li>
     * </ul>
     * 
     * <p>La lista contiene todos los personajes principales de Honkai: Star Rail
     * disponibles en la wiki, ordenados por ID.</p>
     * 
     * @implNote Esta lista es inmutable y se inicializa al cargar la clase.
     *           Para modificar personajes, se requiere actualizar el código fuente.
     */
    private static final List<Map<String, String>> PERSONAJES = List.of(
        Map.of("id", "1", "nombre", "Arlan", "ruta", "/Personajes/arlan"),
        Map.of("id", "2", "nombre", "Asta", "ruta", "/Personajes/asta"),
        Map.of("id", "3", "nombre", "Bailu", "ruta", "/Personajes/bailu"),
        Map.of("id", "4", "nombre", "Bronya", "ruta", "/Personajes/bronya"),
        Map.of("id", "5", "nombre", "Clara", "ruta", "/Personajes/clara"),
        Map.of("id", "6", "nombre", "Dan Heng", "ruta", "/Personajes/dangHeng"),
        Map.of("id", "7", "nombre", "Gepard", "ruta", "/Personajes/gepard"),
        Map.of("id", "8", "nombre", "Herta", "ruta", "/Personajes/Herta"),
        Map.of("id", "9", "nombre", "Himeko", "ruta", "/Personajes/himeko"),
        Map.of("id", "10", "nombre", "Hook", "ruta", "/Personajes/hook"),
        Map.of("id", "11", "nombre", "Jing Yuan", "ruta", "/Personajes/jinYuan"),
        Map.of("id", "12", "nombre", "Kafka", "ruta", "/Personajes/kafka"),
        Map.of("id", "13", "nombre", "Luocha", "ruta", "/Personajes/luocha"),
        Map.of("id", "14", "nombre", "Natasha", "ruta", "/Personajes/natasha"),
        Map.of("id", "15", "nombre", "Pela", "ruta", "/Personajes/pela"),
        Map.of("id", "16", "nombre", "Qingque", "ruta", "/Personajes/qinque"),
        Map.of("id", "17", "nombre", "Sampo", "ruta", "/Personajes/sampo"),
        Map.of("id", "18", "nombre", "Seele", "ruta", "/Personajes/seele"),
        Map.of("id", "19", "nombre", "Serval", "ruta", "/Personajes/serval"),
        Map.of("id", "20", "nombre", "7 de Marzo", "ruta", "/Personajes/7deMarzo"),
        Map.of("id", "21", "nombre", "Silver Wolf", "ruta", "/Personajes/silverWolf"),
        Map.of("id", "22", "nombre", "Sushang", "ruta", "/Personajes/sushang"),
        Map.of("id", "23", "nombre", "Tingyun", "ruta", "/Personajes/tingyun"),
        Map.of("id", "24", "nombre", "Trazacaminos", "ruta", "/Personajes/trazacaminos"),
        Map.of("id", "25", "nombre", "Welt", "ruta", "/Personajes/welt"),
        Map.of("id", "26", "nombre", "Yanqing", "ruta", "/Personajes/yanqing")
    );

    /**
     * Busca personajes aplicando filtros opcionales sobre la lista de personajes disponibles.
     * 
     * <p>Este endpoint permite realizar búsquedas flexibles de personajes utilizando
     * uno o más criterios de filtrado. Todos los parámetros son opcionales y se pueden
     * combinar para obtener resultados más específicos.</p>
     * 
     * <p>La búsqueda es <em>case-insensitive</em> (no distingue mayúsculas y minúsculas)
     * para el parámetro 'nombre' y utiliza coincidencias parciales (contiene).</p>
     * 
     * <h3>Comportamiento de los filtros:</h3>
     * <ul>
     *   <li><strong>nombre</strong>: Búsqueda por coincidencia parcial case-insensitive</li>
     *   <li><strong>id</strong>: Búsqueda por coincidencia exacta</li>
     *   <li><strong>tipo</strong>: Búsqueda case-insensitive (actualmente no utilizado)</li>
     *   <li><strong>afinidad</strong>: Búsqueda case-insensitive (actualmente no utilizado)</li>
     * </ul>
     * 
     * @param nombre filtro opcional para buscar por nombre del personaje.
     *               Realiza búsqueda parcial case-insensitive.
     *               Ejemplo: "ar" encontrará "Arlan" y "Clara".
     * @param id filtro opcional para buscar por ID exacto del personaje.
     *           Debe coincidir exactamente con el ID del personaje.
     *           Ejemplo: "1" encontrará solo el personaje con ID "1".
     * @param tipo filtro opcional para buscar por tipo de personaje.
     *             <em>Nota:</em> Actualmente no implementado en los datos,
     *             pero preparado para futuras extensiones.
     * @param afinidad filtro opcional para buscar por afinidad del personaje.
     *                 <em>Nota:</em> Actualmente no implementado en los datos,
     *                 pero preparado para futuras extensiones.
     * 
     * @return una lista de mapas, donde cada mapa representa un personaje que
     *         cumple con los criterios de búsqueda especificados. Si no se
     *         especifican filtros, retorna todos los personajes. Si ningún
     *         personaje cumple los criterios, retorna una lista vacía.
     * 
     * @throws IllegalArgumentException si algún parámetro tiene un formato inválido
     * 
     */
    @GetMapping("/api/personajes/buscar")
    public List<Map<String, String>> buscarPersonajes(
        @RequestParam(required = false) String nombre,
        @RequestParam(required = false) String id,
        @RequestParam(required = false) String tipo,
        @RequestParam(required = false) String afinidad) {
    return PERSONAJES.stream()
        .filter(p -> (nombre == null || p.get("nombre").toLowerCase().contains(nombre.toLowerCase())))
        .filter(p -> (id == null || p.get("id").equals(id)))
        .filter(p -> (tipo == null || tipo.isEmpty() || (p.containsKey("tipo") && p.get("tipo").equalsIgnoreCase(tipo))))
        .filter(p -> (afinidad == null || afinidad.isEmpty() || (p.containsKey("afinidad") && p.get("afinidad").equalsIgnoreCase(afinidad))))
        .toList();
    }
}