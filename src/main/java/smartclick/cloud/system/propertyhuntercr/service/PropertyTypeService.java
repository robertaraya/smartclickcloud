package smartclick.cloud.system.propertyhuntercr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import smartclick.cloud.system.base.AbstractBaseService;
import smartclick.cloud.system.propertyhuntercr.entity.PropertyType;
import smartclick.cloud.system.propertyhuntercr.repository.PropertyTypeRepository;

@Service
public class PropertyTypeService extends AbstractBaseService<PropertyType, String, PropertyTypeRepository>{
	
	public PropertyTypeService(PropertyTypeRepository repository) {
		super(repository);
	}
	
	public List<PropertyType> findByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public boolean hasInvalidFields(PropertyType entity) {
		return entity.getName().isBlank();
	}
}
