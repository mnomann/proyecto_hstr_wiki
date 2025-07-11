
/**
 * Configuración de fábricas para la creación de entidades del sistema.
 * Proporciona beans de tipo RegistroFactory para cada entidad principal.
 * Utiliza GenericFactory para instanciar objetos a partir de ResultSet.
 * 
 */
package proyecto_de_verdad_ahora_si_deveritas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
/**
 * Clase de configuración de Spring que define beans para las fábricas de entidades.
 */
public class FactoryConfig {

    /**
     * Bean para la fábrica de objetos Cono.
     * @return RegistroFactory para Cono
     */
    @Bean
    public RegistroFactory<Cono> conoFactory() {
        return new GenericFactory<>(
            rs -> {
                try {
                    return new Cono(rs.getInt("id"), rs.getString("nombre"), rs.getInt("rareza"), rs.getInt("nivel"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            },
            new Cono(0, "", 0, 0)
        );
    }

    /**
     * Bean para la fábrica de objetos Enemigo.
     * @return RegistroFactory para Enemigo
     */
    @Bean
    public RegistroFactory<Enemigo> enemigoFactory() {
        return new GenericFactory<>(
            rs -> {
                try {
                    return new Enemigo(rs.getInt("id"), rs.getString("nombre"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            },
            new Enemigo(0, "")
        );
    }

    /**
     * Bean para la fábrica de objetos Equipamiento.
     * @return RegistroFactory para Equipamiento
     */
    @Bean
    public RegistroFactory<Equipamiento> equipamientoFactory() {
        return new GenericFactory<>(
            rs -> {
                try {
                    return new Equipamiento(rs.getInt("id"), rs.getString("nombre"), rs.getInt("rareza"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            },
            new Equipamiento(0, "", 0)
        );
    }

    /**
     * Bean para la fábrica de objetos MaterialEnemigo.
     * @return RegistroFactory para MaterialEnemigo
     */
    @Bean
    public RegistroFactory<MaterialEnemigo> materialEnemigoFactory() {
        return new GenericFactory<>(
            rs -> {
                try {
                    return new MaterialEnemigo(rs.getInt("id"), rs.getString("nombre"), rs.getInt("enemigo_id"), rs.getString("enemigo"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            },
            new MaterialEnemigo(0, "", 0, "")
        );
    }

    /**
     * Bean para la fábrica de objetos Personaje.
     * @return RegistroFactory para Personaje
     */
    @Bean
    public RegistroFactory<Personaje> personajeFactory() {
        return new GenericFactory<Personaje>(
            rs -> {
                try {
                    return new Personaje(rs.getInt("id"), rs.getString("nombre"), rs.getInt("rareza"), rs.getInt("nivel"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            },
            new Personaje(0, "", 0, 0)
        );
    }

    /**
     * Bean para la fábrica de objetos Via.
     * @return RegistroFactory para Via
     */
    @Bean
    public RegistroFactory<Via> viaFactory() {
        return new GenericFactory<>(
            rs -> {
                try {
                    return new Via(rs.getInt("id"), rs.getString("nombre"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            },
            new Via(0, "")
        );
    }
}
