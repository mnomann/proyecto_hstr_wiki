package proyecto_de_verdad_ahora_si_deveritas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proyecto_de_verdad_ahora_si_deveritas.Enemigo;

/**
 * Repositorio para la gestión de datos de enemigos en la aplicación Wiki HSR.
 * Interfaz que extiende JpaRepository para operaciones CRUD automáticas sobre entidades Enemigo.
 * 
 * @version 1.0
 * @since 2025-07-09
 */
@Repository
public interface EnemigoRepository extends JpaRepository<Enemigo, Integer> {
}
