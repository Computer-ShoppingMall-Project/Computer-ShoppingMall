package vo;

public class Mainboard {
	private int mainboardNo;
	private String mainboardName;
	private String mainboardKind;
	private String socketSize;
	private String chipset;
	private String ramVersion;
	private int price;
	private int quantity;
	private String companyName;
	private int mainboardImageNo;
	private String memo;
	private String updateDate;
	public int getMainboardNo() {
		return mainboardNo;
	}
	public void setMainboardNo(int mainboardNo) {
		this.mainboardNo = mainboardNo;
	}
	public String getMainboardName() {
		return mainboardName;
	}
	public void setMainboardName(String mainboardName) {
		this.mainboardName = mainboardName;
	}
	public String getMainboardKind() {
		return mainboardKind;
	}
	public void setMainboardKind(String mainboardKind) {
		this.mainboardKind = mainboardKind;
	}
	public String getSocketSize() {
		return socketSize;
	}
	public void setSocketSize(String socketSize) {
		this.socketSize = socketSize;
	}
	public String getChipset() {
		return chipset;
	}
	public void setChipset(String chipset) {
		this.chipset = chipset;
	}
	public String getRamVersion() {
		return ramVersion;
	}
	public void setRamVersion(String ramVersion) {
		this.ramVersion = ramVersion;
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getMainboardImageNo() {
		return mainboardImageNo;
	}
	public void setMainboardImageNo(int mainboardImageNo) {
		this.mainboardImageNo = mainboardImageNo;
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
	@Override
	public String toString() {
		return "Mainboard [mainboardNo=" + mainboardNo + ", mainboardName=" + mainboardName + ", mainboardKind="
				+ mainboardKind + ", socketSize=" + socketSize + ", chipset=" + chipset + ", ramVersion=" + ramVersion
				+ ", price=" + price + ", quantity=" + quantity + ", companyName=" + companyName + ", mainboardImageNo="
				+ mainboardImageNo + ", memo=" + memo + ", updateDate=" + updateDate + "]";
	}
	
}