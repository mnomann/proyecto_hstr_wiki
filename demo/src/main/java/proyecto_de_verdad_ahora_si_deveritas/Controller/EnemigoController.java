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

@RestController
@RequestMapping("/api/enemigos")
public class EnemigoController {

    private final EnemigoService service;

    public EnemigoController(EnemigoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Enemigo> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Enemigo getById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping
    public Enemigo create(@RequestBody Enemigo enemigo) {
        return service.save(enemigo);
    }
}
