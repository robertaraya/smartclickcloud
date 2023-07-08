package smartclick.cloud.system.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import smartclick.cloud.system.admin.entity.SmartSystem;
import smartclick.cloud.system.admin.service.SmartSystemService;
import smartclick.cloud.system.base.AbstractBaseController;

@RestController
@RequestMapping("/admin/system")
public class SmartSystemController extends AbstractBaseController<SmartSystem, String, SmartSystemService>{

	public SmartSystemController(SmartSystemService service) {
		super(service);
	}
	
}
