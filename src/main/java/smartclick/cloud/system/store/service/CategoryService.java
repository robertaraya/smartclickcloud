package smartclick.cloud.system.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import smartclick.cloud.system.base.AbstractBaseService;
import smartclick.cloud.system.store.entity.smartstore.StoreCategory;
import smartclick.cloud.system.store.repository.CategoryRepository;

@Service
public class CategoryService extends AbstractBaseService<StoreCategory, String, CategoryRepository>{
	
	public CategoryService(CategoryRepository repository) {
		super(repository);
	}
	
	public List<StoreCategory> findByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public boolean hasInvalidFields(StoreCategory entity) {
		return entity.getName().isBlank();
	}
}
