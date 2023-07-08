package smartclick.cloud.system.store.service;

import org.springframework.stereotype.Service;

import smartclick.cloud.system.base.AbstractBaseService;
import smartclick.cloud.system.store.entity.smartstore.SmartStore;
import smartclick.cloud.system.store.repository.SmartStoreRepository;

@Service
public class SmartStoreService extends AbstractBaseService<SmartStore, String, SmartStoreRepository>{

	public SmartStoreService(SmartStoreRepository repository) {
		super(repository);
	}

}
