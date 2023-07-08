package smartclick.cloud.system.propertyhuntercr.entity;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import smartclick.cloud.system.base.AbstractBaseEntity;
import smartclick.cloud.system.entity.Address;
import smartclick.cloud.system.entity.Building;
import smartclick.cloud.system.entity.Contact;
import smartclick.cloud.system.entity.Lot;

@Document(collection="properties")
public class Property extends AbstractBaseEntity<String>{
	@Id
	private String id;
	
	private Integer consecutive;
	
	@NotBlank
	private String propertyId;
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String description;

	private boolean forSale;
	private SaleInformation saleInformation;

	private boolean forRent;
	private RentInformation rentInformation;

	@NotNull
	private String propertyType;
	
	private List<PropertyType> propertyTypeList;
	
	private List<Building> buildingList;
	
	@NotNull
	private Lot lotInformation;

	private List<Amenity> amenityList;
	
	private Integer parkingSpaces;	
	private Double maintenanceFee;
	
	@NotNull
	private Address address;
	
	private Contact contact;
	
//	@NotEmpty
	private List<Contact> contactList;

	private String mainImage;
	private List<String> images;
	
	private List<String> videos;
	
	@Transient
	private List<String> imagesToAdd = new ArrayList<>();
	@Transient
	private List<String> imagesToRemove = new ArrayList<>();
	
	private List<String> documents;
	@Transient
	private List<String> documentsToAdd = new ArrayList<>();
	@Transient
	private List<String> documentsToRemove = new ArrayList<>();
	
	private boolean active;
	private String status;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getConsecutive() {
		return consecutive;
	}

	public void setConsecutive(Integer consecutive) {
		this.consecutive = consecutive;
	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public SaleInformation getSaleInformation() {
		return saleInformation;
	}

	public void setSaleInformation(SaleInformation saleInformation) {
		this.saleInformation = saleInformation;
	}

	public RentInformation getRentInformation() {
		return rentInformation;
	}

	public void setRentInformation(RentInformation rentInformation) {
		this.rentInformation = rentInformation;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public List<PropertyType> getPropertyTypeList() {
		return propertyTypeList;
	}

	public void setPropertyTypeList(List<PropertyType> propertyTypeList) {
		this.propertyTypeList = propertyTypeList;
	}

	public List<Building> getBuildingList() {
		return buildingList;
	}

	public void setBuildingList(List<Building> buildingList) {
		this.buildingList = buildingList;
	}

	public Lot getLotInformation() {
		return lotInformation;
	}

	public void setLotInformation(Lot lotInformation) {
		this.lotInformation = lotInformation;
	}

	public List<Amenity> getAmenityList() {
		return amenityList;
	}

	public void setAmenityList(List<Amenity> amenityList) {
		this.amenityList = amenityList;
	}

	public Integer getParkingSpaces() {
		return parkingSpaces;
	}

	public void setParkingSpaces(Integer parkingSpaces) {
		this.parkingSpaces = parkingSpaces;
	}

	public Double getMaintenanceFee() {
		return maintenanceFee;
	}

	public void setMaintenanceFee(Double maintenanceFee) {
		this.maintenanceFee = maintenanceFee;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public String getMainImage() {
		return mainImage;
	}

	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public List<String> getImagesToAdd() {
		return imagesToAdd;
	}

	public void setImagesToAdd(List<String> imagesToAdd) {
		this.imagesToAdd = imagesToAdd;
	}

	public List<String> getImagesToRemove() {
		return imagesToRemove;
	}

	public void setImagesToRemove(List<String> imagesToRemove) {
		this.imagesToRemove = imagesToRemove;
	}

	public List<String> getDocuments() {
		return documents;
	}

	public void setDocuments(List<String> documents) {
		this.documents = documents;
	}
	
	public List<String> getDocumentsToAdd() {
		return documentsToAdd;
	}
	
	public void setDocumentsToAdd(List<String> documentsToAdd) {
		this.documentsToAdd = documentsToAdd;
	}
	
	public List<String> getDocumentsToRemove() {
		return documentsToRemove;
	}
	
	public void setDocumentsToRemove(List<String> documentsToRemove) {
		this.documentsToRemove = documentsToRemove;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isForSale() {
		return forSale;
	}

	public void setForSale(boolean forSale) {
		this.forSale = forSale;
	}

	public boolean isForRent() {
		return forRent;
	}

	public void setForRent(boolean forRent) {
		this.forRent = forRent;
	}

	public List<String> getVideos() {
		return videos;
	}

	public void setVideos(List<String> videos) {
		this.videos = videos;
	}
}
