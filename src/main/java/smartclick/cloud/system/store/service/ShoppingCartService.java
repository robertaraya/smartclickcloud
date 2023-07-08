package smartclick.cloud.system.store.service;

import org.springframework.stereotype.Service;

import smartclick.cloud.security.config.entity.UserPrincipal;
import smartclick.cloud.system.base.AbstractBaseService;
import smartclick.cloud.system.store.entity.cart.ShoppingCart;
import smartclick.cloud.system.store.repository.ShoppingCartRepository;

@Service
public class ShoppingCartService extends AbstractBaseService<ShoppingCart, String, ShoppingCartRepository>{
	public ShoppingCartService(ShoppingCartRepository repository) {
		super(repository);
	}
	
	public ShoppingCart findByUserId(UserPrincipal userPrincipal) {
		if (userPrincipal == null) {
			return new ShoppingCart();
		}
		return repository.findByUserId(userPrincipal.getId());
	}
}
