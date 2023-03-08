package es.dws.AnuncioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/")
@RestController
public class AnuncioRESTController {
    @Autowired
    AnuncioService anuncioService;

    @GetMapping("/anuncios/")
    public ResponseEntity getAll()
    {
        return new ResponseEntity<>(anuncioService.getAll(), HttpStatus.OK);
    }

    //@GetMapping("/anuncios/{id2}")
    //public ResponseEntity<Anuncio> getElementByID(@PathVariable Long id2){
      //  if (anuncioHashMap.containsKey(id2))
        //    return new ResponseEntity<>(anuncioHashMap.get(id2), HttpStatus.OK);
       // else
         //   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //}

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/anuncios/")
    public Anuncio createAnuncio(@RequestBody Anuncio anuncio){
        anuncioService.createAnuncio(anuncio);
        return anuncio;
    }

    //@DeleteMapping("/anuncios/{id2}")
    //public ResponseEntity<Anuncio> removeElementByID(@PathVariable Long id2){
      //  Anuncio tem = anuncioHashMap.remove(id2);
        //return new ResponseEntity<>(tem, HttpStatus.OK);
    //}

    //@PutMapping("/anuncios/{id2}")
    //public ResponseEntity<Anuncio> updateElementByID(@RequestBody Anuncio anuncio, @PathVariable Long id2){
      //  Anuncio tempAnuncio = anuncioHashMap.get(id2);
        //if (tempAnuncio != null)
        //{
          //  anuncioHashMap.put(id2, anuncio);
            //return new ResponseEntity<>(anuncio, HttpStatus.OK);
        //}
        //else
          //  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //}
}
