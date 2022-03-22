package es.dws.restaurante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class RestauranteRESTController {
    @Autowired
    RestauranteService restauranteService;

    @PostConstruct
    public void init(){
        Restaurante r1 = new Restaurante("Nombre", "Dir", "Tipo");
        restauranteService.restauranteRepository.save(r1);
    }
}
