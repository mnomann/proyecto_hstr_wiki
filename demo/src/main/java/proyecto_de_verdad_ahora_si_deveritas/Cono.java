package proyecto_de_verdad_ahora_si_deveritas;

/**
 * La clase {@code Cono} representa un objeto con atributos identificadores, nombre, rareza y nivel.
 * Implementa la interfaz {@code Registro}, permitiendo obtener y modificar valores de atributos
 * mediante nombres de campos como cadena de texto.
 * 
 * <p>Es utilizada principalmente como estructura de datos flexible en la que los atributos
 * pueden ser accedidos dinámicamente por nombre, facilitando su manipulación en interfaces genéricas.</p>
 * 
 */
class Cono implements Registro {
    /** Identificador único del objeto */
    int id;

    /** Rareza del objeto, representada como un número entero */
    int rareza;

    /** Nivel del objeto */
    int nivel;

    /** Nombre del objeto */
    String nombre;

    /**
     * Constructor por defecto. Crea una instancia vacía de {@code Cono}.
     */
    Cono() {}

    /**
     * Constructor con parámetros. Crea una instancia de {@code Cono} con valores iniciales.
     * 
     * @param id      Identificador único del objeto
     * @param nombre  Nombre del objeto
     * @param rareza  Rareza del objeto (entero)
     * @param nivel   Nivel del objeto (entero)
     */
    Cono(int id, String nombre, int rareza, int nivel) {
        this.id = id;
        this.nombre = nombre;
        this.rareza = rareza;
        this.nivel = nivel;
    }

    /**
     * Obtiene el valor del atributo especificado por nombre.
     * 
     * @param c Nombre del atributo (puede ser "id", "nombre", "rareza" o "nivel")
     * @return El valor correspondiente del atributo, o {@code null} si no existe
     */
    public Object getValue(String c) {
        if ("id".equals(c)) return id;
        if ("nombre".equals(c)) return nombre;
        if ("rareza".equals(c)) return rareza;
        if ("nivel".equals(c)) return nivel;
        return null;
    }

    /**
     * Establece el valor del atributo especificado por nombre.
     * Solo permite modificar los atributos: nombre, rareza y nivel.
     * 
     * @param c Nombre del atributo a modificar ("nombre", "rareza" o "nivel")
     * @param v Valor a establecer
     */
    public void setValue(String c, Object v) {
        if ("nombre".equals(c)) nombre = v.toString();
        else if ("rareza".equals(c)) rareza = Integer.parseInt(v.toString());
        else if ("nivel".equals(c)) nivel = Integer.parseInt(v.toString());
    }

    /**
     * Retorna una representación textual del objeto, en este caso, su nombre.
     * 
     * @return El nombre del objeto
     */
    public String toString() {
        return nombre;
    }
}

