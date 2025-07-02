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
 * Representa un material que se obtiene de un enemigo, implementando la interfaz {@link Registro}.
 */
@Entity
@Table(name = "material_enemigo")
public class MaterialEnemigo implements Registro {

    /** Identificador único del material. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** Identificador del enemigo al que pertenece. */
    @Column(name = "enemigo_id", nullable = false)
    private Integer enemigoId;

    /** Nombre del material. */
    @Column(nullable = false)
    private String nombre;

    /** Nombre descriptivo del enemigo. */
    @Column(nullable = false)
    private String enemigo;

    public MaterialEnemigo() {}

    /** Constructor de conveniencia (sin id, JPA lo asigna). */
    public MaterialEnemigo(String nombre, Integer enemigoId, String enemigo) {
        this.nombre     = nombre;
        this.enemigoId  = enemigoId;
        this.enemigo    = enemigo;
    }

     public MaterialEnemigo(Integer id, String nombre, Integer enemigoId, String enemigo) {
        this.id         = id;
        this.nombre     = nombre;
        this.enemigoId  = enemigoId;
        this.enemigo    = enemigo;
    }

    // Mapas de getters/setters para la interfaz Registro
    private static final Map<String, Function<MaterialEnemigo, Object>> getters = Map.of(
        "id", MaterialEnemigo::getId,
        "nombre", MaterialEnemigo::getNombre,
        "enemigo_id", MaterialEnemigo::getEnemigoId,
        "enemigo", MaterialEnemigo::getEnemigo
    );

    private static final Map<String, BiConsumer<MaterialEnemigo, Object>> setters = Map.of(
        "nombre",     (m, v) -> m.setNombre(v.toString()),
        "enemigo_id", (m, v) -> m.setEnemigoId(Integer.parseInt(v.toString()))
    );

    /** Implementación de Registro: obtener valor dinámicamente. */
    @Override
    public Object getValue(String campo) {
        return getters.getOrDefault(campo, m -> null).apply(this);
    }

    /** Implementación de Registro: asignar valor dinámicamente. */
    @Override
    public void setValue(String campo, Object valor) {
        if (setters.containsKey(campo)) {
            setters.get(campo).accept(this, valor);
        }
    }

    @Override
    public String toString() {
        return nombre + " (de: " + enemigo + ")";
    }

    // —— Getters y Setters —— //

    public Integer getId() {
        return id;
    }
    // no setter público de id

   public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEnemigoId() {
        return enemigoId;
    }
    public void setEnemigoId(Integer enemigoId) {
        this.enemigoId = enemigoId;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEnemigo() {
        return enemigo;
    }
    public void setEnemigo(String enemigo) {
        this.enemigo = enemigo;
    }
}
