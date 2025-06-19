package proyecto_de_verdad_ahora_si_deveritas;

import jakarta.persistence.*;
import lombok.*;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int nivel;
    private int tipoEnemigoId;
    private String nombre;
    private String tipoNombre;

    /**
     * Constructor básico para crear un enemigo solo con ID y nombre.
     */
    public Enemigo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    private static final Map<String, Function<Enemigo, Object>> getters = Map.of(
        "id", Enemigo::getId,
        "nombre", Enemigo::getNombre,
        "nivel", Enemigo::getNivel,
        "tipoEnemigoId", Enemigo::getTipoEnemigoId,
        "tipoNombre", Enemigo::getTipoNombre
    );

    private static final Map<String, BiConsumer<Enemigo, Object>> setters = Map.of(
        "nombre", (e, v) -> e.setNombre(v.toString())
        // solo se permite modificar "nombre" por ahora
    );

    /**
     * Obtiene dinámicamente el valor de un atributo.
     *
     * @param c nombre del campo ("id", "nombre", "nivel", etc.)
     * @return valor correspondiente o null si no se encuentra
     */
    @Override
    public Object getValue(String c) {
        return getters.getOrDefault(c, k -> null).apply(this);
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
        if (setters.containsKey(c)) {
            setters.get(c).accept(this, v);
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
