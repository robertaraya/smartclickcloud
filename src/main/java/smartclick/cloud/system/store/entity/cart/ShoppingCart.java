package smartclick.cloud.system.store.entity.cart;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import smartclick.cloud.security.config.entity.User;
import smartclick.cloud.system.base.AbstractBaseEntity;

@Document(collection="shoppingCarts")
public class ShoppingCart extends AbstractBaseEntity<String>{
	@Id
	private String id;
	private String companyId;
	
	@NotNull
	private User user;
	
	private List<ShoppingCartProduct> cartProducts;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ShoppingCartProduct> getCartProducts() {
		return cartProducts;
	}

	public void setCartProducts(List<ShoppingCartProduct> cartProducts) {
		this.cartProducts = cartProducts;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
}
