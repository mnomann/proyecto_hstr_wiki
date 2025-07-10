package proyecto_de_verdad_ahora_si_deveritas.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import proyecto_de_verdad_ahora_si_deveritas.Enemigo;
import proyecto_de_verdad_ahora_si_deveritas.Repository.EnemigoRepository;

/**
 * Servicio para la lógica de negocio de enemigos en la aplicación Wiki HSR.
 * Proporciona métodos para operaciones básicas sobre entidades Enemigo.
 * 
 * @version 1.0
 * @since 2025-07-09
 */
@Service
public class EnemigoService {
    
    /** Repositorio para el acceso a datos de enemigos. */
    private final EnemigoRepository repo;

    /**
     * Constructor que inicializa el servicio con el repositorio de enemigos.
     * 
     * @param repo el repositorio que maneja el acceso a datos de enemigos
     */
    public EnemigoService(EnemigoRepository repo) {
        this.repo = repo;
    }

    /**
     * Obtiene la lista completa de enemigos.
     * 
     * @return lista de todos los enemigos disponibles
     */
    public List<Enemigo> findAll() {
        return repo.findAll();
    }

    /**
     * Busca un enemigo por su ID.
     * 
     * @param id el ID del enemigo a buscar
     * @return el enemigo encontrado o null si no existe
     */
    public Enemigo findById(int id) {
        return repo.findById(id).orElse(null);
    }

    /**
     * Guarda un enemigo en la base de datos.
     * 
     * @param enemigo el enemigo a guardar
     * @return el enemigo guardado con su ID asignado
     */
    public Enemigo save(Enemigo enemigo) {
        return repo.save(enemigo);
    }
}
