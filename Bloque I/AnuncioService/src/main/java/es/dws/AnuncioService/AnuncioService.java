package es.dws.AnuncioService;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AnuncioService {

    private Map<Long, Anuncio> anuncioHashMap = new ConcurrentHashMap<>();
    private AtomicLong id = new AtomicLong();

    public Collection<Anuncio> getAll()
    {
        return anuncioHashMap.values();
    }
    public Anuncio createAnuncio(Anuncio anuncio){
        long tem = id.incrementAndGet();
        anuncio.setId(tem);
        anuncioHashMap.put(tem, anuncio);
        return anuncio;
    }

}
