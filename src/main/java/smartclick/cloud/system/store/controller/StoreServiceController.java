package smartclick.cloud.system.store.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import smartclick.cloud.system.base.AbstractBaseController;
import smartclick.cloud.system.store.entity.smartstore.StoreService;
import smartclick.cloud.system.store.service.StoreServiceService;

@RestController
@RequestMapping("/store/service")
public class StoreServiceController extends AbstractBaseController<StoreService, String, StoreServiceService>{
	
	public StoreServiceController(StoreServiceService service) {
		super(service);
	}
}