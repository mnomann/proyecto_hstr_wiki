package proyecto_de_verdad_ahora_si_deveritas.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class vistaController {

    @GetMapping("/buscador")
    public String buscador() {
        return "buscador"; // busca buscador.html en /templates
    }

    @GetMapping("/personaje")
    public String personaje() {
        return "personaje"; // busca personaje.html en /templates
    }
}
