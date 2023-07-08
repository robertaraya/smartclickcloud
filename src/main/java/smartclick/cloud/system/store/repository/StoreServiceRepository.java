package smartclick.cloud.system.store.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import smartclick.cloud.system.store.entity.smartstore.StoreCategory;
import smartclick.cloud.system.store.entity.smartstore.StoreService;

public interface StoreServiceRepository extends MongoRepository<StoreService, String>{
	
	List<StoreService> findByName(String name);
	
	Page<StoreService> findByName(String name, Pageable pageable);
	Page<StoreService> findByDescription(String description, Pageable pageable);
	
	Page<StoreService> findByCharacteristicList(String characteristic, Pageable pageable);
	Page<StoreService> findByCategoryList(StoreCategory category, Pageable pageable);
	
	Page<StoreService> findBySalePriceBetween(Double salePriceStart, Double salePriceEnd, Pageable pageable);
	
	Page<StoreService> findByNameAndIsActive(String name, Boolean isActive, Pageable pageable);
	Page<StoreService> findByDescriptionAndIsActive(String description, Boolean isActive, Pageable pageable);
}
