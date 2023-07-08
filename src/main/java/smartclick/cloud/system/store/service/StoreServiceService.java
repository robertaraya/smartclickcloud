package smartclick.cloud.system.store.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import smartclick.cloud.system.base.AbstractBaseService;
import smartclick.cloud.system.store.entity.smartstore.StoreService;
import smartclick.cloud.system.store.repository.StoreServiceRepository;

@Service
public class StoreServiceService extends AbstractBaseService<StoreService, String, StoreServiceRepository>{
	
	public StoreServiceService(StoreServiceRepository repository) {
		super(repository);
	}
	
	public Page<StoreService> findByName(String name, Pageable pageable) {
		return repository.findByName(name, pageable);
	}

	@Override
	public boolean hasInvalidFields(StoreService entity) {
		return entity.getName().isBlank();
	}
	
}
