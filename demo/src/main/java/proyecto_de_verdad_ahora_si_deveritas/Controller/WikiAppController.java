package proyecto_de_verdad_ahora_si_deveritas.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WikiAppController {

    @GetMapping("/")
    public String home() {
        return "home"; 
    }
}
