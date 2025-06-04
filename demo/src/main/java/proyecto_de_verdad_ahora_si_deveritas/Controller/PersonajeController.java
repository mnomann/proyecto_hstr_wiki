package proyecto_de_verdad_ahora_si_deveritas.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import proyecto_de_verdad_ahora_si_deveritas.Personaje;
import proyecto_de_verdad_ahora_si_deveritas.Service.PersonajeService;

@RestController
@RequestMapping("/api/personajes")
public class PersonajeController {

    private final PersonajeService servicio;

    public PersonajeController(PersonajeService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Personaje> listar() {
        return servicio.listar();
    }

    @PostMapping
    public Personaje crear(@RequestBody Personaje p) {
        return servicio.guardar(p);
    }

    @GetMapping("/{id}")
    public Personaje obtener(@PathVariable int id) {
        return servicio.obtener(id);
    }

    @PutMapping("/{id}")
    public Personaje actualizar(@PathVariable int id, @RequestBody Personaje actualizado) {
        actualizado.setId(id);
        return servicio.guardar(actualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        servicio.eliminar(id);
    }
}