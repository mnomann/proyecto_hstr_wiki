package proyecto_de_verdad_ahora_si_deveritas;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * La clase {@code ViaFactory} es una fábrica para crear instancias de {@link Via}.
 * Implementa la interfaz {@code RegistroFactory} y proporciona métodos para
 * construir objetos {@code Via} a partir de un {@link ResultSet} o crear objetos vacíos.
 */
class ViaFactory implements RegistroFactory<Via> {

    /**
     * Crea una nueva instancia de {@link Via} a partir de un {@link ResultSet}.
     * 
     * @param rs el {@link ResultSet} que contiene los datos necesarios para construir una {@code Via}
     * @return una nueva instancia de {@code Via} con los datos extraídos del {@code ResultSet}
     * @throws SQLException si ocurre un error al acceder a los datos del {@code ResultSet}
     */
    public Via fromResultSet(ResultSet rs) throws SQLException {
        return new Via(rs.getInt("id"), rs.getString("nombre"));
    }

    /**
     * Crea una nueva instancia vacía de {@link Via} con valores por defecto.
     * 
     * @return una nueva instancia de {@code Via} con ID 0 y nombre vacío
     */
    public Via createEmpty() {
        return new Via(0, "");
    }
}
