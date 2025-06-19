package proyecto_de_verdad_ahora_si_deveritas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class FactoryConfig {

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

    @Bean
    public RegistroFactory<Personaje> personajeFactory() {
        return new GenericFactory<>(
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
