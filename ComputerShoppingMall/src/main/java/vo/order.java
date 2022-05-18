package vo;

public class order {
	private int orderNo;
	private int basketNo;
	private String customerId;
	private String categoryName;
	private int categoryNumber;
	private int categoryPrice;
	private int categoryQuantity;
	private String createDate;

	@Override
	public String toString() {
		return "Order [orderNo=" + orderNo + ", basketNo=" + basketNo + ", customerId=" + customerId + ", categoryName="
				+ categoryName + ", categoryNumber=" + categoryNumber + ", categoryPrice=" + categoryPrice
				+ ", categoryQuantity=" + categoryQuantity + ", createDate=" + createDate + "]";
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getBasketNo() {
		return basketNo;
	}

	public void setBasketNo(int basketNo) {
		this.basketNo = basketNo;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getCategoryNumber() {
		return categoryNumber;
	}

	public void setCategoryNumber(int categoryNumber) {
		this.categoryNumber = categoryNumber;
	}

	public int getCategoryPrice() {
		return categoryPrice;
	}

	public void setCategoryPrice(int categoryPrice) {
		this.categoryPrice = categoryPrice;
	}

	public int getCategoryQuantity() {
		return categoryQuantity;
	}

	public void setCategoryQuantity(int categoryQuantity) {
		this.categoryQuantity = categoryQuantity;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

}
