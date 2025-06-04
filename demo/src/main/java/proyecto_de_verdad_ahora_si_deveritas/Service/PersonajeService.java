package proyecto_de_verdad_ahora_si_deveritas.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import proyecto_de_verdad_ahora_si_deveritas.Personaje;
import proyecto_de_verdad_ahora_si_deveritas.Repository.PersonajeRepository;

@Service
public class PersonajeService {

    private final PersonajeRepository repo;

    public PersonajeService(PersonajeRepository repo) {
        this.repo = repo;
    }

    public List<Personaje> listar() {
        return repo.findAll();
    }

    public Personaje guardar(Personaje p) {
        return repo.save(p);
    }

    public void eliminar(int id) {
        repo.deleteById(id);
    }

    public Personaje obtener(int id) {
        return repo.findById(id).orElse(null);
    }
}
