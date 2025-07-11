package proyecto_de_verdad_ahora_si_deveritas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import proyecto_de_verdad_ahora_si_deveritas.Via;

/**
 * Repositorio para la gestión de datos de vías en la aplicación Wiki HSR.
 * Interfaz que extiende JpaRepository para operaciones CRUD automáticas sobre entidades Via.
 * 
 * @version 1.0
 * @since 2025-07-09
 */
public interface ViaRepository extends JpaRepository<Via, Integer> {
}