package smartclick.cloud.system.admin.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import smartclick.cloud.system.admin.entity.SmartSystem;

public interface SmartSystemRepository extends MongoRepository<SmartSystem, String>{
	List<SmartSystem> findByName(String name);
	List<SmartSystem> findByCode(String code);
	List<SmartSystem> findByNameOrCode(String name, String code);
	List<SmartSystem> findByNameOrCodeAndIdNotLike(String name, String code, String id);
}
