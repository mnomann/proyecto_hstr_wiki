package proyecto_de_verdad_ahora_si_deveritas.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import proyecto_de_verdad_ahora_si_deveritas.Personaje;
import proyecto_de_verdad_ahora_si_deveritas.Repository.PersonajeRepository;

/**
 * Servicio para la lógica de negocio de personajes en la aplicación Wiki HSR.
 * Proporciona métodos para operaciones CRUD completas sobre entidades Personaje.
 * 
 * @version 1.0
 * @since 2025-07-09
 */
@Service
public class PersonajeService {

    /** Repositorio para el acceso a datos de personajes. */
    private final PersonajeRepository repo;

    /**
     * Constructor que inicializa el servicio con el repositorio de personajes.
     * 
     * @param repo el repositorio que maneja el acceso a datos de personajes
     */
    public PersonajeService(PersonajeRepository repo) {
        this.repo = repo;
    }

    /**
     * Obtiene la lista completa de personajes.
     * 
     * @return lista de todos los personajes disponibles
     */
    public List<Personaje> listar() {
        return repo.findAll();
    }

    /**
     * Guarda un personaje en la base de datos.
     * 
     * @param p el personaje a guardar
     * @return el personaje guardado con su ID asignado
     */
    public Personaje guardar(Personaje p) {
        return repo.save(p);
    }

    /**
     * Elimina un personaje de la base de datos.
     * 
     * @param id el ID del personaje a eliminar
     */
    public void eliminar(int id) {
        repo.deleteById(id);
    }

    /**
     * Busca un personaje por su ID.
     * 
     * @param id el ID del personaje a buscar
     * @return el personaje encontrado o null si no existe
     */
    public Personaje obtener(int id) {
        return repo.findById(id).orElse(null);
    }
}
