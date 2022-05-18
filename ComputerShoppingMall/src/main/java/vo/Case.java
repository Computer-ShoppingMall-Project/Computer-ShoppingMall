package vo;

public class Case {
	private int caseNo;
	private String caseName;
	private String caseSize;
	private String categoryName;
	private int gpuSize;
	private int bay89mm;
	private int bay64mm;
	private int price;
	private int quantity;
	private int caseImageNo;
	private String memo;
	private String updateDate;
	
	@Override
	public String toString() {
		return "Case [caseNo=" + caseNo + ", caseName=" + caseName + ", caseSize=" + caseSize + ", categoryName="
				+ categoryName + ", gpuSize=" + gpuSize + ", bay89mm=" + bay89mm + ", bay64mm=" + bay64mm + ", price="
				+ price + ", quantity=" + quantity + ", caseImageNo=" + caseImageNo + ", memo=" + memo + ", updateDate="
				+ updateDate + "]";
	}

	public int getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(int caseNo) {
		this.caseNo = caseNo;
	}

	public String getCaseName() {
		return caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	public String getCaseSize() {
		return caseSize;
	}

	public void setCaseSize(String caseSize) {
		this.caseSize = caseSize;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getGpuSize() {
		return gpuSize;
	}

	public void setGpuSize(int gpuSize) {
		this.gpuSize = gpuSize;
	}

	public int getBay89mm() {
		return bay89mm;
	}

	public void setBay89mm(int bay89mm) {
		this.bay89mm = bay89mm;
	}

	public int getBay64mm() {
		return bay64mm;
	}

	public void setBay64mm(int bay64mm) {
		this.bay64mm = bay64mm;
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

	public int getCaseImageNo() {
		return caseImageNo;
	}

	public void setCaseImageNo(int caseImageNo) {
		this.caseImageNo = caseImageNo;
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
