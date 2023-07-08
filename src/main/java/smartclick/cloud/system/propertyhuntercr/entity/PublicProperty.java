package smartclick.cloud.system.propertyhuntercr.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import smartclick.cloud.system.entity.Address;
import smartclick.cloud.system.entity.Building;
import smartclick.cloud.system.entity.Lot;

public class PublicProperty {
	private String id;
	private String propertyId;
	private String title;
	private String description;
	private boolean forSale;
	@JsonIgnoreProperties(value = { "folio", "realFolio", "commissionPercentage" })
	private SaleInformation saleInformation;
	private boolean forRent;
	@JsonIgnoreProperties(value = { "commissionPercentage" })
	private RentInformation rentInformation;
	private String propertyType;
	private List<Building> buildingList;
	private Lot lotInformation;
	private List<Amenity> amenityList;
	private Integer parkingSpaces;
	private Double maintenanceFee;
	private Address address;
	private String mainImage;
	private List<String> images;
	private List<String> videos;
	private boolean active;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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
