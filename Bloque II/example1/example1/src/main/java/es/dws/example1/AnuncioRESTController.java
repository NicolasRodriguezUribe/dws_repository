package es.dws.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RequestMapping("/api")
@RestController
public class AnuncioRESTController {
    @Autowired
    AnuncioRepository anuncioRepository;

    @PostMapping("/anuncio")
    public ResponseEntity<Anuncio> crearAnuncio(@RequestBody Anuncio anuncio){
        anuncioRepository.save(anuncio);
        return new ResponseEntity(anuncio, HttpStatus.CREATED);
    }

    @GetMapping("/anuncios")
    public Collection<Anuncio> getAllAnuncios()
    {

        return anuncioRepository.findAll();
    }
}
