package smartclick.cloud.system.propertyhuntercr.controller;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import smartclick.cloud.system.base.AbstractBaseController;
import smartclick.cloud.system.propertyhuntercr.entity.Property;
import smartclick.cloud.system.propertyhuntercr.entity.PublicProperty;
import smartclick.cloud.system.propertyhuntercr.service.PropertyPublicService;

@RestController
@RequestMapping("/public/property")
public class PropertyPublicController extends AbstractBaseController<Property, String, PropertyPublicService>{
	private static final String UNAUTHORIZED = "Unauthorized.";
	private static final String BAD_REQUEST_MESSAGE = "Not valid arguments.";
	private static final String NOT_FOUND_MESSAGE = "Data not found.";
	private static final String INTERNAL_SERVER_ERROR_MESSAGE = "Internal error.";
	
	public PropertyPublicController(PropertyPublicService service) {
		super(service);
	}
	
	public ResponseEntity<Page<Property>> getAll(Pageable pageable) {
		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, UNAUTHORIZED);
	}
	
	@GetMapping("/custom")
	public ResponseEntity<Page<PublicProperty>> getAllCustom(@RequestParam(required = false) String title, @RequestParam(required = false) String propertyType, @RequestParam(required = false) String provinceCode,  Pageable pageable) {
		try {
			return new ResponseEntity<>(service.getAllCustom(pageable), HttpStatus.OK);
		}
		catch(IllegalArgumentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, BAD_REQUEST_MESSAGE);
		}
		catch(NoSuchElementException ne) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR_MESSAGE);
		}
	}
	
	@GetMapping("/search")
	public ResponseEntity<Page<PublicProperty>> search(@RequestParam(required = false) String searchType, @RequestParam(required = false) String propertyType, @RequestParam(required = false) String provinceCode, Pageable pageable) {
		try {			
			return new ResponseEntity<>(service.search(searchType, propertyType, provinceCode, pageable), HttpStatus.OK);
		}
		catch(IllegalArgumentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, BAD_REQUEST_MESSAGE);
		}
		catch(NoSuchElementException ne) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR_MESSAGE);
		}
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<PublicProperty> searchById(@PathVariable String id) {
		try {			
			return new ResponseEntity<PublicProperty>(service.searchById(id), HttpStatus.OK);
		}
		catch(IllegalArgumentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, BAD_REQUEST_MESSAGE);
		}
		catch(NoSuchElementException ne) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR_MESSAGE);
		}
	}
	
	@PostMapping()
	public ResponseEntity<Property> create(@Valid @RequestBody Property entity) {
		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, UNAUTHORIZED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Property> update(@PathVariable String id, @Valid @RequestBody Property entity) {
		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, UNAUTHORIZED);
	}
	
	@DeleteMapping()
	public ResponseEntity<Boolean> delete(@RequestBody String id) {
		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, UNAUTHORIZED);
	}
}