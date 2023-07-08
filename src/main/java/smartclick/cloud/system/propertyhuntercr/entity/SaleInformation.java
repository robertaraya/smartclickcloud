package smartclick.cloud.system.propertyhuntercr.entity;

public class SaleInformation {
	private String folio;
	private String realFolio;
	
	private Double salePrice;
	private Integer commissionPercentage;
	private Double totalPrice;
	
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public String getRealFolio() {
		return realFolio;
	}
	public void setRealFolio(String realFolio) {
		this.realFolio = realFolio;
	}
	public Double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}
	public Integer getCommissionPercentage() {
		return commissionPercentage;
	}
	public void setCommissionPercentage(Integer commissionPercentage) {
		this.commissionPercentage = commissionPercentage;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
