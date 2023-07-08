package smartclick.cloud.system.store.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import smartclick.cloud.security.config.entity.User;
import smartclick.cloud.system.store.entity.smartstore.SmartStore;

public interface SmartStoreRepository extends MongoRepository<SmartStore, String> {
	SmartStore findByUser(User user);
}
