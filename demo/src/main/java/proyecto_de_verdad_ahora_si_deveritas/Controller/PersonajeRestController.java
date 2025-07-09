package proyecto_de_verdad_ahora_si_deveritas.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonajeRestController {

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