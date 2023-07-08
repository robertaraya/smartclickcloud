package smartclick.cloud.system.store.entity.smartstore;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import smartclick.cloud.system.base.AbstractBaseEntity;

@Document(collection = "products")
public class StoreProduct extends AbstractBaseEntity<String>{
	@Id
	private String id;
	
	@NotBlank
	@DBRef
	private SmartStore smartStore;
	
	@NotBlank
	private String name;
	@NotBlank
	private String code;
	
	private String description;
	
	private List<String> characteristicList;
	
	@NotEmpty
	@DBRef
	private List<StoreCategory> categoryList;
	
	private List<String> photoListId;
	
	@NotNull
	private Double salePrice;
	
	private Double listPrice;
	
	@NotNull
	private Boolean isActive;
	
	@NotNull
	private Integer stock;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public SmartStore getSmartStore() {
		return smartStore;
	}
	public void setSmartStore(SmartStore smartStore) {
		this.smartStore = smartStore;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getCharacteristicList() {
		return characteristicList;
	}
	public void setCharacteristicList(List<String> characteristicList) {
		this.characteristicList = characteristicList;
	}
	public List<StoreCategory> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<StoreCategory> categoryList) {
		this.categoryList = categoryList;
	}
	public List<String> getPhotoListId() {
		return photoListId;
	}
	public void setPhotoListId(List<String> photoListId) {
		this.photoListId = photoListId;
	}
	public Double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}
	public Double getListPrice() {
		return listPrice;
	}
	public void setListPrice(Double listPrice) {
		this.listPrice = listPrice;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
