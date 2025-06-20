package proyecto_de_verdad_ahora_si_deveritas.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import proyecto_de_verdad_ahora_si_deveritas.MaterialEnemigo;
import proyecto_de_verdad_ahora_si_deveritas.Repository.MaterialEnemigoRepository;

@Service
public class MaterialEnemigoService {

    private final MaterialEnemigoRepository repo;

    public MaterialEnemigoService(MaterialEnemigoRepository repo) {
        this.repo = repo;
    }

    public List<MaterialEnemigo> listar() {
        return repo.findAll();
    }

    public MaterialEnemigo guardar(MaterialEnemigo m) {
        return repo.save(m);
    }

    public void eliminar(int id) {
        repo.deleteById(id);
    }

    public MaterialEnemigo obtener(int id) {
        return repo.findById(id).orElse(null);
    }
}