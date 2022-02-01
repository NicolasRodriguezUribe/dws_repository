package es.dws.example5;

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