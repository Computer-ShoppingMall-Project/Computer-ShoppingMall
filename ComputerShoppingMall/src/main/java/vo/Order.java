package vo;

public class Order {
	private int orderNo;
	private int basketNo;
	private String customerId;
	private String categoryName;
	private int categoryNumber;
	private int categoryPrice;
	private int categoryQuantity;
	private String orderStatus; // 주문상태
	private String createDate;
	private String productName;
	private int productCount;
	private String refundCheck;
	private String cancelCheck;
	private int zipCode;
	private String roadAddress;
	private String detailAddress;
	
	@Override
	public String toString() {
		return "Order [orderNo=" + orderNo + ", basketNo=" + basketNo + ", customerId=" + customerId + ", categoryName="
				+ categoryName + ", categoryNumber=" + categoryNumber + ", categoryPrice=" + categoryPrice
				+ ", categoryQuantity=" + categoryQuantity + ", orderStatus=" + orderStatus + ", createDate="
				+ createDate + ", productName=" + productName + ", productCount=" + productCount + ", refundCheck="
				+ refundCheck + ", cancelCheck=" + cancelCheck + ", zipCode=" + zipCode + ", roadAddress=" + roadAddress
				+ ", detailAddress=" + detailAddress + "]";
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

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public String getRefundCheck() {
		return refundCheck;
	}

	public void setRefundCheck(String refundCheck) {
		this.refundCheck = refundCheck;
	}

	public String getCancelCheck() {
		return cancelCheck;
	}

	public void setCancelCheck(String cancelCheck) {
		this.cancelCheck = cancelCheck;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getRoadAddress() {
		return roadAddress;
	}

	public void setRoadAddress(String roadAddress) {
		this.roadAddress = roadAddress;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
}
