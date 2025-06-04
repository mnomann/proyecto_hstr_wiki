package proyecto_de_verdad_ahora_si_deveritas.Controller;

import org.springframework.web.bind.annotation.*;

import proyecto_de_verdad_ahora_si_deveritas.Service.MaterialEnemigoService;

import java.util.List;

import proyecto_de_verdad_ahora_si_deveritas.MaterialEnemigo;

@RestController
@RequestMapping("/api/materiales")
public class MaterialEnemigoController {

    private final MaterialEnemigoService servicio;

    public MaterialEnemigoController(MaterialEnemigoService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<MaterialEnemigo> listar() {
        return servicio.listar();
    }

    @PostMapping
    public MaterialEnemigo crear(@RequestBody MaterialEnemigo m) {
        return servicio.guardar(m);
    }

    @GetMapping("/{id}")
    public MaterialEnemigo obtener(@PathVariable int id) {
        return servicio.obtener(id);
    }

    @PutMapping("/{id}")
    public MaterialEnemigo actualizar(@PathVariable int id, @RequestBody MaterialEnemigo actualizado) {
        actualizado.setId(id);
        return servicio.guardar(actualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        servicio.eliminar(id);
    }
}