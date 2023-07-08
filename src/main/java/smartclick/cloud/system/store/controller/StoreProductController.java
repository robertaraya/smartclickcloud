package smartclick.cloud.system.store.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import smartclick.cloud.system.base.AbstractBaseController;
import smartclick.cloud.system.store.entity.smartstore.StoreProduct;
import smartclick.cloud.system.store.service.StoreProductService;

@RestController
@RequestMapping("/store/product")
public class StoreProductController extends AbstractBaseController<StoreProduct, String, StoreProductService>{
	
	public StoreProductController(StoreProductService service) {
		super(service);
	}
}