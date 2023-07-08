package smartclick.cloud.system.admin.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import smartclick.cloud.system.admin.entity.Company;

public interface CompanyRepository extends MongoRepository<Company, String>{
	List<Company> findByName(String name);
	List<Company> findByCode(String code);
	List<Company> findByNameOrCode(String name, String code);
	List<Company> findByNameOrCodeAndIdNotContaining(String name, String code, String id);
}
