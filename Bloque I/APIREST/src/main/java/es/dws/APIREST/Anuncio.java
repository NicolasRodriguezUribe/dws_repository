package es.dws.APIREST;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Anuncio {
    private long id;
    private String nombre;
    private String asunto;
    private String comentario;
}
