package smartclick.cloud.system.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import smartclick.cloud.system.admin.entity.Company;
import smartclick.cloud.system.admin.service.CompanyService;
import smartclick.cloud.system.base.AbstractBaseController;

@RestController
@RequestMapping("/admin/company")
public class CompanyController extends AbstractBaseController<Company, String, CompanyService>{
	
	public CompanyController(CompanyService service) {
		super(service);
	}
}
