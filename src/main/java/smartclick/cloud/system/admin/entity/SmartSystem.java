package smartclick.cloud.system.admin.entity;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import smartclick.cloud.system.base.AbstractBaseEntity;

@Document(collection = "systems")
public class SmartSystem extends AbstractBaseEntity<String>{
	@Id
	private String id;
	
	@NotBlank
	@Indexed(unique = true)
	private String name;
	
	@NotBlank
	@Indexed(unique = true)
	private String code;
	
	private String authority;
	
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
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	@Override
	public String toString() {
		return "System [id=" + id + ", name=" + name + ", code=" + code + "]";
	}
	
}
