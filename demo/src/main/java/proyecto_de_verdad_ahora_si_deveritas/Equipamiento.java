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

    private int id;
    private String nombre;
    private int rareza;

    public Equipamiento() {}

    public Equipamiento(int id, String nombre, int rareza) {
        this.id = id;
        this.nombre = nombre;
        this.rareza = rareza;
    }

    private static final Map<String, Function<Equipamiento, Object>> getters = Map.of(
        "id", Equipamiento::getId,
        "nombre", Equipamiento::getNombre,
        "rareza", Equipamiento::getRareza
    );

    private static final Map<String, BiConsumer<Equipamiento, Object>> setters = Map.of(
        "nombre", (e, v) -> e.setNombre(v.toString()),
        "rareza", (e, v) -> e.setRareza(Integer.parseInt(v.toString()))
    );

    /**
     * Retorna el valor de un atributo dado su nombre como cadena.
     *
     * @param c nombre del atributo ("id", "nombre", "rareza")
     * @return el valor correspondiente al atributo, o {@code null} si el nombre no es válido
     */
    @Override
    public Object getValue(String c) {
        return getters.getOrDefault(c, k -> null).apply(this);
    }

    /**
     * Asigna un valor*
