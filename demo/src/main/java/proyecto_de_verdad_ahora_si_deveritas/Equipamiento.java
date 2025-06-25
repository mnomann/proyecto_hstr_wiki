package proyecto_de_verdad_ahora_si_deveritas;

/**
 * Representa un objeto de tipo Equipamiento que implementa la interfaz {@code Registro}.
 *
 * <p>Contiene información básica como identificador, nombre y rareza.
 * Es utilizado como modelo de datos para operaciones CRUD genéricas en la interfaz.
 * </p>
 * 
 */
public class Equipamiento implements Registro {

    /** Identificador único del equipamiento. */
    private int id;

    /** Nombre del equipamiento. */
    private String nombre;

    /** Nivel de rareza del equipamiento. */
    private int rareza;

    /**
     * Constructor por defecto. Necesario para la creación mediante reflexión o fábrica.
     */
    public Equipamiento() {}

    /**
     * Crea un nuevo objeto {@code Equipamiento} con los valores especificados.
     *
     * @param id identificador único
     * @param nombre nombre del equipamiento
     * @param rareza nivel de rareza del equipamiento
     */
    public Equipamiento(int id, String nombre, int rareza) {
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
        switch (c) {
            case "id": return id;
            case "nombre": return nombre;
            case "rareza": return rareza;
            default: return null;
        }
    }

    /**
     * Asigna un valor a un atributo específico del equipamiento.
     *
     * <p>Este método no permite modificar el campo {@code id}.</p>
     *
     * @param c nombre del atributo a modificar ("nombre", "rareza")
     * @param v nuevo valor del atributo (como {@code Object})
     */
    @Override
    public void setValue(String c, Object v) {
        switch (c) {
            case "nombre":
                this.nombre = v.toString();
                break;
            case "rareza":
                this.rareza = Integer.parseInt(v.toString());
                break;
            // no permitir modificar el ID
        }
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

    public void setId(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
