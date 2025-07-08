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

    @GetMapping("/Personajes/arlan")
    public String arlan() {
        return "Personajes/arlan";
    }

    @GetMapping("/Personajes/asta")
public String asta() {
    return "Personajes/asta";
}

@GetMapping("/Personajes/bailu")
public String bailu() {
    return "Personajes/bailu";
}

@GetMapping("/Personajes/bronya")
public String bronya() {
    return "Personajes/bronya";
}

@GetMapping("/Personajes/clara")
public String clara() {
    return "Personajes/clara";
}

@GetMapping("/Personajes/dangHeng")
public String dangHeng() {
    return "Personajes/dangHeng";
}

@GetMapping("/Personajes/gepard")
public String gepard() {
    return "Personajes/gepard";
}

@GetMapping("/Personajes/Herta")
public String herta() {
    return "Personajes/Herta";
}

@GetMapping("/Personajes/himeko")
public String himeko() {
    return "Personajes/himeko";
}

@GetMapping("/Personajes/hook")
public String hook() {
    return "Personajes/hook";
}

@GetMapping("/Personajes/jinYuan")
public String jinYuan() {
    return "Personajes/jinYuan";
}

@GetMapping("/Personajes/kafka")
public String kafka() {
    return "Personajes/kafka";
}

@GetMapping("/Personajes/luocha")
public String luocha() {
    return "Personajes/luocha";
}

@GetMapping("/Personajes/natasha")
public String natasha() {
    return "Personajes/natasha";
}

@GetMapping("/Personajes/pela")
public String pela() {
    return "Personajes/pela";
}

@GetMapping("/Personajes/qinque")
public String qinque() {
    return "Personajes/qinque";
}

@GetMapping("/Personajes/sampo")
public String sampo() {
    return "Personajes/sampo";
}

@GetMapping("/Personajes/seele")
public String seele() {
    return "Personajes/seele";
}

@GetMapping("/Personajes/serval")
public String serval() {
    return "Personajes/serval";
}

@GetMapping("/Personajes/sieteDeMarzo")
public String sieteDeMarzo() {
    return "Personajes/7deMarzo";
}

@GetMapping("/Personajes/silverWolf")
public String silverWolf() {
    return "Personajes/silverWolf";
}

@GetMapping("/Personajes/sushang")
public String sushang() {
    return "Personajes/sushang";
}

@GetMapping("/Personajes/tingyun")
public String tingyun() {
    return "Personajes/tingyun";
}

@GetMapping("/Personajes/trazacaminos")
public String trazacaminos() {
    return "Personajes/trazacaminos";
}

@GetMapping("/Personajes/welt")
public String welt() {
    return "Personajes/welt";
}

@GetMapping("/Personajes/yanqing")
public String yanqing() {
    return "Personajes/yanqing";
}
    
}
