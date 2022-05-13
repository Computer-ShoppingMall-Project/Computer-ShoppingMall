package vo;

public class Basket {
	private int basketNo;
	private String customerId;
	private String categoryName;
	private int categoryNumber;
	private int price;
	private int quantity;
	private String createDate;
	private String updateDate;

	@Override
	public String toString() {
		return "Basket [basketNo=" + basketNo + ", customerId=" + customerId + ", categoryName=" + categoryName
				+ ", categoryNumber=" + categoryNumber + ", price=" + price + ", quantity=" + quantity + ", createDate="
				+ createDate + ", updateDate=" + updateDate + "]";
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

}