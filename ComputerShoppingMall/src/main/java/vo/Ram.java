package vo;

public class Ram {
	private int ramNo;
	private String ramName;
	private String companyName;
	private String ramKind;
	private int price;
	private int quantity;
	private int ramImageNo;
	private String memo;
	private String updateDate;
	
	@Override
	public String toString() {
		return "Ram [ramNo=" + ramNo + ", ramName=" + ramName + ", companyName=" + companyName + ", ramKind=" + ramKind
				+ ", price=" + price + ", quantity=" + quantity + ", ramImageNo=" + ramImageNo + ", memo=" + memo
				+ ", updateDate=" + updateDate + "]";
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

	public String getRamKind() {
		return ramKind;
	}

	public void setRamKind(String ramKind) {
		this.ramKind = ramKind;
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
}