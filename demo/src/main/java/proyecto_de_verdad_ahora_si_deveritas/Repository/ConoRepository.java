package proyecto_de_verdad_ahora_si_deveritas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proyecto_de_verdad_ahora_si_deveritas.Cono;

/**
 * Repositorio para la gestión de datos de conos en la aplicación Wiki HSR.
 * Interfaz que extiende JpaRepository para operaciones CRUD automáticas sobre entidades Cono.
 * 
 * @version 1.0
 * @since 2025-07-09
 */
@Repository
public interface ConoRepository extends JpaRepository<Cono, Integer> {
}
