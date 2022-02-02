package es.dws.example10;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro {

	interface Basico {}

	interface Autores {}

	@JsonView(Basico.class)
	private long id = -1;

	@JsonView(Basico.class)
	private String titulo;

	@JsonView(Basico.class)
	private int precio;

	@JsonView(Autores.class)
	private List<Autor> autores = new ArrayList<>();

	public Libro(int id, String titulo, int precio) {
		this.id = id;
		this.titulo = titulo;
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", precio=" + precio + ", autores=" + autores + "]";
	}

}
