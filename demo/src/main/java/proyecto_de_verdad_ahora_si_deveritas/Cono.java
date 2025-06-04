package proyecto_de_verdad_ahora_si_deveritas;

import jakarta.persistence.*;
import lombok.*;

/**
 * La clase {@code Cono} representa un objeto con atributos identificadores, nombre, rareza y nivel.
 * Se ha adaptado como entidad JPA para persistencia en base de datos.
 */
@Entity
@Table(name = "conos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cono implements Registro {

    /** Identificador único del objeto */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /** Nombre del objeto */
    private String nombre;

    /** Rareza del objeto, representada como un número entero */
    private int rareza;

    /** Nivel del objeto */
    private int nivel;

    /**
     * Obtiene el valor del atributo especificado por nombre.
     * 
     * @param c Nombre del atributo (puede ser "id", "nombre", "rareza" o "nivel")
     * @return El valor correspondiente del atributo, o {@code null} si no existe
     */
    public Object getValue(String c) {
        return switch (c) {
            case "id" -> id;
            case "nombre" -> nombre;
            case "rareza" -> rareza;
            case "nivel" -> nivel;
            default -> null;
        };
    }

    /**
     * Establece el valor del atributo especificado por nombre.
     * Solo permite modificar los atributos: nombre, rareza y nivel.
     * 
     * @param c Nombre del atributo a modificar ("nombre", "rareza" o "nivel")
     * @param v Valor a establecer
     */
    public void setValue(String c, Object v) {
        switch (c) {
            case "nombre" -> nombre = v.toString();
            case "rareza" -> rareza = Integer.parseInt(v.toString());
            case "nivel" -> nivel = Integer.parseInt(v.toString());
        }
    }
}

