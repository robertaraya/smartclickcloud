package smartclick.cloud.system.store.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import smartclick.cloud.system.store.entity.cart.ShoppingCart;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String>{
	ShoppingCart findByUserId(String id);
}
