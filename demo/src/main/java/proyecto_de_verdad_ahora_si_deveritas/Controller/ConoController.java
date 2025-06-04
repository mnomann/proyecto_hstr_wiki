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

@RestController
@RequestMapping("/api/conos")
public class ConoController {

    private final ConoService service;

    public ConoController(ConoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cono> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Cono getById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping
    public Cono create(@RequestBody Cono cono) {
        return service.save(cono);
    }
}
