package proyecto_de_verdad_ahora_si_deveritas;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EquipamientoFactory implements RegistroFactory<Equipamiento>{
         public Equipamiento fromResultSet(ResultSet rs) throws SQLException {
        return new Equipamiento(
            rs.getInt("id"), rs.getString("nombre"),
            rs.getInt("rareza")
        );
    }
    public Equipamiento createEmpty() {
        return new Equipamiento(0, "", 0);
    }
    
}
