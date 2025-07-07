package proyecto_de_verdad_ahora_si_deveritas.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WikiAppController {

    @GetMapping("/")
    public String home() {
        return "home"; 
    }
    
    @GetMapping("/personajes")
    public String personajes() {
        return "Personajes/Buscador";
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // busca login.html en /templates
    }

    @GetMapping("/register")
    public String register() {
        return "register"; // busca registro.html en /templates
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin"; // busca admin.html en /templates
    }

    @GetMapping("/equipamiento")
    public String equipamiento() {
        return "equipamiento";
    }

    @GetMapping("/material-enemigo")
    public String materialEnemigo() {
        return "material-enemigo";
    }

    @GetMapping("/enemigo")
    public String enemigo() {
        return "enemigo";
    }

    @GetMapping("/cono")
    public String cono() {
        return "cono";
    }

    @GetMapping("/via")
    public String via() {
        return "via";
    }
}
