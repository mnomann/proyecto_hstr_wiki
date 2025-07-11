package proyecto_de_verdad_ahora_si_deveritas.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * Modelo de datos para representar materiales de enemigo en la aplicación Wiki HSR.
 * Entidad JPA que mapea la tabla de materiales de enemigo en la base de datos.
 * 
 * @version 1.0
 * @since 2025-07-09
 */
@Entity
public class MaterialEnemigoModel {

    /** Identificador único del material de enemigo. */
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /** Nombre del material de enemigo. */
    @Getter
    @Setter
    private String nombre;
    
    /** ID del enemigo que proporciona este material. */
    @Getter
    @Setter
    private int enemigoId;
    
    /** Nombre del enemigo que proporciona este material. */
    @Getter
    @Setter
    private String enemigo;

}