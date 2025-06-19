package proyecto_de_verdad_ahora_si_deveritas;

/**
 * Representa un personaje dentro del sistema, implementando la interfaz {@link Registro}.
 *
 * <p>Incluye atributos como ID, nombre, rareza y nivel. Es utilizada en operaciones CRUD
 * genéricas mediante paneles dinámicos en la interfaz gráfica.
 */
public class Personaje implements Registro {

    /** Identificador único del personaje. */
    int id;

    /** Rareza del personaje (por ejemplo, 1 a 5 estrellas). */
    int rareza;

    /** Nivel actual del personaje. */
    int nivel;

    /** Nombre del personaje. */
    String nombre;

    /**
     * Constructor por defecto. Utilizado en instancias vacías o dinámicas.
     */
    public Personaje() {}

    /**
     * Constructor completo que inicializa todos los campos del personaje.
     *
     * @param id identificador del personaje
     * @param nombre nombre del personaje
     * @param rareza rareza del personaje
     * @param nivel nivel del personaje
     */
    public Personaje(int id, String nombre, int rareza, int nivel) {
        this.id = id;
        this.nombre = nombre;
        this.rareza = rareza;
        this.nivel = nivel;
    }

    /**
     * Obtiene el valor de un campo del personaje por nombre.
     *
     * @param c nombre del campo ("id", "nombre", "rareza", "nivel")
     * @return el valor correspondiente o {@code null} si no existe
     */
    @Override
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
     * Asigna un nuevo valor a uno de los campos editables del personaje.
     *
     * <p>Solo se pueden modificar {@code nombre}, {@code rareza} y {@code nivel}.
     *
     * @param c nombre del campo a modificar
     * @param v nuevo valor
     */
    @Override
    public void setValue(String c, Object v) {
        switch (c) {
            case "nombre" -> nombre = v.toString();
            case "rareza" -> rareza = Integer.parseInt(v.toString());
            case "nivel" -> nivel = Integer.parseInt(v.toString());
        }
    }

    /**
     * Representación en texto del personaje, generalmente para uso en listas.
     *
     * @return el nombre del personaje
     */
    @Override
    public String toString() {
        return nombre;
    }

    public void setId(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
