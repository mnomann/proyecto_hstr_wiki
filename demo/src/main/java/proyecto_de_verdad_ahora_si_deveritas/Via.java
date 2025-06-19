package proyecto_de_verdad_ahora_si_deveritas;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * La clase {@code Via} representa una vía (tipo de personaje) con un identificador y un nombre.
 * Implementa la interfaz {@code Registro} para permitir el acceso y modificación dinámica de sus propiedades.
 */
@Entity
@Table(name = "vias")
public class Via implements Registro {

    /** Identificador único de la vía. */
    @Id
    private int id;

    /** Nombre de la vía. */
    @Column(nullable = false)
    private String nombre;

    /**
     * Constructor por defecto. Crea una instancia vacía de {@code Via}.
     */
    public Via() {}

    /**
     * Constructor que inicializa una instancia de {@code Via} con un ID y un nombre específicos.
     *
     * @param id     el identificador único de la vía
     * @param nombre el nombre de la vía
     */
    public Via(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters y Setters típicos para JPA

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna el valor de una propiedad de la vía especificada por su nombre.
     *
     * @param c el nombre de la propiedad ("id" o "nombre")
     * @return el valor de la propiedad si existe, o {@code null} si no es reconocida
     */
    @Override
    public Object getValue(String c) {
        return switch (c) {
            case "id" -> id;
            case "nombre" -> nombre;
            default -> null;
        };
    }

    /**
     * Establece el valor de una propiedad de la vía especificada por su nombre.
     * Actualmente solo permite modificar el nombre.
     *
     * @param c el nombre de la propiedad ("nombre")
     * @param v el nuevo valor a establecer
     */
    @Override
    public void setValue(String c, Object v) {
        if ("nombre".equals(c)) {
            this.nombre = v.toString();
        }
    }

    /**
     * Devuelve una representación en cadena de la vía, que en este caso es su nombre.
     *
     * @return el nombre de la vía
     */
    @Override
    public String toString() {
        return nombre;
    }
}
