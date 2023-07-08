package smartclick.cloud.system.propertyhuntercr.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import smartclick.cloud.system.base.AbstractBaseController;
import smartclick.cloud.system.propertyhuntercr.entity.PropertyType;
import smartclick.cloud.system.propertyhuntercr.service.PropertyTypeService;

@RestController
@RequestMapping("/public/propertyType")
public class PropertyTypeController extends AbstractBaseController<PropertyType, String, PropertyTypeService>{
	
	public PropertyTypeController(PropertyTypeService service) {
		super(service);
	}
}