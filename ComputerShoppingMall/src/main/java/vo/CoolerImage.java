package vo;

public class CoolerImage {
	private int coolerImageNo;
	private String name;
	private String originalName;
	private String type;
	private String createDate;
	private String updateDate;

	@Override
	public String toString() {
		return "CoolerImage [coolerImageNo=" + coolerImageNo + ", name=" + name + ", originalName=" + originalName
				+ ", type=" + type + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}

	public int getCoolerImageNo() {
		return coolerImageNo;
	}

	public void setCoolerImageNo(int coolerImageNo) {
		this.coolerImageNo = coolerImageNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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