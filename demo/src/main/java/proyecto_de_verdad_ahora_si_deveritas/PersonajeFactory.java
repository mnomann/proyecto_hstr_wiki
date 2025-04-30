package proyecto_de_verdad_ahora_si_deveritas;

import java.sql.ResultSet;
import java.sql.SQLException;

class PersonajeFactory implements RegistroFactory<Personaje> {
    public Personaje fromResultSet(ResultSet rs) throws SQLException {
        return new Personaje(
            rs.getInt("id"), rs.getString("nombre"),
            rs.getInt("rareza"), rs.getInt("nivel")
        );
    }
    public Personaje createEmpty() {
        return new Personaje(0, "", 0, 0);
    }
}