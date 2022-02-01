package es.dws.example6;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class AnuncioRESTController {
    private Map<Long, Anuncio> anuncios = new ConcurrentHashMap<>();
    private AtomicLong lastId = new AtomicLong();

    @GetMapping("/anuncios/{id}")
    public ResponseEntity<Anuncio> getAnuncio(@PathVariable long id) {

        Anuncio anuncio = anuncios.get(id);

        if (anuncio != null) {
            return new ResponseEntity<>(anuncio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/anuncios/")
    public Collection<Anuncio> anuncios() {
        return anuncios.values();
    }

    @PutMapping("/anuncios/{id}")
    public ResponseEntity<Anuncio> actualizaAnuncio(@PathVariable long id, @RequestBody Anuncio anuncioActualizado) {

        Anuncio anuncio = anuncios.get(id);

        if (anuncio != null) {

            anuncioActualizado.setId(id);
            anuncios.put(id, anuncioActualizado);

            return new ResponseEntity<>(anuncioActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/anuncios/{id}")
    public ResponseEntity<Anuncio> borraAnuncio(@PathVariable long id) {

        Anuncio anuncio = anuncios.remove(id);

        if (anuncio != null) {
            return new ResponseEntity<>(anuncio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @PostMapping("/anuncios/")
    @ResponseStatus(HttpStatus.CREATED)
    public Anuncio nuevoAnuncio(@RequestBody Anuncio anuncio) {

        long id = lastId.incrementAndGet();
        anuncio.setId(id);
        anuncios.put(id, anuncio);

        return anuncio;
    }
}
