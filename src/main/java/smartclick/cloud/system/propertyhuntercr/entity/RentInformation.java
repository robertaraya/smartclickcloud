package smartclick.cloud.system.propertyhuntercr.entity;

public class RentInformation {
	private Integer guests;
		
	private Integer commissionPercentage;
	
	private Double dailyPrice;
	private Double weeklyPrice;
	private Double monthlyPrice;

	private Double dailyLowSeasonPrice;
	private Double weeklyLowSeasonPrice;
	private Double monthlyLowSeasonPrice;

	private Double dailyHighSeasonPrice;
	private Double weeklyHighSeasonPrice;
	private Double monthlyHighSeasonPrice;
	
	private Double longTermPrice;
	private boolean onlyShortTerm;

	public Integer getGuests() {
		return guests;
	}

	public void setGuests(Integer guests) {
		this.guests = guests;
	}

	public boolean isOnlyShortTerm() {
		return onlyShortTerm;
	}

	public void setOnlyShortTerm(boolean onlyShortTerm) {
		this.onlyShortTerm = onlyShortTerm;
	}

	public Integer getCommissionPercentage() {
		return commissionPercentage;
	}

	public void setCommissionPercentage(Integer commissionPercentage) {
		this.commissionPercentage = commissionPercentage;
	}

	public Double getDailyPrice() {
		return dailyPrice;
	}

	public void setDailyPrice(Double dailyPrice) {
		this.dailyPrice = dailyPrice;
	}

	public Double getWeeklyPrice() {
		return weeklyPrice;
	}

	public void setWeeklyPrice(Double weeklyPrice) {
		this.weeklyPrice = weeklyPrice;
	}

	public Double getMonthlyPrice() {
		return monthlyPrice;
	}

	public void setMonthlyPrice(Double monthlyPrice) {
		this.monthlyPrice = monthlyPrice;
	}

	public Double getDailyLowSeasonPrice() {
		return dailyLowSeasonPrice;
	}

	public void setDailyLowSeasonPrice(Double dailyLowSeasonPrice) {
		this.dailyLowSeasonPrice = dailyLowSeasonPrice;
	}

	public Double getWeeklyLowSeasonPrice() {
		return weeklyLowSeasonPrice;
	}

	public void setWeeklyLowSeasonPrice(Double weeklyLowSeasonPrice) {
		this.weeklyLowSeasonPrice = weeklyLowSeasonPrice;
	}

	public Double getMonthlyLowSeasonPrice() {
		return monthlyLowSeasonPrice;
	}

	public void setMonthlyLowSeasonPrice(Double monthlyLowSeasonPrice) {
		this.monthlyLowSeasonPrice = monthlyLowSeasonPrice;
	}

	public Double getDailyHighSeasonPrice() {
		return dailyHighSeasonPrice;
	}

	public void setDailyHighSeasonPrice(Double dailyHighSeasonPrice) {
		this.dailyHighSeasonPrice = dailyHighSeasonPrice;
	}

	public Double getWeeklyHighSeasonPrice() {
		return weeklyHighSeasonPrice;
	}

	public void setWeeklyHighSeasonPrice(Double weeklyHighSeasonPrice) {
		this.weeklyHighSeasonPrice = weeklyHighSeasonPrice;
	}

	public Double getMonthlyHighSeasonPrice() {
		return monthlyHighSeasonPrice;
	}

	public void setMonthlyHighSeasonPrice(Double monthlyHighSeasonPrice) {
		this.monthlyHighSeasonPrice = monthlyHighSeasonPrice;
	}

	public Double getLongTermPrice() {
		return longTermPrice;
	}

	public void setLongTermPrice(Double longTermPrice) {
		this.longTermPrice = longTermPrice;
	}
}
