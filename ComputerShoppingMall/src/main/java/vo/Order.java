package vo;

public class Order {
	private int orderNo;
	private String customerId;
	private int basketNo;
	private int totalPrice;
	private String orderDate;
	private String purpose;
	private String createDate;
	private String updateDate;
	
	@Override
	public String toString() {
		return "Order [orderNo=" + orderNo + ", customerId=" + customerId + ", basketNo=" + basketNo + ", totalPrice="
				+ totalPrice + ", orderDate=" + orderDate + ", purpose=" + purpose + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + "]";
	}
	
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public int getBasketNo() {
		return basketNo;
	}
	public void setBasketNo(int basketNo) {
		this.basketNo = basketNo;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
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
