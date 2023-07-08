package smartclick.cloud.system.store.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import smartclick.cloud.system.store.entity.smartstore.StoreCategory;
import smartclick.cloud.system.store.entity.smartstore.StoreProduct;

public interface StoreProductRepository extends MongoRepository<StoreProduct, String>{
	
	List<StoreProduct> findByName(String name);
	List<StoreProduct> findByCode(String code);
	
	Page<StoreProduct> findByName(String name, Pageable pageable);
	Page<StoreProduct> findByCode(String code, Pageable pageable);
	Page<StoreProduct> findByDescription(String description, Pageable pageable);
	
	Page<StoreProduct> findByCharacteristicList(String characteristic, Pageable pageable);
	Page<StoreProduct> findByCategoryList(StoreCategory category, Pageable pageable);
	
	Page<StoreProduct> findBySalePriceBetween(Double salePriceStart, Double salePriceEnd, Pageable pageable);
	
	Page<StoreProduct> findByNameAndIsActive(String name, Boolean isActive, Pageable pageable);
	Page<StoreProduct> findByCodeAndIsActive(String code, Boolean isActive, Pageable pageable);
	Page<StoreProduct> findByDescriptionAndIsActive(String description, Boolean isActive, Pageable pageable);
}
