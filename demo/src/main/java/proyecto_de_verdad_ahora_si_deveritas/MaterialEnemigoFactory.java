package proyecto_de_verdad_ahora_si_deveritas;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

/**
 * Fábrica para crear instancias de {@link MaterialEnemigo} a partir de un {@link ResultSet}
 * o desde cero.
 *
 * <p>Implementa la interfaz {@code RegistroFactory<MaterialEnemigo>} para permitir la
 * integración con paneles CRUD genéricos en la interfaz gráfica.
 */
@Component
public class MaterialEnemigoFactory implements RegistroFactory<MaterialEnemigo> {

    /**
     * Crea una instancia de {@code MaterialEnemigo} a partir de un {@code ResultSet}.
     *
     * <p>Este método extrae los campos {@code id}, {@code nombre}, {@code enemigo_id} y
     * {@code enemigo} desde los resultados de una consulta SQL.
     *
     * @param rs el {@code ResultSet} con los datos del material
     * @return una nueva instancia de {@code MaterialEnemigo}
     * @throws SQLException si ocurre un error al leer los datos del {@code ResultSet}
     */
    @Override
    public MaterialEnemigo fromResultSet(ResultSet rs) throws SQLException {
        return new MaterialEnemigo(
            rs.getInt("id"),
            rs.getString("nombre"),
            rs.getInt("enemigo_id"),
            rs.getString("enemigo")
        );
    }

    /**
     * Crea una instancia vacía de {@code MaterialEnemigo}, con valores por defecto.
     *
     * @return un {@code MaterialEnemigo} con id 0, nombre y enemigo vacíos, y enemigo_id 0
     */
    @Override
    public MaterialEnemigo createEmpty() {
        return new MaterialEnemigo(0, "", 0, "");
    }
}
