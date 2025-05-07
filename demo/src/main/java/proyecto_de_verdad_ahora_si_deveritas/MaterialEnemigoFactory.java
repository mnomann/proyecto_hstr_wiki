package proyecto_de_verdad_ahora_si_deveritas;

import java.sql.ResultSet;
import java.sql.SQLException;

class MaterialEnemigoFactory implements RegistroFactory<MaterialEnemigo> {
    public MaterialEnemigo fromResultSet(ResultSet rs) throws SQLException {
        return new MaterialEnemigo(
            rs.getInt("id"),
            rs.getString("nombre"),
            rs.getInt("enemigo_id"),
            rs.getString("enemigo")
        );
    }

    public MaterialEnemigo createEmpty() {
        return new MaterialEnemigo(0, "", 0, "");
    }
}