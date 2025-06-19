package proyecto_de_verdad_ahora_si_deveritas.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import proyecto_de_verdad_ahora_si_deveritas.Cono;
import proyecto_de_verdad_ahora_si_deveritas.Repository.ConoRepository;

@Service
public class ConoService {

    private final ConoRepository repo;

    public ConoService(ConoRepository repo) {
        this.repo = repo;
    }

    public List<Cono> findAll() {
        return repo.findAll();
    }

    public Cono save(Cono c) {
        return repo.save(c);
    }

    public Cono findById(int id) {
        return repo.findById(id).orElse(null);
    }
}
