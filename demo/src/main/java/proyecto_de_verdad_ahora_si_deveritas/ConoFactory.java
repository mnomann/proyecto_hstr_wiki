package proyecto_de_verdad_ahora_si_deveritas;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * La clase {@code ConoFactory} es una fábrica que permite crear instancias de {@code Cono}
 * a partir de un {@code ResultSet} de una base de datos o generar un objeto vacío por defecto.
 * 
 * <p>Implementa la interfaz {@code RegistroFactory<Cono>} para facilitar la integración
 * con mecanismos genéricos de carga de datos.</p>
 * 
 */
class ConoFactory implements RegistroFactory<Cono> {

    /**
     * Crea una instancia de {@code Cono} a partir de un {@code ResultSet}.
     * 
     * <p>Los nombres de las columnas esperadas en el {@code ResultSet} son:
     * "id", "nombre", "rareza" y "nivel".</p>
     * 
     * @param rs El {@code ResultSet} desde el cual se extraen los datos
     * @return Una nueva instancia de {@code Cono} con los valores obtenidos del {@code ResultSet}
     * @throws SQLException Si ocurre un error al acceder a los datos del {@code ResultSet}
     */
    public Cono fromResultSet(ResultSet rs) throws SQLException {
        return new Cono(
            rs.getInt("id"),
            rs.getString("nombre"),
            rs.getInt("rareza"),
            rs.getInt("nivel")
        );
    }

    /**
     * Crea una instancia vacía de {@code Cono} con valores predeterminados.
     * 
     * <p>Este método se utiliza para inicializar objetos antes de ser completados
     * con valores específicos.</p>
     * 
     * @return Una nueva instancia vacía de {@code Cono}
     */
    public Cono createEmpty() {
        return new Cono(0, "", 0, 0);
    }
}
