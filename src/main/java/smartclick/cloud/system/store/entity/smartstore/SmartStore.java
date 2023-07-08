package smartclick.cloud.system.store.entity.smartstore;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import smartclick.cloud.security.config.entity.User;
import smartclick.cloud.system.base.AbstractBaseEntity;
import smartclick.cloud.system.entity.Address;
import smartclick.cloud.system.entity.Phone;
import smartclick.cloud.system.entity.SocialMedia;

@Document(collection="smartStores")
public class SmartStore extends AbstractBaseEntity<String>{
	@Id
	private String id;
	
	@NotNull
	@DBRef
	private User user;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String description;
	
	@NotEmpty
	@DBRef
	private List<StoreCategory> categoryList;
	
	@DBRef
	private List<StoreProduct> productList;
	
	@DBRef
	private List<StoreService> serviceList;
	
	private List<String> phoneNumberList;
	private List<Address> addressList;
	private List<String> scheduleList;
	private List<Phone> phoneList;
	private List<@Email String> emailList;
	private List<String> photoIdList;
	private String mainPhotoId;
	private List<SocialMedia> socialMediaList;
	private Boolean hasExpressService;
	private List<String> payMethod;

	@NotNull
	private Boolean isActive;

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
	
	public List<StoreProduct> getProductList() {
		return productList;
	}
	public void setProductList(List<StoreProduct> productList) {
		this.productList = productList;
	}

	public List<StoreService> getServiceList() {
		return serviceList;
	}
	public void setServiceList(List<StoreService> serviceList) {
		this.serviceList = serviceList;
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

	public List<StoreCategory> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<StoreCategory> categoryList) {
		this.categoryList = categoryList;
	}

	public List<String> getPhoneNumberList() {
		return phoneNumberList;
	}
	public void setPhoneNumberList(List<String> phoneNumberList) {
		this.phoneNumberList = phoneNumberList;
	}

	public List<Address> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public List<String> getScheduleList() {
		return scheduleList;
	}
	public void setScheduleList(List<String> scheduleList) {
		this.scheduleList = scheduleList;
	}

	public List<Phone> getPhoneList() {
		return phoneList;
	}
	public void setPhoneList(List<Phone> phoneList) {
		this.phoneList = phoneList;
	}

	public List<String> getEmailList() {
		return emailList;
	}
	public void setEmailList(List<String> emailList) {
		this.emailList = emailList;
	}

	public List<String> getPhotoIdList() {
		return photoIdList;
	}
	public void setPhotoIdList(List<String> photoIdList) {
		this.photoIdList = photoIdList;
	}

	public String getMainPhotoId() {
		return mainPhotoId;
	}
	public void setMainPhotoId(String mainPhotoId) {
		this.mainPhotoId = mainPhotoId;
	}

	public List<SocialMedia> getSocialMediaList() {
		return socialMediaList;
	}
	public void setSocialMediaList(List<SocialMedia> socialMediaList) {
		this.socialMediaList = socialMediaList;
	}

	public Boolean getHasExpressService() {
		return hasExpressService;
	}
	public void setHasExpressService(Boolean hasExpressService) {
		this.hasExpressService = hasExpressService;
	}

	public List<String> getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(List<String> payMethod) {
		this.payMethod = payMethod;
	}

	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}
