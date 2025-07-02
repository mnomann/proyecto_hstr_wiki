package proyecto_de_verdad_ahora_si_deveritas;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Representa un objeto de tipo Equipamiento que implementa la interfaz {@code Registro}.
 *
 * <p>Contiene información básica como identificador, nombre y rareza.
 * Es utilizado como modelo de datos para operaciones CRUD genéricas en la interfaz.
 * </p>
 */
@Entity
@Table(name = "equipamientos")
public class Equipamiento implements Registro {

    /** Identificador único del equipamiento. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** Nombre del equipamiento. */
    @Column(nullable = false)
    private String nombre;

    /** Nivel de rareza del equipamiento. */
    @Column(nullable = false)
    private Integer rareza;

    /** Constructor por defecto. */
    public Equipamiento() {}

    /**
     * Crea un nuevo objeto {@code Equipamiento} con los valores especificados.
     *
     * @param nombre nombre del equipamiento
     * @param rareza nivel de rareza del equipamiento
     */
    public Equipamiento(String nombre, Integer rareza) {
        this.nombre = nombre;
        this.rareza = rareza;
    }

    public Equipamiento(Integer id, String nombre, Integer rareza) {
    this.id = id;
    this.nombre = nombre;
    this.rareza = rareza;
}

    // --------------------
    // Getters y Setters
    // --------------------

    public Integer getId() {
        return id;
    }

    // No setter de ID público para mantener integridad; JPA lo asigna.

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getRareza() {
        return rareza;
    }
    public void setRareza(Integer rareza) {
        this.rareza = rareza;
    }

    // --------------------
    // Implementación de Registro
    // --------------------

    @Override
    public Object getValue(String campo) {
        switch (campo) {
            case "id":      return id;
            case "nombre":  return nombre;
            case "rareza":  return rareza;
            default:        return null;
        }
    }

    @Override
    public void setValue(String campo, Object valor) {
        switch (campo) {
            case "nombre":
                this.nombre = valor.toString();
                break;
            case "rareza":
                this.rareza = Integer.parseInt(valor.toString());
                break;
            // no permita modificar id
        }
    }

    public void setId(Integer id) {
    this.id = id;
}

    @Override
    public String toString() {
        return "Equipamiento{" +
               "id=" + id +
               ", nombre='" + nombre + '\'' +
               ", rareza=" + rareza +
               '}';
    }
}
