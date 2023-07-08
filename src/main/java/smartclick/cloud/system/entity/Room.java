package smartclick.cloud.system.entity;

public class Room {
	private String name;
	private Integer quantity;
	private Double area;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Double getArea() {
		return area;
	}
	public void setArea(Double area) {
		this.area = area;
	}
}
