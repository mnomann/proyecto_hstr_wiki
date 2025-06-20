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

@RestController
@RequestMapping("/api/vias")
public class ViaController {

    private final ViaService service;

    public ViaController(ViaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Via> listar() {
        return service.listar();
    }

    @PostMapping
    public Via crear(@RequestBody Via via) {
        return service.guardar(via);
    }

    @GetMapping("/{id}")
    public Via obtener(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}