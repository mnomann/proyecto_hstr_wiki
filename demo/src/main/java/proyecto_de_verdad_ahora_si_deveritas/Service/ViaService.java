package proyecto_de_verdad_ahora_si_deveritas.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import proyecto_de_verdad_ahora_si_deveritas.Repository.ViaRepository;
import proyecto_de_verdad_ahora_si_deveritas.Via;

@Service
public class ViaService {

    private final ViaRepository repository;

    public ViaService(ViaRepository repository) {
        this.repository = repository;
    }

    public List<Via> listar() {
        return repository.findAll();
    }

    public Via guardar(Via via) {
        return repository.save(via);
    }

    public Via buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
