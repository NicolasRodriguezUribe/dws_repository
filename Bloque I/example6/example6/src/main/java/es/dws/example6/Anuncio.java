package es.dws.example6;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Anuncio {
    private long id = -1;
    private String nombre;
    private String asunto;
    private String comentario;
}