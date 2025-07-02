package proyecto_de_verdad_ahora_si_deveritas;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Representa un personaje dentro del sistema, implementando la interfaz {@link Registro}.
 *
 * <p>Incluye atributos como ID, nombre, rareza y nivel. Es utilizada en operaciones CRUD
 * genéricas mediante paneles dinámicos en la interfaz gráfica.
 */
@Entity
@Table(name = "personajes")
public class Personaje implements Registro {

    /** Identificador único del personaje. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** Rareza del personaje (por ejemplo, 1 a 5 estrellas). */
    @Column(nullable = false)
    private Integer rareza;

    /** Nivel actual del personaje. */
    @Column(nullable = false)
    private Integer nivel;

    /** Nombre del personaje. */
    @Column(nullable = false)
    private String nombre;

    /** Constructor vacío requerido por JPA. */
    public Personaje() {}

    /**
     * Constructor de conveniencia (sin id, JPA lo asigna).
     *
     * @param nombre nombre del personaje
     * @param rareza rareza del personaje
     * @param nivel  nivel del personaje
     */
    public Personaje(String nombre, Integer rareza, Integer nivel) {
        this.nombre = nombre;
        this.rareza = rareza;
        this.nivel  = nivel;
    }

     public Personaje(Integer id, String nombre, Integer rareza, Integer nivel) {
        this.id     = id;
        this.nombre = nombre;
        this.rareza = rareza;
        this.nivel  = nivel;
    }

    // —— Mapas para Registro —— //
    private static final Map<String, Function<Personaje, Object>> getters = Map.of(
        "id",      Personaje::getId,
        "nombre",  Personaje::getNombre,
        "rareza",  Personaje::getRareza,
        "nivel",   Personaje::getNivel
    );

    private static final Map<String, BiConsumer<Personaje, Object>> setters = Map.of(
        "nombre", (p, v) -> p.setNombre(v.toString()),
        "rareza", (p, v) -> p.setRareza(Integer.parseInt(v.toString())),
        "nivel",  (p, v) -> p.setNivel(Integer.parseInt(v.toString()))
    );

    @Override
    public Object getValue(String campo) {
        return getters.getOrDefault(campo, p -> null).apply(this);
    }

    @Override
    public void setValue(String campo, Object valor) {
        if (setters.containsKey(campo)) {
            setters.get(campo).accept(this, valor);
        }
    }

    @Override
    public String toString() {
        return nombre;
    }

    // —— Getters y Setters para JPA —— //

    public Integer getId() {
        return id;
    }
    // no public setter de id

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRareza() {
        return rareza;
    }
    public void setRareza(Integer rareza) {
        this.rareza = rareza;
    }

    public Integer getNivel() {
        return nivel;
    }
    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
