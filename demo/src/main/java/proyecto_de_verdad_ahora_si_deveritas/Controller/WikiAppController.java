package proyecto_de_verdad_ahora_si_deveritas.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador principal de la aplicación Wiki HSR.
 * Maneja las rutas principales de la aplicación web y las páginas de personajes.
 * 
 * @author [Tu nombre]
 * @version 1.0
 * @since 2025-07-09
 */
@Controller
public class WikiAppController {

    /**
     * Maneja la solicitud GET para la página de inicio.
     * 
     * @return el nombre de la vista "home" que se resuelve a home.html
     */
    @GetMapping("/")
    public String home() {
        return "home"; 
    }
    
    /**
     * Maneja la solicitud GET para la página de personajes.
     * 
     * @return el nombre de la vista "Personajes/Buscador" que se resuelve a templates/Personajes/Buscador.html
     */
    @GetMapping("/personajes")
    public String personajes() {
        return "Personajes/Buscador";
    }

    /**
     * Maneja la solicitud GET para la página de login.
     * 
     * @return el nombre de la vista "login" que se resuelve a login.html
     */
    @GetMapping("/login")
    public String login() {
        return "login"; // busca login.html en /templates
    }

    /**
     * Maneja la solicitud GET para la página de registro.
     * 
     * @return el nombre de la vista "register" que se resuelve a register.html
     */
    @GetMapping("/register")
    public String register() {
        return "register"; // busca registro.html en /templates
    }

    /**
     * Maneja la solicitud GET para la página de administración.
     * 
     * @return el nombre de la vista "admin" que se resuelve a admin.html
     */
    @GetMapping("/admin")
    public String admin() {
        return "admin"; // busca admin.html en /templates
    }

    /**
     * Maneja la solicitud GET para la página de equipamiento.
     * 
     * @return el nombre de la vista "equipamiento" que se resuelve a equipamiento.html
     */
    @GetMapping("/equipamiento")
    public String equipamiento() {
        return "equipamiento";
    }

    /**
     * Maneja la solicitud GET para la página de materiales de enemigo.
     * 
     * @return el nombre de la vista "material-enemigo" que se resuelve a material-enemigo.html
     */
    @GetMapping("/material-enemigo")
    public String materialEnemigo() {
        return "material-enemigo";
    }

    /**
     * Maneja la solicitud GET para la página de enemigos.
     * 
     * @return el nombre de la vista "enemigo" que se resuelve a enemigo.html
     */
    @GetMapping("/enemigo")
    public String enemigo() {
        return "enemigo";
    }

    /**
     * Maneja la solicitud GET para la página de conos.
     * 
     * @return el nombre de la vista "cono" que se resuelve a cono.html
     */
    @GetMapping("/cono")
    public String cono() {
        return "cono";
    }

    /**
     * Maneja la solicitud GET para la página de vías.
     * 
     * @return el nombre de la vista "via" que se resuelve a via.html
     */
    @GetMapping("/via")
    public String via() {
        return "via";
    }

    /**
     * Maneja la solicitud GET para la página del personaje Arlan.
     * 
     * @return el nombre de la vista "Personajes/arlan" que se resuelve a templates/Personajes/arlan.html
     */
    @GetMapping("/Personajes/arlan")
    public String arlan() {
        return "Personajes/arlan";
    }

    /**
     * Maneja la solicitud GET para la página del personaje Asta.
     * 
     * @return el nombre de la vista "Personajes/asta" que se resuelve a templates/Personajes/asta.html
     */
    @GetMapping("/Personajes/asta")
    public String asta() {
    return "Personajes/asta";
    }

    /**
     * Maneja la solicitud GET para la página del personaje Bailu.
     * 
     * @return el nombre de la vista "Personajes/bailu" que se resuelve a templates/Personajes/bailu.html
     */
    @GetMapping("/Personajes/bailu")
    public String bailu() {
    return "Personajes/bailu";
    }

    /**
     * Maneja la solicitud GET para la página del personaje Bronya.
     * 
     * @return el nombre de la vista "Personajes/bronya" que se resuelve a templates/Personajes/bronya.html
     */
    @GetMapping("/Personajes/bronya")
    public String bronya() {
    return "Personajes/bronya";
    }

    /**
     * Maneja la solicitud GET para la página del personaje Clara.
     * 
     * @return el nombre de la vista "Personajes/clara" que se resuelve a templates/Personajes/clara.html
     */
    @GetMapping("/Personajes/clara")
    public String clara() {
    return "Personajes/clara";
    }

    /**
     * Maneja la solicitud GET para la página del personaje Dan Heng.
     * 
     * @return el nombre de la vista "Personajes/dangHeng" que se resuelve a templates/Personajes/dangHeng.html
     */
    @GetMapping("/Personajes/dangHeng")
    public String dangHeng() {
    return "Personajes/dangHeng";
    }

    /**
     * Maneja la solicitud GET para la página del personaje Gepard.
     * 
     * @return el nombre de la vista "Personajes/gepard" que se resuelve a templates/Personajes/gepard.html
     */
    @GetMapping("/Personajes/gepard")
    public String gepard() {
    return "Personajes/gepard";
    }

    /**
     * Maneja la solicitud GET para la página del personaje Herta.
     * 
     * @return el nombre de la vista "Personajes/Herta" que se resuelve a templates/Personajes/Herta.html
     */
    @GetMapping("/Personajes/Herta")
    public String herta() {
    return "Personajes/Herta";
    }

