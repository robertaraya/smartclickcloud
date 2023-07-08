package smartclick.cloud.system.propertyhuntercr.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import smartclick.cloud.system.base.AbstractBaseEntity;

@Document(collection="propertyTypes")
public class PropertyType extends AbstractBaseEntity<String>{
	@Id
	private String id;
	
	private String name;
	private boolean forRent;
	private boolean forSale;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isForRent() {
		return forRent;
	}
	public void setForRent(boolean forRent) {
		this.forRent = forRent;
	}
	public boolean isForSale() {
		return forSale;
	}
	public void setForSale(boolean forSale) {
		this.forSale = forSale;
	}
}
