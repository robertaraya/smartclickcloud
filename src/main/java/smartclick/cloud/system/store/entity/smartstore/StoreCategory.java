package smartclick.cloud.system.store.entity.smartstore;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import smartclick.cloud.system.base.AbstractBaseEntity;

@Document(collection = "categories")
public class StoreCategory extends AbstractBaseEntity<String>{
	@Id
	private String id;
	
	@NotBlank
	@Indexed(unique = true)
	private String name;
	
	private List<String> aliasList;
	
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

	public List<String> getAliasList() {
		return aliasList;
	}
	public void setAliasList(List<String> aliasList) {
		this.aliasList = aliasList;
	}
}
