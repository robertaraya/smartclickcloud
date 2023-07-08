package smartclick.cloud.system.propertyhuntercr.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import smartclick.cloud.system.base.AbstractBaseController;
import smartclick.cloud.system.propertyhuntercr.entity.Property;
import smartclick.cloud.system.propertyhuntercr.service.PropertyAdminService;

@RestController
@RequestMapping("/property/admin")
public class PropertyAdminController extends AbstractBaseController<Property, String, PropertyAdminService>{

	public PropertyAdminController(PropertyAdminService service) {
		super(service);
	}
	
}