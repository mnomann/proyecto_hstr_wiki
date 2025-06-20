package proyecto_de_verdad_ahora_si_deveritas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;

/**
 * Fábrica genérica para crear instancias de {@link Registro} usando funciones personalizadas.
 */
public class GenericFactory<T extends Registro> implements RegistroFactory<T> {

    private final Function<ResultSet, T> resultSetMapper;
    private final T emptyInstance;

    public GenericFactory(Function<ResultSet, T> resultSetMapper, T emptyInstance) {
        this.resultSetMapper = resultSetMapper;
        this.emptyInstance = emptyInstance;
    }

    @Override
    public T fromResultSet(ResultSet rs) throws SQLException {
        return resultSetMapper.apply(rs);
    }

    @Override
    public T createEmpty() {
        return emptyInstance;
    }
}
