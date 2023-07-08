package smartclick.cloud.system.store.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import smartclick.cloud.system.store.entity.smartstore.StoreCategory;

public interface CategoryRepository extends MongoRepository<StoreCategory, String>{
	List<StoreCategory> findByName(String name);
	List<StoreCategory> findByNameAndIdNotContaining(String name, String id);
}
