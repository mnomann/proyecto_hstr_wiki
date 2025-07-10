package proyecto_de_verdad_ahora_si_deveritas.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import proyecto_de_verdad_ahora_si_deveritas.Repository.ViaRepository;
import proyecto_de_verdad_ahora_si_deveritas.Via;

/**
 * Servicio para la lógica de negocio de vías en la aplicación Wiki HSR.
 * Proporciona métodos para operaciones CRUD completas sobre entidades Via.
 * 
 * @version 1.0
 * @since 2025-07-09
 */
@Service
public class ViaService {

    /** Repositorio para el acceso a datos de vías. */
    private final ViaRepository repository;

    /**
     * Constructor que inicializa el servicio con el repositorio de vías.
     * 
     * @param repository el repositorio que maneja el acceso a datos de vías
     */
    public ViaService(ViaRepository repository) {
        this.repository = repository;
    }

    /**
     * Obtiene la lista completa de vías.
     * 
     * @return lista de todas las vías disponibles
     */
    public List<Via> listar() {
        return repository.findAll();
    }

    /**
     * Guarda una vía en la base de datos.
     * 
     * @param via la vía a guardar
     * @return la vía guardada con su ID asignado
     */
    public Via guardar(Via via) {
        return repository.save(via);
    }

    /**
     * Busca una vía por su ID.
     * 
     * @param id el ID de la vía a buscar
     * @return la vía encontrada o null si no existe
     */
    public Via buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Elimina una vía de la base de datos.
     * 
     * @param id el ID de la vía a eliminar
     */
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
