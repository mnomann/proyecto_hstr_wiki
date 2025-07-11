package proyecto_de_verdad_ahora_si_deveritas.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import proyecto_de_verdad_ahora_si_deveritas.Equipamiento;
import proyecto_de_verdad_ahora_si_deveritas.Repository.EquipamientoRepository;

/**
 * Servicio para la lógica de negocio de equipamiento en la aplicación Wiki HSR.
 * Proporciona métodos para operaciones CRUD completas sobre entidades Equipamiento.
 * 
 * @version 1.0
 * @since 2025-07-09
 */
@Service
public class EquipamientoService {

    /** Repositorio para el acceso a datos de equipamiento. */
    private final EquipamientoRepository repo;

    /**
     * Constructor que inicializa el servicio con el repositorio de equipamiento.
     * 
     * @param repo el repositorio que maneja el acceso a datos de equipamiento
     */
    public EquipamientoService(EquipamientoRepository repo) {
        this.repo = repo;
    }

    /**
     * Obtiene la lista completa de equipamiento.
     * 
     * @return lista de todo el equipamiento disponible
     */
    public List<Equipamiento> listar() {
        return repo.findAll();
    }

    /**
     * Guarda un equipamiento en la base de datos.
     * 
     * @param eq el equipamiento a guardar
     * @return el equipamiento guardado con su ID asignado
     */
    public Equipamiento guardar(Equipamiento eq) {
        return repo.save(eq);
    }

    /**
     * Elimina un equipamiento de la base de datos.
     * 
     * @param id el ID del equipamiento a eliminar
     */
    public void eliminar(int id) {
        repo.deleteById(id);
    }

    /**
     * Busca un equipamiento por su ID.
     * 
     * @param id el ID del equipamiento a buscar
     * @return el equipamiento encontrado o null si no existe
     */
    public Equipamiento obtener(int id) {
        return repo.findById(id).orElse(null);
    }
}
