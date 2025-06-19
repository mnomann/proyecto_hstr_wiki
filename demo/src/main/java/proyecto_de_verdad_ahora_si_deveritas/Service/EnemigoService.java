package proyecto_de_verdad_ahora_si_deveritas.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import proyecto_de_verdad_ahora_si_deveritas.Enemigo;
import proyecto_de_verdad_ahora_si_deveritas.Repository.EnemigoRepository;

@Service
public class EnemigoService {
    private final EnemigoRepository repo;

    public EnemigoService(EnemigoRepository repo) {
        this.repo = repo;
    }

    public List<Enemigo> findAll() {
        return repo.findAll();
    }

    public Enemigo findById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Enemigo save(Enemigo enemigo) {
        return repo.save(enemigo);
    }
}
