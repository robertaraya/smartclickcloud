package smartclick.cloud.system.admin.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import smartclick.cloud.security.config.entity.User;
import smartclick.cloud.security.config.local.service.UserService;
import smartclick.cloud.system.base.AbstractBaseController;

@RestController
@RequestMapping("/admin/user")
public class UserAdminController extends AbstractBaseController<User, String, UserService>{
	
	public UserAdminController(UserService service) {
		super(service);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable String id, @Valid @RequestBody User entity) {
		return new ResponseEntity<>(service.updateUserNameAndEmail(id, entity), HttpStatus.OK);
	}
	
}
