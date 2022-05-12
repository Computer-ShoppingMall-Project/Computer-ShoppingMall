package vo;

public class MainBoardImage {
	private int mainBoardImageNo;
	private String extension;
	private String name;
	private int size;
	private String kind;
	
	@Override
	public String toString() {
		return "MainBoardImage [mainBoardImageNo=" + mainBoardImageNo + ", extension=" + extension + ", name=" + name
				+ ", size=" + size + ", kind=" + kind + "]";
	}

	public int getMainBoardImageNo() {
		return mainBoardImageNo;
	}
	public void setMainBoardImageNo(int mainBoardImageNo) {
		this.mainBoardImageNo = mainBoardImageNo;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
}