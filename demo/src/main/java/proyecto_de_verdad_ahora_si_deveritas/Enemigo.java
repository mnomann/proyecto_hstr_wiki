package proyecto_de_verdad_ahora_si_deveritas;

/**
 * La clase {@code Enemigo} representa una entidad enemiga con atributos como
 * identificador, nombre, nivel y tipo. Implementa la interfaz {@code Registro},
 * lo que permite acceso y modificación dinámica a ciertos atributos.
 * 
 * <p>Actualmente, los métodos {@code getValue} y {@code setValue} solo permiten acceder o modificar
 * los campos {@code id} y {@code nombre}.</p>
 * 
 */
class Enemigo implements Registro {

    /** Identificador único del enemigo */
    int id;

    /** Nivel del enemigo (no usado directamente en los métodos dinámicos) */
    int nivel;

    /** Identificador del tipo de enemigo (referencia externa opcional) */
    int tipoEnemigoId;

    /** Nombre del enemigo */
    String nombre;

    /** Nombre del tipo de enemigo (ej. "Barion", "Engendro Escarchado", etc.) */
    String tipoNombre;

    /**
     * Constructor por defecto. Crea una instancia vacía de {@code Enemigo}.
     */
    Enemigo() {}

    /**
     * Constructor con parámetros básicos.
     * 
     * @param id     Identificador del enemigo
     * @param nombre Nombre del enemigo
     */
    Enemigo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Obtiene el valor de un atributo según el nombre proporcionado.
     * 
     * @param c Nombre del atributo ("id" o "nombre")
     * @return El valor correspondiente del atributo, o {@code null} si no es válido
     */
    public Object getValue(String c) {
        switch (c) {
            case "id": return id;
            case "nombre": return nombre;
        }
        return null;
    }

    /**
     * Establece el valor de un atributo según el nombre proporcionado.
     * 
     * <p>Actualmente, solo permite modificar el atributo {@code nombre}.</p>
     * 
     * @param c Nombre del atributo a modificar ("nombre")
     * @param v Valor a establecer
     */
    public void setValue(String c, Object v) {
        switch (c) {
            case "nombre":
                nombre = v.toString();
                break;
        }
    }

    /**
     * Devuelve una representación en texto del enemigo, incluyendo su tipo.
     * 
     * @return Cadena con el formato {@code "nombre (tipoNombre)"}
     */
    public String toString() {
        return nombre + " (" + tipoNombre + ")";
    }
}
