package smartclick.cloud.system.entity;

public class Lot {
	private Double area;
	
	private Double front;
	private Double back;
	private Double left;
	private Double right;
	
	private String description;

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public Double getFront() {
		return front;
	}

	public void setFront(Double front) {
		this.front = front;
	}

	public Double getBack() {
		return back;
	}

	public void setBack(Double back) {
		this.back = back;
	}

	public Double getLeft() {
		return left;
	}

	public void setLeft(Double left) {
		this.left = left;
	}

	public Double getRight() {
		return right;
	}

	public void setRight(Double right) {
		this.right = right;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
