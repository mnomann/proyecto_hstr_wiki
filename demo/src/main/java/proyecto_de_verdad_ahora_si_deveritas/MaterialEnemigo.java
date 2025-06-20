package proyecto_de_verdad_ahora_si_deveritas;

package proyecto_de_verdad_ahora_si_deveritas;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * Representa un material que se obtiene de un enemigo, implementando la interfaz {@link Registro}.
 *
 * <p>Incluye información como el identificador del material, su nombre, el ID del enemigo del que proviene
 * y el nombre de dicho enemigo. Se utiliza comúnmente para operaciones CRUD dentro del sistema.
 */
public class MaterialEnemigo implements Registro {

    int id;
    int enemigo_id;
    String nombre;
    String enemigo;

    public MaterialEnemigo() {}

    public MaterialEnemigo(int id, String nombre, int enemigo_id, String enemigo) {
        this.id = id;
        this.nombre = nombre;
        this.enemigo_id = enemigo_id;
        this.enemigo = enemigo;
    }

    private static final Map<String, Function<MaterialEnemigo, Object>> getters = Map.of(
        "id", MaterialEnemigo::getId,
        "nombre", MaterialEnemigo::getNombre,
        "enemigo_id", MaterialEnemigo::getEnemigoId,
        "enemigo", MaterialEnemigo::getEnemigo
    );

    private static final Map<String, BiConsumer<MaterialEnemigo, Object>> setters = Map.of(
        "nombre", (m, v) -> m.setNombre(v.toString()),
        "enemigo_id", (m, v) -> m.setEnemigoId(Integer.parseInt(v.toString()))
    );

    /**
     * Devuelve el valor de uno de los atributos del material, dado su nombre.
     *
     * @param c nombre del atributo ("id", "nombre", "enemigo_id", "enemigo")
     * @return el valor correspondiente o {@code null} si no existe ese atributo
     */
    @Override
    public Object getValue(String c) {
        return getters.getOrDefault(c, k -> null).apply(this);
    }

    /**
     * Asigna un nuevo valor a uno de los atributos del material.
     *
     * <p>Solo permite modificar los campos {@code nombre} y {@code enemigo_id}.
     *
     * @param c nombre del atributo
     * @param v nuevo valor
     */
    @Override
    public void setValue(String c, Object v) {
        if (setters.containsKey(c)) {
            setters.get(c).accept(this, v);
        }
    }

    @Override
    public String toString() {
        return nombre + " (" + enemigo + ")";
    }

    public int getId() {
        return id;
    }

    public int getEnemigoId() {
        return enemigo_id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEnemigo() {
        return enemigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEnemigoId(int enemigo_id) {
        this.enemigo_id = enemigo_id;
    }

    public void setId(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
