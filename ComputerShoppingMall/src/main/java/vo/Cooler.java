package vo;

public class Cooler {
	private int coolerNo;
	private String coolerName;
	private String companyName;
	private String kind;
	private int coolerSize;
	private int price;
	private int quantity;
	private int coolerImageNo;
	private String memo;
	private String updateDate;
	private String categoryName;
	private String coolerImageName;
	
	@Override
	public String toString() {
		return "Cooler [coolerNo=" + coolerNo + ", coolerName=" + coolerName + ", companyName=" + companyName
				+ ", kind=" + kind + ", coolerSize=" + coolerSize + ", price=" + price + ", quantity=" + quantity
				+ ", coolerImageNo=" + coolerImageNo + ", memo=" + memo + ", updateDate=" + updateDate
				+ ", categoryName=" + categoryName + ", coolerImageName=" + coolerImageName + "]";
	}

	public int getCoolerNo() {
		return coolerNo;
	}

	public void setCoolerNo(int coolerNo) {
		this.coolerNo = coolerNo;
	}

	public String getCoolerName() {
		return coolerName;
	}

	public void setCoolerName(String coolerName) {
		this.coolerName = coolerName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getCoolerSize() {
		return coolerSize;
	}

	public void setCoolerSize(int coolerSize) {
		this.coolerSize = coolerSize;
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

	public int getCoolerImageNo() {
		return coolerImageNo;
	}

	public void setCoolerImageNo(int coolerImageNo) {
		this.coolerImageNo = coolerImageNo;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCoolerImageName() {
		return coolerImageName;
	}

	public void setCoolerImageName(String coolerImageName) {
		this.coolerImageName = coolerImageName;
	}
}