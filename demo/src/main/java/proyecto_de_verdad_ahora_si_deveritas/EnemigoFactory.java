package proyecto_de_verdad_ahora_si_deveritas;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * La clase {@code EnemigoFactory} se encarga de crear instancias de la clase {@code Enemigo},
 * ya sea a partir de un conjunto de resultados ({@code ResultSet}) obtenido desde una base de datos
 * o generando un objeto vacío con valores por defecto.
 * 
 * <p>Implementa la interfaz genérica {@code RegistroFactory<Enemigo>}, lo que permite integrarla
 * fácilmente en sistemas que trabajan con registros dinámicos o persistencia de datos.</p>
 * 
 * <p>Esta clase espera que el {@code ResultSet} contenga al menos las columnas "id" y "nombre"
 * para construir correctamente un objeto {@code Enemigo}.</p>
 * 
 * @author TuNombre
 * @version 1.0
 */
class EnemigoFactory implements RegistroFactory<Enemigo> {

    /**
     * Crea una instancia de {@code Enemigo} a partir de un {@code ResultSet}.
     *
     * <p>Los valores son extraídos de las columnas "id" y "nombre".</p>
     * 
     * @param rs El {@code ResultSet} con los datos necesarios
     * @return Una nueva instancia de {@code Enemigo}
     * @throws SQLException Si ocurre un error al acceder a los datos del {@code ResultSet}
     */
    public Enemigo fromResultSet(ResultSet rs) throws SQLException {
        return new Enemigo(
            rs.getInt("id"),
            rs.getString("nombre")
        );
    }

    /**
     * Crea una instancia vacía de {@code Enemigo} con valores por defecto.
     *
     * @return Una nueva instancia de {@code Enemigo} con id 0 y nombre vacío
     */
    public Enemigo createEmpty() {
        return new Enemigo(0, "");
    }
}

    