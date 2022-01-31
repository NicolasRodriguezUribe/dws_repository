package es.dws.exercise4b;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Anuncio {
    private String nombre;
    private String asunto;
    private String comentario;
}