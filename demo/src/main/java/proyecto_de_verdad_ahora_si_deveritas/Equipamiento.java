package proyecto_de_verdad_ahora_si_deveritas;

/**
 * Representa un objeto de tipo Equipamiento que implementa la interfaz {@code Registro}.
 *
 * <p>Contiene información básica como identificador, nombre y rareza.
 * Es utilizado como modelo de datos para operaciones CRUD genéricas en la interfaz.
 */
public class Equipamiento implements Registro {

    /** Identificador único del equipamiento. */
    int id;

    /** Nombre del equipamiento. */
    String nombre;

    /** Nivel de rareza del equipamiento. */
    int rareza;

    /**
     * Constructor por defecto. Necesario para la creación mediante reflexión o fábrica.
     */
    Equipamiento() {}

    /**
     * Crea un nuevo objeto {@code Equipamiento} con los valores especificados.
     *
     * @param id identificador único
     * @param nombre nombre del equipamiento
     * @param rareza nivel de rareza del equipamiento
     */
    Equipamiento(int id, String nombre, int rareza) {
        this.id = id;
        this.nombre = nombre;
        this.rareza = rareza;
    }

    /**
     * Retorna el valor de un atributo dado su nombre como cadena.
     *
     * @param c nombre del atributo ("id", "nombre", "rareza")
     * @return el valor correspondiente al atributo, o {@code null} si el nombre no es válido
     */
    @Override
    public Object getValue(String c) {
        if ("id".equals(c)) return id;
        if ("nombre".equals(c)) return nombre;
        if ("rareza".equals(c)) return rareza;
        return null;
    }

    /**
     * Asigna un valor a un atributo específico del equipamiento.
     *
     * <p>Este método no permite modificar el campo {@code id}.
     *
     * @param c nombre del atributo a modificar ("nombre", "rareza")
     * @param v nuevo valor del atributo (como {@code Object})
     */
    @Override
    public void setValue(String c, Object v) {
        if ("nombre".equals(c)) nombre = v.toString();
        else if ("rareza".equals(c)) rareza = Integer.parseInt(v.toString());
    }

    /**
     * Representación en forma de cadena del equipamiento.
     *
     * @return el nombre del equipamiento
     */
    @Override
    public String toString() {
        return nombre;
    }
}
