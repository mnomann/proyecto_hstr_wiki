package proyecto_de_verdad_ahora_si_deveritas.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * Modelo de datos para representar equipamiento en la aplicación Wiki HSR.
 * Entidad JPA que mapea la tabla de equipamiento en la base de datos.
 * 
 * @version 1.0
 * @since 2025-07-09
 */
@Entity
@Getter
@Setter
public class EquipamientoModel {

    /** Identificador único del equipamiento. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /** Nombre del equipamiento. */
    private String nombre;
    
    /** Tipo de equipamiento (ejemplo: arma, reliquia, etc.). */
    private String tipo;
    
    /** Rareza del equipamiento (valor numérico). */
    private int rareza;
    
    /** ID del personaje asociado al equipamiento. */
    private int personajeId;
    
    /** Nombre del personaje asociado al equipamiento. */
    private String personaje;

}