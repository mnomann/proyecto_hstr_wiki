package proyecto_de_verdad_ahora_si_deveritas;

/**
 * La clase {@code Via} representa una vía (tipo de personaje) con un identificador y un nombre.
 * Implementa la interfaz {@code Registro} para permitir el acceso y modificación dinámica de sus propiedades.
 */
class Via implements Registro {

    /** Identificador único de la vía. */
    int id;

    /** Nombre de la vía. */
    String nombre;

    /**
     * Constructor por defecto. Crea una instancia vacía de {@code Via}.
     */
    Via() {}

    /**
     * Constructor que inicializa una instancia de {@code Via} con un ID y un nombre específicos.
     *
     * @param id     el identificador único de la vía
     * @param nombre el nombre de la vía
     */
    Via(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Retorna el valor de una propiedad de la vía especificada por su nombre.
     *
     * @param c el nombre de la propiedad ("id" o "nombre")
     * @return el valor de la propiedad si existe, o {@code null} si no es reconocida
     */
    public Object getValue(String c) {
        if ("id".equals(c)) return id;
        if ("nombre".equals(c)) return nombre;
        return null;
    }

    /**
     * Establece el valor de una propiedad de la vía especificada por su nombre.
     * Actualmente solo permite modificar el nombre.
     *
     * @param c el nombre de la propiedad ("nombre")
     * @param v el nuevo valor a establecer
     */
    public void setValue(String c, Object v) {
        if ("nombre".equals(c)) nombre = v.toString();
    }

    /**
     * Devuelve una representación en cadena de la vía, que en este caso es su nombre.
     *
     * @return el nombre de la vía
     */
    public String toString() {
        return nombre;
    }
}
