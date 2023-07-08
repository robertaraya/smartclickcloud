package smartclick.cloud.system.store.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

//import graphql.kickstart.tools.GraphQLQueryResolver;
import smartclick.cloud.system.store.entity.smartstore.StoreCategory;
import smartclick.cloud.system.store.service.CategoryService;

@Component
public class StoreCategoryResolver {// implements GraphQLQueryResolver{
	
	@Autowired
	private CategoryService service;
	
	public List<StoreCategory> getCategories(){
		Pageable pageable = PageRequest.of(0, 20);
		return service.getAll(pageable).getContent();
	}
}
