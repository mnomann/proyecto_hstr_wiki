package proyecto_de_verdad_ahora_si_deveritas.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * Modelo de datos para representar personajes en la aplicación Wiki HSR.
 * Entidad JPA que mapea la tabla de personajes en la base de datos.
 * 
 * @version 1.0
 * @since 2025-07-09
 */
@Entity
@Getter
@Setter
public class PersonajeModel {

    /** Identificador único del personaje. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /** Nombre del personaje. */
    private String nombre;
    
    /** Rareza del personaje (valor numérico). */
    private int rareza;
    
    /** Nivel del personaje. */
    private int nivel;

}