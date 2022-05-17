package vo;

public class Storage {
	private int storageNo;
	private String storageName;
	private String companyName;
	private String storageInterface;
	private String capacity;
	private int price;
	private int quantity;
	private int storageImageNo;
	private String memo;
	private String updateDate;
	private String categoryName;

	@Override
	public String toString() {
		return "Storage [storageNo=" + storageNo + ", storageName=" + storageName + ", companyName=" + companyName
				+ ", storageInterface=" + storageInterface + ", capacity=" + capacity + ", price=" + price
				+ ", quantity=" + quantity + ", storageImageNo=" + storageImageNo + ", memo=" + memo + ", updateDate="
				+ updateDate + ", categoryName=" + categoryName + "]";
	}

	public int getStorageNo() {
		return storageNo;
	}

	public void setStorageNo(int storageNo) {
		this.storageNo = storageNo;
	}

	public String getStorageName() {
		return storageName;
	}

	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getStorageInterface() {
		return storageInterface;
	}

	public void setStorageInterface(String storageInterface) {
		this.storageInterface = storageInterface;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
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

	public int getStorageImageNo() {
		return storageImageNo;
	}

	public void setStorageImageNo(int storageImageNo) {
		this.storageImageNo = storageImageNo;
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

}