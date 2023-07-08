package smartclick.cloud.system.store.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import smartclick.cloud.system.base.AbstractBaseController;
import smartclick.cloud.system.store.entity.smartstore.StoreCategory;
import smartclick.cloud.system.store.service.CategoryService;

@RestController
@RequestMapping("/store/category")
public class CategoryController extends AbstractBaseController<StoreCategory, String, CategoryService>{
	
	public CategoryController(CategoryService service) {
		super(service);
	}
}