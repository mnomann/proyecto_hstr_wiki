package proyecto_de_verdad_ahora_si_deveritas;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

/**
 * La clase {@code EnemigoFactory} permite crear instancias de {@code Enemigo}
 * a partir de un {@code ResultSet} o generar una instancia vacía.
 *
 */
@Component
public class EnemigoFactory implements RegistroFactory<Enemigo> {

    /**
     * Construye un {@code Enemigo} desde un {@code ResultSet}.
     *
     * @param rs ResultSet con las columnas "id" y "nombre"
     * @return instancia de Enemigo
     * @throws SQLException en caso de error de acceso a datos
     */
    @Override
    public Enemigo fromResultSet(ResultSet rs) throws SQLException {
        return new Enemigo(
            rs.getInt("id"),
            rs.getString("nombre")
        );
    }

    /**
     * Crea una instancia vacía de {@code Enemigo}.
     *
     * @return Enemigo con id 0 y nombre vacío
     */
    @Override
    public Enemigo createEmpty() {
        return new Enemigo(0, "");
    }
}

    