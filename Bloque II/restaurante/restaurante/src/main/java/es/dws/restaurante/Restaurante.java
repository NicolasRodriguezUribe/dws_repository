package es.dws.restaurante;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long cod_rest;
    String nombre;
    String dirección;
    String tipo;

    @OneToMany
    List<Plato> platoList = new ArrayList<>();

    public Restaurante(String nombre, String dirección, String tipo){
        this.nombre = nombre;
        this.dirección = dirección;
        this.tipo = tipo;
    }
}
