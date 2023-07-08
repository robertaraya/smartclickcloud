package smartclick.cloud.system.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import smartclick.cloud.system.admin.entity.SmartSystem;
import smartclick.cloud.system.admin.repository.SmartSystemRepository;
import smartclick.cloud.system.base.AbstractBaseService;

@Service
public class SmartSystemService extends AbstractBaseService<SmartSystem, String, SmartSystemRepository>{
	
	public SmartSystemService(SmartSystemRepository repository) {
		super(repository);
	}

	public List<SmartSystem> findByNameOrCode(String name, String code) {
		return repository.findByNameOrCode(name, code);
	}

	@Override
	public boolean hasInvalidFields(SmartSystem entity) {
		return entity.getName().isBlank() || entity.getCode().isBlank();
	}
	
}
