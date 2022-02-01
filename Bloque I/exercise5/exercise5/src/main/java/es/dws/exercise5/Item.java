package es.dws.exercise5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
	private long id = -1;
	private String description;
	private boolean checked;

	@Override
	public String toString() {
		return "Item [id=" + id + ", description=" + description + ", checked=" + checked + "]";
	}
}
