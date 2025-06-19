package proyecto_de_verdad_ahora_si_deveritas;

import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * La clase {@code ConoFactory} permite crear instancias de {@code Cono}
 * desde un {@code ResultSet}, útil para cargas personalizadas o importaciones.
 */
@Component
public class ConoFactory implements RegistroFactory<Cono> {

    /**
     * Crea una instancia de {@code Cono} a partir de un {@code ResultSet}.
     *
     * @param rs ResultSet con columnas: "id", "nombre", "rareza", "nivel"
     * @return instancia poblada de {@code Cono}
     * @throws SQLException si ocurre un error de acceso a datos
     */
    @Override
    public Cono fromResultSet(ResultSet rs) throws SQLException {
        return new Cono(
            rs.getInt("id"),
            rs.getString("nombre"),
            rs.getInt("rareza"),
            rs.getInt("nivel")
        );
    }

    /**
     * Crea una instancia vacía (default) de {@code Cono}.
     *
     * @return Cono vacío
     */
    @Override
    public Cono createEmpty() {
        return new Cono(0, "", 0, 0);
    }
}

