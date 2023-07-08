package smartclick.cloud.system.propertyhuntercr.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import smartclick.cloud.system.propertyhuntercr.entity.PropertyType;

@Repository
public interface PropertyTypeRepository extends MongoRepository<PropertyType, String>{
	List<PropertyType> findByName(String name);
	List<PropertyType> findByNameAndIdNotContaining(String name, String id);
}
