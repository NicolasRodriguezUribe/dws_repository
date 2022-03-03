package es.dws.example1;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Anuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private String asunto;
    private String comentario;

    public Anuncio(String nombre, String asunto, String comentario) {
        this.nombre = nombre;
        this.asunto = asunto;
        this.comentario = comentario;
    }
}