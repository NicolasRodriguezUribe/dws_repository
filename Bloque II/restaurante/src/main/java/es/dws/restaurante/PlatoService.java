package es.dws.restaurante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class PlatoService {
    @Autowired
    PlatoRepository platoRepository;

    @Autowired
    RestauranteRepository restauranteRepository;

    @PostConstruct
    public void init()
    {
        Plato plato0 = new Plato("Pollo asado", 20);
        Plato plato1 = new Plato("Pollo limón", 5);

        platoRepository.save(plato0);
        platoRepository.save(plato1);

        Restaurante restaurante = new Restaurante("Real", "Vallekas", "mediterraneo");

        restaurante.getPlatoList().add(plato0);
        restaurante.getPlatoList().add(plato1);

        restauranteRepository.save(restaurante);

    }

}
