package es.dws.exercise5;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/items")
public class ItemRestController {

	private Map<Long, Item> items = new ConcurrentHashMap<>();
	private AtomicLong lastId = new AtomicLong();

	@GetMapping("/")
	public Collection<Item> getItems() {
		return items.values();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Item> getItem(@PathVariable long id) {

		Item item = items.get(id);

		if (item != null) {
			return new ResponseEntity<>(item, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Item createItem(@RequestBody Item item) {

		long id = lastId.incrementAndGet();
		item.setId(id);
		items.put(id, item);

		return item;
	}

	@PutMapping("/{id}")
	public ResponseEntity<Item> updateItem(@PathVariable long id, @RequestBody Item newItem) {

		Item oldItem = items.get(id);

		if (oldItem != null) {

			newItem.setId(id);
			items.put(id, newItem);

			return new ResponseEntity<>(newItem, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Item> deleteItem(@PathVariable long id) {

		Item item = items.remove(id);

		if (item != null) {
			return new ResponseEntity<>(item, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
