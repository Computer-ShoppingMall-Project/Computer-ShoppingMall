package vo;

public class MainboardImage {
	private int mainboardImageNo;
	private String extension;
	private String name;
	private int size;
	private String kind;
	
	@Override
	public String toString() {
		return "MainboardImage [mainboardImageNo=" + mainboardImageNo + ", extension=" + extension + ", name=" + name
				+ ", size=" + size + ", kind=" + kind + "]";
	}
	
	public int getMainboardImageNo() {
		return mainboardImageNo;
	}
	public void setMainboardImageNo(int mainboardImageNo) {
		this.mainboardImageNo = mainboardImageNo;
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