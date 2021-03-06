package vo;

public class Gpu {
	private int gpuNo;
	private String gpuName;
	private String companyName;
	private String categoryName;
	private String chipsetCompany;
	private int gpuSize; 
	private int price;
	private int quantity;
	private int gpuImageNo;
	private String memo;
	private String updateDate;
	private String gpuImageName;
	
	@Override
	public String toString() {
		return "Gpu [gpuNo=" + gpuNo + ", gpuName=" + gpuName + ", companyName=" + companyName + ", categoryName="
				+ categoryName + ", chipsetCompany=" + chipsetCompany + ", gpuSize=" + gpuSize + ", price=" + price
				+ ", quantity=" + quantity + ", gpuImageNo=" + gpuImageNo + ", memo=" + memo + ", updateDate="
				+ updateDate + ", gpuImageName=" + gpuImageName + "]";
	}

	public int getGpuNo() {
		return gpuNo;
	}

	public void setGpuNo(int gpuNo) {
		this.gpuNo = gpuNo;
	}

	public String getGpuName() {
		return gpuName;
	}

	public void setGpuName(String gpuName) {
		this.gpuName = gpuName;
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

	public String getChipsetCompany() {
		return chipsetCompany;
	}

	public void setChipsetCompany(String chipsetCompany) {
		this.chipsetCompany = chipsetCompany;
	}

	public int getGpuSize() {
		return gpuSize;
	}

	public void setGpuSize(int gpuSize) {
		this.gpuSize = gpuSize;
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

	public int getGpuImageNo() {
		return gpuImageNo;
	}

	public void setGpuImageNo(int gpuImageNo) {
		this.gpuImageNo = gpuImageNo;
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

	public String getGpuImageName() {
		return gpuImageName;
	}

	public void setGpuImageName(String gpuImageName) {
		this.gpuImageName = gpuImageName;
	}
}