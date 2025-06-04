package proyecto_de_verdad_ahora_si_deveritas;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Interfaz genérica para la creación de objetos que implementan {@link Registro}.
 *
 * <p>Permite desacoplar la lógica de instanciación desde un {@link ResultSet} y la
 * creación de registros vacíos. Es utilizada principalmente por componentes CRUD genéricos
 * como {@code EntidadPanel}, que necesitan construir entidades sin conocer su tipo exacto.
 *
 * @param <T> el tipo concreto que implementa {@link Registro}
 */
public interface RegistroFactory<T extends Registro> {

    /**
     * Crea una instancia del registro a partir de un resultado de consulta SQL.
     *
     * @param rs el {@code ResultSet} con los datos de una fila
     * @return una instancia del registro con los valores del {@code ResultSet}
     * @throws SQLException si ocurre un error al leer los datos
     */
    T fromResultSet(ResultSet rs) throws SQLException;

    /**
     * Crea una instancia vacía del registro con valores por defecto.
     *
     * @return una nueva instancia vacía del registro
     */
    T createEmpty();
}
