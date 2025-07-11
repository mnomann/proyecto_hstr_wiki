package proyecto_de_verdad_ahora_si_deveritas.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Pruebas unitarias para la clase WikiAppController.
 * Verifica que todas las rutas devuelvan las vistas correctas y respondan con el status HTTP adecuado.
 * 
 * @version 1.0
 * @since 2025-07-09
 */
@WebMvcTest(WikiAppController.class)
class WikiAppControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final WikiAppController controller = new WikiAppController();

    /**
     * Pruebas para las rutas principales de la aplicación
     */
    @Test
    @DisplayName("Debe devolver la vista home cuando se accede a la ruta raíz")
    void testHome() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"));
    }

    @Test
    @DisplayName("Debe devolver la vista Personajes/Buscador cuando se accede a /personajes")
    void testPersonajes() throws Exception {
        mockMvc.perform(get("/personajes"))
                .andExpect(status().isOk())
                .andExpect(view().name("Personajes/Buscador"));
    }

    @Test
    @DisplayName("Debe devolver la vista login cuando se accede a /login")
    void testLogin() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    @DisplayName("Debe devolver la vista register cuando se accede a /register")
    void testRegister() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"));
    }

    @Test
    @DisplayName("Debe devolver la vista admin cuando se accede a /admin")
    void testAdmin() throws Exception {
        mockMvc.perform(get("/admin"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin"));
    }

    @Test
    @DisplayName("Debe devolver la vista equipamiento cuando se accede a /equipamiento")
    void testEquipamiento() throws Exception {
        mockMvc.perform(get("/equipamiento"))
                .andExpect(status().isOk())
                .andExpect(view().name("equipamiento"));
    }

    @Test
    @DisplayName("Debe devolver la vista material-enemigo cuando se accede a /material-enemigo")
    void testMaterialEnemigo() throws Exception {
        mockMvc.perform(get("/material-enemigo"))
                .andExpect(status().isOk())
                .andExpect(view().name("material-enemigo"));
    }

    @Test
    @DisplayName("Debe devolver la vista enemigo cuando se accede a /enemigo")
    void testEnemigo() throws Exception {
        mockMvc.perform(get("/enemigo"))
                .andExpect(status().isOk())
                .andExpect(view().name("enemigo"));
    }

    @Test
    @DisplayName("Debe devolver la vista cono cuando se accede a /cono")
    void testCono() throws Exception {
        mockMvc.perform(get("/cono"))
                .andExpect(status().isOk())
                .andExpect(view().name("cono"));
    }

    @Test
    @DisplayName("Debe devolver la vista via cuando se accede a /via")
    void testVia() throws Exception {
        mockMvc.perform(get("/via"))
                .andExpect(status().isOk())
                .andExpect(view().name("via"));
    }

    /**
     * Pruebas unitarias directas de los métodos sin MockMvc
     */
    @Test
    @DisplayName("Método home() debe devolver 'home'")
    void testHomeMethod() {
        String result = controller.home();
        assertEquals("home", result);
    }

    @Test
    @DisplayName("Método personajes() debe devolver 'Personajes/Buscador'")
    void testPersonajesMethod() {
        String result = controller.personajes();
        assertEquals("Personajes/Buscador", result);
    }

    @Test
    @DisplayName("Método login() debe devolver 'login'")
    void testLoginMethod() {
        String result = controller.login();
        assertEquals("login", result);
    }

    @Test
    @DisplayName("Método register() debe devolver 'register'")
    void testRegisterMethod() {
        String result = controller.register();
        assertEquals("register", result);
    }

    @Test
    @DisplayName("Método admin() debe devolver 'admin'")
    void testAdminMethod() {
        String result = controller.admin();
        assertEquals("admin", result);
    }

    @Test
    @DisplayName("Método equipamiento() debe devolver 'equipamiento'")
    void testEquipamientoMethod() {
        String result = controller.equipamiento();
        assertEquals("equipamiento", result);
    }

    @Test
    @DisplayName("Método materialEnemigo() debe devolver 'material-enemigo'")
    void testMaterialEnemigoMethod() {
        String result = controller.materialEnemigo();
        assertEquals("material-enemigo", result);
    }

    @Test
    @DisplayName("Método enemigo() debe devolver 'enemigo'")
    void testEnemigoMethod() {
        String result = controller.enemigo();
        assertEquals("enemigo", result);
    }

    @Test
    @DisplayName("Método cono() debe devolver 'cono'")
    void testConoMethod() {
        String result = controller.cono();
        assertEquals("cono", result);
    }

    @Test
    @DisplayName("Método via() debe devolver 'via'")
    void testViaMethod() {
        String result = controller.via();
        assertEquals("via", result);
    }

    /**
     * Pruebas parametrizadas para todos los personajes
     */
    @Test
    @DisplayName("Todos los métodos de personajes deben devolver la vista correcta")
    void testAllPersonajesMethodsReturnCorrectView() {
        // Pruebas para algunos personajes principales
        assertEquals("Personajes/arlan", controller.arlan());
        assertEquals("Personajes/asta", controller.asta());
        assertEquals("Personajes/bailu", controller.bailu());
        assertEquals("Personajes/bronya", controller.bronya());
        assertEquals("Personajes/clara", controller.clara());
        assertEquals("Personajes/dangHeng", controller.dangHeng());
        assertEquals("Personajes/gepard", controller.gepard());
        assertEquals("Personajes/Herta", controller.herta());
        assertEquals("Personajes/himeko", controller.himeko());
        assertEquals("Personajes/hook", controller.hook());
        assertEquals("Personajes/jinYuan", controller.jinYuan());
        assertEquals("Personajes/kafka", controller.kafka());
        assertEquals("Personajes/luocha", controller.luocha());
        assertEquals("Personajes/natasha", controller.natasha());
        assertEquals("Personajes/pela", controller.pela());
        assertEquals("Personajes/qinque", controller.qinque());
        assertEquals("Personajes/sampo", controller.sampo());
        assertEquals("Personajes/seele", controller.seele());
        assertEquals("Personajes/serval", controller.serval());
        assertEquals("Personajes/7deMarzo", controller.sieteDeMarzo());
        assertEquals("Personajes/silverWolf", controller.silverWolf());
        assertEquals("Personajes/sushang", controller.sushang());
        assertEquals("Personajes/tingyun", controller.tingyun());
        assertEquals("Personajes/trazacaminos", controller.trazacaminos());
        assertEquals("Personajes/welt", controller.welt());
        assertEquals("Personajes/yanqing", controller.yanqing());
    }
}
