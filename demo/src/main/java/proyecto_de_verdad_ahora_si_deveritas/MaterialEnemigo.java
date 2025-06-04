package proyecto_de_verdad_ahora_si_deveritas;

/**
 * Representa un material que se obtiene de un enemigo, implementando la interfaz {@link Registro}.
 *
 * <p>Incluye información como el identificador del material, su nombre, el ID del enemigo del que proviene
 * y el nombre de dicho enemigo. Se utiliza comúnmente para operaciones CRUD dentro del sistema.
 */
public class MaterialEnemigo implements Registro {

    /** Identificador único del material. */
    int id;

    /** Identificador del enemigo asociado al material. */
    int enemigo_id;

    /** Nombre del material. */
    String nombre;

    /** Nombre del enemigo del que se obtiene el material. */
    String enemigo;

    /**
     * Constructor por defecto. Requerido para instanciación mediante fábricas.
     */
    public MaterialEnemigo() {}

    /**
     * Crea una instancia completa de {@code MaterialEnemigo} con los datos especificados.
     *
     * @param id identificador del material
     * @param nombre nombre del material
     * @param enemigo_id identificador del enemigo
     * @param enemigo nombre del enemigo
     */
    public MaterialEnemigo(int id, String nombre, int enemigo_id, String enemigo) {
        this.id = id;
        this.nombre = nombre;
        this.enemigo_id = enemigo_id;
        this.enemigo = enemigo;
    }

    /**
     * Devuelve el valor de uno de los atributos del material, dado su nombre.
     *
     * @param c nombre del atributo ("id", "nombre", "enemigo_id", "enemigo")
     * @return el valor correspondiente o {@code null} si no existe ese atributo
     */
    @Override
    public Object getValue(String c) {
        return switch (c) {
            case "id" -> id;
            case "nombre" -> nombre;
            case "enemigo_id" -> enemigo_id;
            case "enemigo" -> enemigo;
            default -> null;
        };
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
        switch (c) {
            case "nombre" -> nombre = v.toString();
            case "enemigo_id" -> enemigo_id = Integer.parseInt(v.toString());
        }
    }

    /**
     * Devuelve una representación en texto del material.
     *
     * @return una cadena con el nombre del material seguido del nombre del enemigo entre paréntesis
     */
    @Override
    public String toString() {
        return nombre + " (" + enemigo + ")";
    }

    public void setId(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
