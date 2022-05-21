package vo;

public class Ram {
	private int ramNo;
	private String ramName;
	private String companyName;
	private String categoryName;
	private String kind;
	private int price;
	private int quantity;
	private int ramImageNo;
	private String memo;
	private String updateDate;
	private String ramImageName;
	
	@Override
	public String toString() {
		return "Ram [ramNo=" + ramNo + ", ramName=" + ramName + ", companyName=" + companyName + ", categoryName="
				+ categoryName + ", kind=" + kind + ", price=" + price + ", quantity=" + quantity + ", ramImageNo="
				+ ramImageNo + ", memo=" + memo + ", updateDate=" + updateDate + ", ramImageName=" + ramImageName + "]";
	}

	public int getRamNo() {
		return ramNo;
	}

	public void setRamNo(int ramNo) {
		this.ramNo = ramNo;
	}

	public String getRamName() {
		return ramName;
	}

	public void setRamName(String ramName) {
		this.ramName = ramName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
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

	public int getRamImageNo() {
		return ramImageNo;
	}

	public void setRamImageNo(int ramImageNo) {
		this.ramImageNo = ramImageNo;
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

	public String getRamImageName() {
		return ramImageName;
	}

	public void setRamImageName(String ramImageName) {
		this.ramImageName = ramImageName;
	}
}