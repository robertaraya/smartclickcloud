package smartclick.cloud.system.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import smartclick.cloud.security.config.UserAuditing;

public abstract class AbstractBaseService<T extends AbstractBaseEntity<ID>, ID, R extends MongoRepository<T,ID>> {

	protected R repository;
	
	@Autowired
	public AbstractBaseService(R repository) {
		this.repository = repository;
	}
	
	@Autowired
	protected UserAuditing auditing;
	
	public T create(T entity) throws DuplicateKeyException, IllegalArgumentException {
		
		if (!isIdBlankOrNull(entity.getId()) || hasInvalidFields(entity)) {
			throw new IllegalArgumentException();
		}
		
		entity.setId(null);
		entity.setVersion(0);
		entity.setCreatedBy(auditing.getCurrentAuditor().get());
		entity.setCreatedDate(new Date());
		
		return repository.insert(entity);
	}
	
	public T update(ID id, T entity) throws DuplicateKeyException, IllegalArgumentException {

		if (isIdBlankOrNull(id)  || hasInvalidFields(entity) || !repository.existsById(id) ) {
			throw new IllegalArgumentException();
		}
		
		Integer version = entity.getVersion() == null ? 1 : entity.getVersion() + 1;
		
		entity.setVersion(version);
		entity.setLastModifiedBy(auditing.getCurrentAuditor().get());
		entity.setLastModifiedDate(new Date());

		return repository.save(entity);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Boolean delete(ID id) throws IllegalArgumentException  {
		try {
			if (isIdBlankOrNull(id)) {
				throw new IllegalArgumentException();
			}
			
			String _id = id.toString().replaceAll("\"","");
			
			repository.deleteById((ID) _id);
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public T findById(ID id) throws IllegalArgumentException  {
		try {
			if (isIdBlankOrNull(id)) {
				throw new IllegalArgumentException();
			}
			
			String _id = id.toString().replaceAll("\"","");
			
			Optional<T> result = repository.findById((ID) _id);
			
			if (!result.isPresent()) {
				throw new NoSuchElementException();
			}
			
			return result.get();
		} catch (Exception e) {
			throw e;
		}
	}

	public Page<T> getAll(Pageable pageable) throws IllegalArgumentException {
		try {
			return repository.findAll(pageable);
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}
	
	public Long size() {
		try {
			return repository.count();
		} catch (Exception e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public Boolean existsById(ID id) {
		try {
			String _id = id.toString().replaceAll("\"","");
			return repository.existsById((ID) _id);
		} catch (Exception e) {
			return false;
		}
	}
	
	public List<T> insertAll(Iterable<T> iterable) throws DuplicateKeyException, IllegalArgumentException {
		try {
			return repository.insert(iterable);
		} catch (Exception e) {
			return new ArrayList<T>();
		}
	}
	
	public boolean isIdBlankOrNull(ID id) {
		return id == null || id.toString().isBlank();
	}
	
	public boolean hasInvalidFields(T entity) {
		return false;
	};
}
