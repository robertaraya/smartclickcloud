package smartclick.cloud.system.entity;

import java.util.List;

public class Building {
	private List<Room> roomList;
	private Integer floors;	
	private Double totalArea;

	public List<Room> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}

	public Integer getFloors() {
		return floors;
	}

	public void setFloors(Integer floors) {
		this.floors = floors;
	}

	public Double getTotalArea() {
		return totalArea;
	}

	public void setTotalArea(Double totalArea) {
		this.totalArea = totalArea;
	}
}

	
