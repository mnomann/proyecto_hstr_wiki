package proyecto_de_verdad_ahora_si_deveritas;

import java.sql.ResultSet;
import java.sql.SQLException;

class EnemigoFactory implements RegistroFactory<Enemigo> {
    public Enemigo fromResultSet(ResultSet rs) throws SQLException {
        return new Enemigo(
            rs.getInt("id"),
            rs.getString("nombre")
        );
    }

    public Enemigo createEmpty() {
        return new Enemigo(0, "");
    }
}
    