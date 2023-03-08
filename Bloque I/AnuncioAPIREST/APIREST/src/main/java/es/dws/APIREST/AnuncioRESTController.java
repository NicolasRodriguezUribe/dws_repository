package es.dws.APIREST;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RequestMapping("/api/")
@RestController
public class AnuncioRESTController {

    private Map<Long, Anuncio> anuncioHashMap = new ConcurrentHashMap<>();
    private AtomicLong lastId = new AtomicLong();

    @GetMapping("/anuncios/")
    public ResponseEntity getAll()
    {
        return new ResponseEntity<>(anuncioHashMap.values(), HttpStatus.OK);
    }

    @GetMapping("/anuncios/{id}")
    public ResponseEntity<Anuncio> getElementByID(@PathVariable Long id){
        if (anuncioHashMap.containsKey(id))
            return new ResponseEntity<>(anuncioHashMap.get(id), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/anuncios/")
    public Anuncio createAnuncio(@RequestBody Anuncio anuncio){
        long id = lastId.incrementAndGet();
        anuncio.setId(id);
        anuncioHashMap.put(id, anuncio);
        return anuncio;
    }

    @DeleteMapping("/anuncios/{id}")
    public ResponseEntity<Anuncio> removeElementByID(@PathVariable Long id){
        Anuncio tem = anuncioHashMap.remove(id);
        return new ResponseEntity<>(tem, HttpStatus.OK);
    }

    @PutMapping("/anuncios/{id}")
    public ResponseEntity<Anuncio> updateElementByID(@RequestBody Anuncio anuncio, @PathVariable Long id){
        Anuncio tempAnuncio = anuncioHashMap.get(id);
        if (tempAnuncio != null)
        {
            anuncioHashMap.put(id, anuncio);
            return new ResponseEntity<>(anuncio, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
