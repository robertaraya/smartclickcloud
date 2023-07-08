package smartclick.cloud.security.config.local.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import smartclick.cloud.security.config.entity.User;
import smartclick.cloud.system.base.AbstractBaseService;

@Service
public class UserService extends AbstractBaseService<User, String, UserRepository>{
	
	public UserService(UserRepository repository) {
		super(repository);
	}
	
	public List<User> findByNameOrEmail(String name, String email) {
		return repository.findByNameOrEmail(name, email);
	}
	
	public User updateUserNameAndEmail(String id, User entity) {
		try {
			
			Optional<User> data = repository.findById(entity.getId());
	
			if (!data.isPresent()) {
				throw new IllegalArgumentException();
			}
			
			User _entity = data.get();
			_entity.setName(entity.getName());
			_entity.setEmail(entity.getEmail());

			return update(id, _entity);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public boolean hasInvalidFields(User entity) {
		return entity.getName().isBlank() || entity.getEmail().isBlank() || entity.getAuthorities().isEmpty();
	}
}