    /**
     * Maneja la solicitud GET para la página del personaje Himeko.
     * 
     * @return el nombre de la vista "Personajes/himeko" que se resuelve a templates/Personajes/himeko.html
     */
    @GetMapping("/Personajes/himeko")
    public String himeko() {
    return "Personajes/himeko";
    }

    /**
     * Maneja la solicitud GET para la página del personaje Hook.
     * 
     * @return el nombre de la vista "Personajes/hook" que se resuelve a templates/Personajes/hook.html
     */
    @GetMapping("/Personajes/hook")
    public String hook() {
    return "Personajes/hook";
    }

    /**
     * Maneja la solicitud GET para la página del personaje Jin Yuan.
     * 
     * @return el nombre de la vista "Personajes/jinYuan" que se resuelve a templates/Personajes/jinYuan.html
     */
    @GetMapping("/Personajes/jinYuan")
    public String jinYuan() {
    return "Personajes/jinYuan";
    }

    /**
     * Maneja la solicitud GET para la página del personaje Kafka.
     * 
     * @return el nombre de la vista "Personajes/kafka" que se resuelve a templates/Personajes/kafka.html
     */
    @GetMapping("/Personajes/kafka")
    public String kafka() {
    return "Personajes/kafka";
    }

    /**
     * Maneja la solicitud GET para la página del personaje Luocha.
     * 
     * @return el nombre de la vista "Personajes/luocha" que se resuelve a templates/Personajes/luocha.html
     */
    @GetMapping("/Personajes/luocha")
    public String luocha() {
    return "Personajes/luocha";
    }

    /**
     * Maneja la solicitud GET para la página del personaje Natasha.
     * 
     * @return el nombre de la vista "Personajes/natasha" que se resuelve a templates/Personajes/natasha.html
     */
    @GetMapping("/Personajes/natasha")
    public String natasha() {
    return "Personajes/natasha";
    }

    /**
     * Maneja la solicitud GET para la página del personaje Pela.
     * 
     * @return el nombre de la vista "Personajes/pela" que se resuelve a templates/Personajes/pela.html
     */
    @GetMapping("/Personajes/pela")
    public String pela() {
    return "Personajes/pela";
    }

    /**
     * Maneja la solicitud GET para la página del personaje Qinque.
     * 
     * @return el nombre de la vista "Personajes/qinque" que se resuelve a templates/Personajes/qinque.html
     */
    @GetMapping("/Personajes/qinque")
    public String qinque() {
    return "Personajes/qinque";
    }

    /**
     * Maneja la solicitud GET para la página del personaje Sampo.
     * 
     * @return el nombre de la vista "Personajes/sampo" que se resuelve a templates/Personajes/sampo.html
     */
    @GetMapping("/Personajes/sampo")
    public String sampo() {
    return "Personajes/sampo";
    }

    /**
     * Maneja la solicitud GET para la página del personaje Seele.
     * 
     * @return el nombre de la vista "Personajes/seele" que se resuelve a templates/Personajes/seele.html
     */
    @GetMapping("/Personajes/seele")
    public String seele() {
    return "Personajes/seele";
    }

    /**
     * Maneja la solicitud GET para la página del personaje Serval.
     * 
     * @return el nombre de la vista "Personajes/serval" que se resuelve a templates/Personajes/serval.html
     */
    @GetMapping("/Personajes/serval")
    public String serval() {
    return "Personajes/serval";
    }

    /**
     * Maneja la solicitud GET para la página del personaje 7 de Marzo.
     * 
     * @return el nombre de la vista "Personajes/7deMarzo" que se resuelve a templates/Personajes/7deMarzo.html
     */
    @GetMapping("/Personajes/sieteDeMarzo")
    public String sieteDeMarzo() {
    return "Personajes/7deMarzo";
    }

    /**
     * Maneja la solicitud GET para la página del personaje Silver Wolf.
     * 
     * @return el nombre de la vista "Personajes/silverWolf" que se resuelve a templates/Personajes/silverWolf.html
     */
    @GetMapping("/Personajes/silverWolf")
    public String silverWolf() {
    return "Personajes/silverWolf";
    }

    /**
     * Maneja la solicitud GET para la página del personaje Sushang.
     * 
     * @return el nombre de la vista "Personajes/sushang" que se resuelve a templates/Personajes/sushang.html
     */
    @GetMapping("/Personajes/sushang")
    public String sushang() {
    return "Personajes/sushang";
    }

    /**
     * Maneja la solicitud GET para la página del personaje Tingyun.
     * 
     * @return el nombre de la vista "Personajes/tingyun" que se resuelve a templates/Personajes/tingyun.html
     */
    @GetMapping("/Personajes/tingyun")
    public String tingyun() {
    return "Personajes/tingyun";
    }

    /**
     * Maneja la solicitud GET para la página del personaje Trazacaminos.
     * 
     * @return el nombre de la vista "Personajes/trazacaminos" que se resuelve a templates/Personajes/trazacaminos.html
     */
    @GetMapping("/Personajes/trazacaminos")
    public String trazacaminos() {
    return "Personajes/trazacaminos";
    }

    /**
     * Maneja la solicitud GET para la página del personaje Welt.
     * 
     * @return el nombre de la vista "Personajes/welt" que se resuelve a templates/Personajes/welt.html
     */
    @GetMapping("/Personajes/welt")
    public String welt() {
    return "Personajes/welt";
    }

    /**
     * Maneja la solicitud GET para la página del personaje Yanqing.
     * 
     * @return el nombre de la vista "Personajes/yanqing" que se resuelve a templates/Personajes/yanqing.html
     */
    @GetMapping("/Personajes/yanqing")
    public String yanqing() {
    return "Personajes/yanqing";
    }
    
}
