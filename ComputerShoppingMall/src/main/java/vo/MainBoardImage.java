package vo;

public class MainBoardImage {
	private int mainBoardImageNo;
	private String name;
	private String originalName;
	private String type;
	private String createDate;
	private String updateDate;

	@Override
	public String toString() {
		return "MainBoardImage [mainBoardImageNo=" + mainBoardImageNo + ", name=" + name + ", originalName="
				+ originalName + ", type=" + type + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}

	public int getMainBoardImageNo() {
		return mainBoardImageNo;
	}

	public void setMainBoardImageNo(int mainBoardImageNo) {
		this.mainBoardImageNo = mainBoardImageNo;
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