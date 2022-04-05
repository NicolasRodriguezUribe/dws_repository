package es.dws.restaurante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")

@RestController
public class RestauranteRESTController {

    @Autowired
    RestauranteService restauranteService;

    @GetMapping("/")
    public ResponseEntity<List<Restaurante>> getRestaurantes()
    {
        return new ResponseEntity<>(restauranteService.restauranteRepository.findAll(), HttpStatus.OK);
    }
}
