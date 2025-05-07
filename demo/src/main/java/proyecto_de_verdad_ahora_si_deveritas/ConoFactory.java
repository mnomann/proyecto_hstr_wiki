package proyecto_de_verdad_ahora_si_deveritas;

import java.sql.ResultSet;
import java.sql.SQLException;

class ConoFactory implements RegistroFactory<Cono>{
     public Cono fromResultSet(ResultSet rs) throws SQLException {
        return new Cono(
            rs.getInt("id"), rs.getString("nombre"),
            rs.getInt("rareza"), rs.getInt("nivel")
        );
    }
    public Cono createEmpty() {
        return new Cono(0, "", 0, 0);
    }
}
