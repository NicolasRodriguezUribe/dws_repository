package es.dws.example9;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro {

	private long id = -1;
	private String titulo;
	private int precio;
	@JsonIgnore
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
