package smartclick.cloud.system.util.document;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/file")
public class FileController {
	private static final String BAD_REQUEST_MESSAGE = "Not valid arguments.";
	private static final String NOT_FOUND_MESSAGE = "Data not found.";
	
	@Autowired
	FileService fileService;
	
	@GetMapping("/{id}")
	public String getFile(@PathVariable String id) {
	    File file = fileService.getFile(id);
	    return file.getBase64Image();
	}
	
	@DeleteMapping()
	public ResponseEntity<Boolean> delete(@RequestBody String id) {
		try {
			return new ResponseEntity<>(fileService.delete(id), HttpStatus.OK);
		}
		catch(IllegalArgumentException ae) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, BAD_REQUEST_MESSAGE);
		}
		catch(NoSuchElementException ne) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE);
		}
	}
}
