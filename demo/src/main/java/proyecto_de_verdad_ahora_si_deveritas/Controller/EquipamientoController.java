package proyecto_de_verdad_ahora_si_deveritas.Controller;

import org.springframework.web.bind.annotation.*;

import proyecto_de_verdad_ahora_si_deveritas.Service.EquipamientoService;

import java.util.List;

import proyecto_de_verdad_ahora_si_deveritas.Equipamiento;

@RestController
@RequestMapping("/api/equipamiento")
public class EquipamientoController {

    private final EquipamientoService servicio;

    public EquipamientoController(EquipamientoService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Equipamiento> listar() {
        return servicio.listar();
    }

    @PostMapping
    public Equipamiento crear(@RequestBody Equipamiento e) {
        return servicio.guardar(e);
    }

    @GetMapping("/{id}")
    public Equipamiento obtener(@PathVariable int id) {
        return servicio.obtener(id);
    }

    @PutMapping("/{id}")
    public Equipamiento actualizar(@PathVariable int id, @RequestBody Equipamiento actualizado) {
        actualizado.setId(id);
        return servicio.guardar(actualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        servicio.eliminar(id);
    }
}