package smartclick.cloud.system.admin.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import smartclick.cloud.system.admin.entity.Menu;

public interface MenuRepository extends MongoRepository<Menu, String>{
	List<Menu> findByMenuTitle(String menuTitle);
	List<Menu> findByAuthoritiesIn(List<String> authorities);
}
