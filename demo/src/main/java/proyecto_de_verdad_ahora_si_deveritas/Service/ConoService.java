package proyecto_de_verdad_ahora_si_deveritas.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import proyecto_de_verdad_ahora_si_deveritas.Cono;
import proyecto_de_verdad_ahora_si_deveritas.Repository.ConoRepository;

/**
 * Servicio para la lógica de negocio de conos en la aplicación Wiki HSR.
 * Proporciona métodos para operaciones básicas sobre entidades Cono.
 * 
 * @version 1.0
 * @since 2025-07-09
 */
@Service
public class ConoService {

    /** Repositorio para el acceso a datos de conos. */
    private final ConoRepository repo;

    /**
     * Constructor que inicializa el servicio con el repositorio de conos.
     * 
     * @param repo el repositorio que maneja el acceso a datos de conos
     */
    public ConoService(ConoRepository repo) {
        this.repo = repo;
    }

    /**
     * Obtiene la lista completa de conos.
     * 
     * @return lista de todos los conos disponibles
     */
    public List<Cono> findAll() {
        return repo.findAll();
    }

    /**
     * Guarda un cono en la base de datos.
     * 
     * @param c el cono a guardar
     * @return el cono guardado con su ID asignado
     */
    public Cono save(Cono c) {
        return repo.save(c);
    }

    /**
     * Busca un cono por su ID.
     * 
     * @param id el ID del cono a buscar
     * @return el cono encontrado o null si no existe
     */
    public Cono findById(int id) {
        return repo.findById(id).orElse(null);
    }
}
