package proyecto_de_verdad_ahora_si_deveritas;

import java.sql.ResultSet;
import java.sql.SQLException;

interface RegistroFactory<T extends Registro> {
    T fromResultSet(ResultSet rs) throws SQLException;
    T createEmpty();
}
