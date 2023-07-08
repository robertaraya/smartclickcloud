package smartclick.cloud.system.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import smartclick.cloud.system.admin.entity.Company;
import smartclick.cloud.system.admin.repository.CompanyRepository;
import smartclick.cloud.system.base.AbstractBaseService;

@Service
public class CompanyService extends AbstractBaseService<Company, String, CompanyRepository>{
	
	public CompanyService(CompanyRepository repository) {
		super(repository);
	}

	public List<Company> findByNameOrCode(String name, String code) {
		return repository.findByNameOrCode(name, code);
	}
	
}
