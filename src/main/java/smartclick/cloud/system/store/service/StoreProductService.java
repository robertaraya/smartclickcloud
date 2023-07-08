package smartclick.cloud.system.store.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import smartclick.cloud.system.base.AbstractBaseService;
import smartclick.cloud.system.store.entity.smartstore.StoreProduct;
import smartclick.cloud.system.store.repository.StoreProductRepository;

@Service
public class StoreProductService extends AbstractBaseService<StoreProduct, String, StoreProductRepository>{
	
	public StoreProductService(StoreProductRepository repository) {
		super(repository);
	}
	
	public Page<StoreProduct> findByName(String name, Pageable pageable) {
		return repository.findByName(name, pageable);
	}

	@Override
	public boolean hasInvalidFields(StoreProduct entity) {
		return entity.getName().isBlank();
	}
	
}
