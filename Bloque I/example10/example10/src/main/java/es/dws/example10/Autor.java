package es.dws.example10;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Autor {

	interface Basico {}

	interface Libros {}

	@JsonView(Basico.class)
	private long id = -1;

	@JsonView(Basico.class)
	private String nombre;

	@JsonView(Basico.class)
	private String nacionalidad;

	@JsonView(Libros.class)
	private List<Libro> libros = new ArrayList<>();

	public Autor(long id, String nombre, String nacionalidad) {
		this.id = id;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", libros=" + libros + "]";
	}
}
