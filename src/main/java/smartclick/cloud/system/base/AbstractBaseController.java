package smartclick.cloud.system.base;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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
import org.springframework.web.server.ResponseStatusException;

public abstract class AbstractBaseController<T extends AbstractBaseEntity<ID>, ID, S extends AbstractBaseService<T, ID, ?>> { 
	//extends RestExceptionHandler {
	private static final String BAD_REQUEST_MESSAGE = "Not valid arguments.";
	private static final String NOT_FOUND_MESSAGE = "Data not found.";
	private static final String CONFLICT_MESSAGE = "Duplicate key.";
	private static final String INTERNAL_SERVER_ERROR_MESSAGE = "Internal error.";

	protected S service;
	
	@Autowired
	public AbstractBaseController(S service) {
		this.service = service;
	}
	
	@GetMapping()
	public ResponseEntity<Page<T>> getAll(Pageable pageable) {
		try {
			return new ResponseEntity<>(service.getAll(pageable), HttpStatus.OK);
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
	
	@GetMapping("/{id}")
	public ResponseEntity<T> findById(@PathVariable ID id) {
		try {			
			return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
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
	public ResponseEntity<T> create(@Valid @RequestBody T entity) {
		try {
			return new ResponseEntity<>(service.create(entity), HttpStatus.OK);
		}
		catch(IllegalArgumentException ae) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, BAD_REQUEST_MESSAGE);
		}
		catch(DuplicateKeyException de) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, CONFLICT_MESSAGE);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<T> update(@PathVariable ID id, @Valid @RequestBody T entity) {
		try {
			return new ResponseEntity<>(service.update(id, entity), HttpStatus.OK);
		}
		catch(IllegalArgumentException ae) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, BAD_REQUEST_MESSAGE);
		}
		catch(DuplicateKeyException de) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, CONFLICT_MESSAGE);
		}
		catch(NoSuchElementException ne) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE);
		}
	}
	
	@DeleteMapping()
	public ResponseEntity<Boolean> delete(@RequestBody ID id) {
		try {
			return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
		}
		catch(IllegalArgumentException ae) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, BAD_REQUEST_MESSAGE);
		}
		catch(NoSuchElementException ne) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE);
		}
	}

}
