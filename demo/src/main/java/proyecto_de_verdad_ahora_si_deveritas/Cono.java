@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "conos")
public class Cono implements Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private int rareza;
    private int nivel;

    private static final Map<String, Function<Cono, Object>> getters = Map.of(
        "id", Cono::getId,
        "nombre", Cono::getNombre,
        "rareza", Cono::getRareza,
        "nivel", Cono::getNivel
    );

    private static final Map<String, BiConsumer<Cono, Object>> setters = Map.of(
        "nombre", (c, v) -> c.setNombre(v.toString()),
        "rareza", (c, v) -> c.setRareza(Integer.parseInt(v.toString())),
        "nivel", (c, v) -> c.setNivel(Integer.parseInt(v.toString()))
    );

    public Object getValue(String c) {
        return getters.getOrDefault(c, k -> null).apply(this);
    }

    public void setValue(String c, Object v) {
        if (setters.containsKey(c)) {
            setters.get(c).accept(this, v);
        }
    }
}
