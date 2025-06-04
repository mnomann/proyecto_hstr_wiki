package proyecto_de_verdad_ahora_si_deveritas;

import jakarta.persistence.*;
import lombok.*;

/**
 * La clase {@code Enemigo} representa una entidad enemiga con atributos como
 * identificador, nombre, nivel y tipo. Adaptada como entidad JPA para persistencia en base de datos.
 */
@Entity
@Table(name = "enemigos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Enemigo implements Registro {

    /** Identificador único del enemigo */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /** Nivel del enemigo */
    private int nivel;

    /** Identificador del tipo de enemigo (referencia externa opcional) */
    private int tipoEnemigoId;

    /** Nombre del enemigo */
    private String nombre;

    /** Nombre del tipo de enemigo (por ejemplo: "Barion", "Engendro Escarchado", etc.) */
    private String tipoNombre;

    /**
     * Constructor básico para crear un enemigo solo con ID y nombre.
     */
    public Enemigo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Obtiene dinámicamente el valor de un atributo.
     *
     * @param c nombre del campo ("id", "nombre")
     * @return valor correspondiente o null si no se encuentra
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
     * Establece dinámicamente el valor de un atributo.
     * Actualmente, solo se permite modificar "nombre".
     *
     * @param c nombre del campo
     * @param v nuevo valor
     */
    @Override
    public void setValue(String c, Object v) {
        if ("nombre".equals(c)) {
            nombre = v.toString();
        }
    }

    /**
     * Representación del enemigo con nombre y tipo.
     */
    @Override
    public String toString() {
        return nombre + " (" + tipoNombre + ")";
    }
}

