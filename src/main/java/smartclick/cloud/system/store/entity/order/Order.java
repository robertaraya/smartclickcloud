package smartclick.cloud.system.store.entity.order;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import smartclick.cloud.security.config.entity.User;
import smartclick.cloud.system.base.AbstractBaseEntity;

@Document(collection="orders")
public class Order extends AbstractBaseEntity<String>{
	@Id
	private String id;
	
	@NotBlank
	private String smartStoreId;
	
	@NotNull
	private User user;

	@NotNull
	private Date orderDate;

	@NotBlank
	private String payMethod;
	
	@NotBlank
	private String orderStatus;
	
	private String shippingAddress;
	private Date shippingDate;
	
	@NotEmpty
	private List<String> contactNumberList; 

	@NotEmpty
	private List<OrderDetail> orderDetail;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSmartStoreId() {
		return smartStoreId;
	}

	public void setSmartStoreId(String smartStoreId) {
		this.smartStoreId = smartStoreId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Date getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}

	public List<String> getContactNumberList() {
		return contactNumberList;
	}

	public void setContactNumberList(List<String> contactNumberList) {
		this.contactNumberList = contactNumberList;
	}

	public List<OrderDetail> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(List<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}
}
