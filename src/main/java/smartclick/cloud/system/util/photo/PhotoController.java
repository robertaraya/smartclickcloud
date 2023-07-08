package smartclick.cloud.system.util.photo;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/photo")
public class PhotoController {
	private static final String BAD_REQUEST_MESSAGE = "Not valid arguments.";
	private static final String NOT_FOUND_MESSAGE = "Data not found.";
	
	@Autowired
	PhotoService photoService;
	
	@PostMapping("/add")
	public String addPhoto(@RequestParam("title") String title, 
	  @RequestParam("image") MultipartFile image, Model model) 
	  throws IOException {
	    String id = photoService.addPhoto(title, image);
	    return "redirect:/photos/" + id;
	}
	
	@GetMapping("/{id}")
	public String getPhoto(@PathVariable String id) {
	    Photo photo = photoService.getPhoto(id);
	    return photo.getBase64Image();
	}
	
	@DeleteMapping()
	public ResponseEntity<Boolean> delete(@RequestBody String id) {
		try {
			return new ResponseEntity<>(photoService.delete(id), HttpStatus.OK);
		}
		catch(IllegalArgumentException ae) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, BAD_REQUEST_MESSAGE);
		}
		catch(NoSuchElementException ne) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE);
		}
	}
	
	//model.addAttribute("title", photo.getTitle());
	//model.addAttribute("image", Base64.getEncoder().encodeToString(photo.getImage().getData()));
	//String base64Image = Base64.getEncoder().encodeToString(photo.getImage().getData()).replace("dataimage/jpegbase64/9j/4", "data:image/jpeg;base64,");
	//List<Photo> photos = new ArrayList<>();
	//photos.add(photo);
}
