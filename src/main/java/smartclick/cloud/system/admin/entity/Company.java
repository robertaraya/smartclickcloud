package smartclick.cloud.system.admin.entity;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import smartclick.cloud.system.base.AbstractBaseEntity;
import smartclick.cloud.system.store.entity.smartstore.StoreCategory;

@Document(collection = "companies")
public class Company extends AbstractBaseEntity<String>{

	@Id
	private String id;

	@NotBlank
	@Indexed(name= "code", unique = true)
	private String code;
	
	@NotBlank
	@Indexed(name= "name", unique = true)
	private String name;
	
	@NotBlank
	@Email
	private String email;
	
	private List<String> userEmailList;
	
	private List<StoreCategory> categoryList;
	
	private List<String> systemIdList;

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
	
	public List<String> getSystemIdList() {
		return systemIdList;
	}
	public void setSystemIdList(List<String> systemIdList) {
		this.systemIdList = systemIdList;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<String> getUserEmailList() {
		return userEmailList;
	}
	public void setUserEmailList(List<String> userEmailList) {
		this.userEmailList = userEmailList;
	}
	
	public List<StoreCategory> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<StoreCategory> categoryList) {
		this.categoryList = categoryList;
	}
	
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", code=" + code + ", systemList=" + systemIdList + "]";
	}	
}
