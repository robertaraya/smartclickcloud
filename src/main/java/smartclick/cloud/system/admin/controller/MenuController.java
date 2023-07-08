package smartclick.cloud.system.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import smartclick.cloud.system.admin.entity.Menu;
import smartclick.cloud.system.admin.service.MenuService;
import smartclick.cloud.system.base.AbstractBaseController;

@RestController
@RequestMapping("/admin/menu")
public class MenuController extends AbstractBaseController<Menu, String, MenuService>{
	
	public MenuController(MenuService service) {
		super(service);
	}
}
