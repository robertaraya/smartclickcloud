package smartclick.cloud.security.config.local.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import smartclick.cloud.security.config.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);
    
    List<User> findByName(String name);
	List<User> findByNameOrEmail(String name, String email);
	List<User> findByNameOrEmailAndIdNotContaining(String name, String email, String id);

}
