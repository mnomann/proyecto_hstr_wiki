package proyecto_de_verdad_ahora_si_deveritas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proyecto_de_verdad_ahora_si_deveritas.Enemigo;

@Repository
public interface EnemigoRepository extends JpaRepository<Enemigo, Integer> {
}
