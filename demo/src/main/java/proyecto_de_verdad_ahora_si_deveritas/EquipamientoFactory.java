package proyecto_de_verdad_ahora_si_deveritas;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

/**
 * Fábrica para crear instancias de {@link Equipamiento} a partir de un {@link ResultSet}
 * o desde cero.
 *
 * <p>Esta clase implementa la interfaz {@code RegistroFactory<Equipamiento>} y permite
 * la creación de objetos {@code Equipamiento} tanto desde resultados de consulta SQL
 * como vacíos para inserciones nuevas.
 */
@Component
public class EquipamientoFactory implements RegistroFactory<Equipamiento> {

    /**
     * Crea una instancia de {@code Equipamiento} a partir de un {@code ResultSet}.
     *
     * <p>Extrae los campos {@code id}, {@code nombre} y {@code rareza} del resultado
     * de la consulta.
     *
     * @param rs el {@code ResultSet} obtenido de una consulta SQL
     * @return una nueva instancia de {@code Equipamiento}
     * @throws SQLException si ocurre un error al acceder a los datos del {@code ResultSet}
     */
    @Override
    public Equipamiento fromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String nombre = rs.getString("nombre");
        int rareza = rs.getInt("rareza");
        return new Equipamiento(id, nombre, rareza);
    }

    /**
     * Crea una instancia vacía de {@code Equipamiento}, con valores por defecto.
     *
     * @return un {@code Equipamiento} con id 0, nombre vacío y rareza 0
     */
    @Override
    public Equipamiento createEmpty() {
        return new Equipamiento(0, "", 0);
    }
}