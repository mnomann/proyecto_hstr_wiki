package proyecto_de_verdad_ahora_si_deveritas;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

/**
 * Fábrica de objetos {@link Personaje}, utilizada para crear instancias a partir de un
 * {@link ResultSet} o generar personajes vacíos.
 *
 * <p>Implementa la interfaz genérica {@code RegistroFactory<Personaje>} para su integración
 * con componentes de interfaz gráfica y mecanismos CRUD genéricos.
 */
@Component
public class PersonajeFactory implements RegistroFactory<Personaje> {

    /**
     * Crea una instancia de {@code Personaje} a partir de los datos de un {@code ResultSet}.
     *
     * <p>Extrae los campos {@code id}, {@code nombre}, {@code rareza} y {@code nivel} desde el
     * resultado de una consulta SQL.
     *
     * @param rs el {@code ResultSet} con los datos del personaje
     * @return una nueva instancia de {@code Personaje} con los datos proporcionados
     * @throws SQLException si ocurre un error al acceder a los datos del {@code ResultSet}
     */
    @Override
    public Personaje fromResultSet(ResultSet rs) throws SQLException {
        return new Personaje(
            rs.getInt("id"),
            rs.getString("nombre"),
            rs.getInt("rareza"),
            rs.getInt("nivel")
        );
    }

    /**
     * Crea una instancia vacía de {@code Personaje}, con valores por defecto.
     *
     * <p>Este método se utiliza para iniciar formularios de entrada o nuevos registros.
     *
     * @return un {@code Personaje} con ID 0, nombre vacío, rareza 0 y nivel 0
     */
    @Override
    public Personaje createEmpty() {
        return new Personaje(0, "", 0, 0);
    }
}
