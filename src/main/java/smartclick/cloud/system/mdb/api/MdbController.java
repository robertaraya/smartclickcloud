package smartclick.cloud.system.mdb.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MdbController {
	
	@Autowired
	MdbService mdbService;
	
	@GetMapping(value = {"/search/{query}", "/search/{query}/{languaje}"})
	public ResponseEntity<List<Movies>> searchMovie(@PathVariable String query, @PathVariable Optional<String> languaje) {
		return mdbService.searchMovie(query, languaje.isPresent() ? languaje.get() : "es");
	}

	@GetMapping(value = {"/search/tv/{query}", "/search/tv/{query}/{languaje}"})
	public ResponseEntity<List<Movies>> searchTvShow(@PathVariable String query, @PathVariable Optional<String> languaje) {
		return mdbService.searchTvShow(query, languaje.isPresent() ? languaje.get() : "es");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Movie> getMovie(@PathVariable Integer id) {
		return mdbService.getMovie(id.toString());
	}
	
	@GetMapping("/tv/{id}")
	public ResponseEntity<Movie> getTvShow(@PathVariable Integer id) {
		return mdbService.getTvShow(id.toString());
	}

}
