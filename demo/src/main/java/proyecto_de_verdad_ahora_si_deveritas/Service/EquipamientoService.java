package proyecto_de_verdad_ahora_si_deveritas.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import proyecto_de_verdad_ahora_si_deveritas.Equipamiento;
import proyecto_de_verdad_ahora_si_deveritas.Repository.EquipamientoRepository;

@Service
public class EquipamientoService {

    private final EquipamientoRepository repo;

    public EquipamientoService(EquipamientoRepository repo) {
        this.repo = repo;
    }

    public List<Equipamiento> listar() {
        return repo.findAll();
    }

    public Equipamiento guardar(Equipamiento eq) {
        return repo.save(eq);
    }

    public void eliminar(int id) {
        repo.deleteById(id);
    }

    public Equipamiento obtener(int id) {
        return repo.findById(id).orElse(null);
    }
}
