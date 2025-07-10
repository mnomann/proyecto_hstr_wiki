package proyecto_de_verdad_ahora_si_deveritas.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import proyecto_de_verdad_ahora_si_deveritas.MaterialEnemigo;
import proyecto_de_verdad_ahora_si_deveritas.Repository.MaterialEnemigoRepository;

/**
 * Servicio para la lógica de negocio de materiales de enemigo en la aplicación Wiki HSR.
 * Proporciona métodos para operaciones CRUD completas sobre entidades MaterialEnemigo.
 * 
 * @version 1.0
 * @since 2025-07-09
 */
@Service
public class MaterialEnemigoService {

    /** Repositorio para el acceso a datos de materiales de enemigo. */
    private final MaterialEnemigoRepository repo;

    /**
     * Constructor que inicializa el servicio con el repositorio de materiales de enemigo.
     * 
     * @param repo el repositorio que maneja el acceso a datos de materiales de enemigo
     */
    public MaterialEnemigoService(MaterialEnemigoRepository repo) {
        this.repo = repo;
    }

    /**
     * Obtiene la lista completa de materiales de enemigo.
     * 
     * @return lista de todos los materiales de enemigo disponibles
     */
    public List<MaterialEnemigo> listar() {
        return repo.findAll();
    }

    /**
     * Guarda un material de enemigo en la base de datos.
     * 
     * @param m el material de enemigo a guardar
     * @return el material de enemigo guardado con su ID asignado
     */
    public MaterialEnemigo guardar(MaterialEnemigo m) {
        return repo.save(m);
    }

    /**
     * Elimina un material de enemigo de la base de datos.
     * 
     * @param id el ID del material de enemigo a eliminar
     */
    public void eliminar(int id) {
        repo.deleteById(id);
    }

    /**
     * Busca un material de enemigo por su ID.
     * 
     * @param id el ID del material de enemigo a buscar
     * @return el material de enemigo encontrado o null si no existe
     */
    public MaterialEnemigo obtener(int id) {
        return repo.findById(id).orElse(null);
    }
}