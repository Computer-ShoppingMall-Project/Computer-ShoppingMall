package vo;

public class CoolerImage {
	private int coolerNo; // FK -> cooler
	private String extension;
	private String name;
	private int size;
	private String kind;
	
	// getter + setter 
	public int getCoolerNo() {
		return coolerNo;
	}
	public void setCoolerNo(int coolerNo) {
		this.coolerNo = coolerNo;
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
	
	@Override
	public String toString() {
		return "CoolerImage [coolerNo=" + coolerNo + ", extension=" + extension + ", name=" + name + ", size=" + size
				+ ", kind=" + kind + "]";
	}
}
