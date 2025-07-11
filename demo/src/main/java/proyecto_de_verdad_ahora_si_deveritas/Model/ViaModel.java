package proyecto_de_verdad_ahora_si_deveritas.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Modelo de datos para representar vías en la aplicación Wiki HSR.
 * Entidad JPA que mapea la tabla de vías en la base de datos.
 * 
 * @author [Tu nombre]
 * @version 1.0
 * @since 2025-07-09
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViaModel {

    /** Identificador único de la vía. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** Nombre de la vía. */
    private String nombre;
}
