package smartclick.cloud.system.store.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import smartclick.cloud.security.config.entity.CurrentUser;
import smartclick.cloud.security.config.entity.UserPrincipal;
import smartclick.cloud.system.base.AbstractBaseController;
import smartclick.cloud.system.store.entity.cart.ShoppingCart;
import smartclick.cloud.system.store.service.ShoppingCartService;

@RestController
@RequestMapping("/store/shoppingCart")
public class ShoppingCartController extends AbstractBaseController<ShoppingCart, String, ShoppingCartService>{
	
	public ShoppingCartController(ShoppingCartService service) {
		super(service);
	}
	
	@GetMapping()
	public ResponseEntity<ShoppingCart> getShoppingCart(@CurrentUser UserPrincipal userPrincipal) {
		return new ResponseEntity<>(service.findByUserId(userPrincipal), HttpStatus.OK);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<Page<ShoppingCart>> getAll(Pageable pageable) {
		return new ResponseEntity<>(service.getAll(pageable), HttpStatus.OK);
	}
}
