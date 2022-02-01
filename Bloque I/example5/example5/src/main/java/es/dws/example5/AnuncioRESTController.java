package es.dws.example5;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnuncioRESTController {
    @GetMapping("/anuncio")
    public Anuncio anuncios() {
        return new Anuncio("Pepe", "Vendo moto", "...");
    }
}
