package es.dws.restaurante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestauranteService {
    @Autowired
    RestauranteRepository restauranteRepository;
}
