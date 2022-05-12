package vo;

public class MainBoard {
	private int mainBoardNo;
	private String mainBoardName;
	private String kind;
	private String socketSize;
	private String chipset;
	private String ramVersion;
	private int price;
	private int quantity;
	private String companyName;
	private int mainBoardImageNo;
	private String memo;
	private String updateDate;
	
	@Override
	public String toString() {
		return "MainBoard [mainBoardNo=" + mainBoardNo + ", mainBoardName=" + mainBoardName + ", kind=" + kind
				+ ", socketSize=" + socketSize + ", chipset=" + chipset + ", ramVersion=" + ramVersion + ", price="
				+ price + ", quantity=" + quantity + ", companyName=" + companyName + ", mainBoardImageNo="
				+ mainBoardImageNo + ", memo=" + memo + ", updateDate=" + updateDate + "]";
	}
	
	public int getMainBoardNo() {
		return mainBoardNo;
	}
	public void setMainBoardNo(int mainBoardNo) {
		this.mainBoardNo = mainBoardNo;
	}
	public String getMainBoardName() {
		return mainBoardName;
	}
	public void setMainBoardName(String mainBoardName) {
		this.mainBoardName = mainBoardName;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
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
	public int getMainBoardImageNo() {
		return mainBoardImageNo;
	}
	public void setMainBoardImageNo(int mainBoardImageNo) {
		this.mainBoardImageNo = mainBoardImageNo;
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