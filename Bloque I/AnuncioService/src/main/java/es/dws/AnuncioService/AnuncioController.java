package es.dws.AnuncioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnuncioController {

    @Autowired
    AnuncioService anuncioService;

    @GetMapping("/anuncios/")
    public String getAll(Model model){
        model.addAttribute("anuncios", anuncioService.getAll());
        return "anuncios_template";
    }
}
