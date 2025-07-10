package proyecto_de_verdad_ahora_si_deveritas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import proyecto_de_verdad_ahora_si_deveritas.MaterialEnemigo;

/**
 * Repositorio para la gestión de datos de materiales de enemigo en la aplicación Wiki HSR.
 * Interfaz que extiende JpaRepository para operaciones CRUD automáticas sobre entidades MaterialEnemigo.
 * 
 * @version 1.0
 * @since 2025-07-09
 */
public interface MaterialEnemigoRepository extends JpaRepository<MaterialEnemigo, Integer> {}

