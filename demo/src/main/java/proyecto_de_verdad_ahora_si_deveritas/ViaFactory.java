package proyecto_de_verdad_ahora_si_deveritas;

import java.sql.ResultSet;
import java.sql.SQLException;

class ViaFactory implements RegistroFactory<Via> {
    public Via fromResultSet(ResultSet rs) throws SQLException {
        return new Via(rs.getInt("id"), rs.getString("nombre"));
    }
    public Via createEmpty() { return new Via(0, ""); }
}