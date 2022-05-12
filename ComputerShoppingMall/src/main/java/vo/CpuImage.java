package vo;

public class CpuImage {
	private int cpuImageNo; // FK -> cpu
	private String name;
	private String kind;
	private int size;
	private String extension;
	
	@Override
	public String toString() {
		return "CpuImage [cpuImageNo=" + cpuImageNo + ", extension=" + extension + ", name=" + name + ", size=" + size
				+ ", kind=" + kind + "]";
	}
	
	// getter + setter
	public int getCpuImageNo() {
		return cpuImageNo;
	}
	public void setCpuImageNo(int cpuImageNo) {
		this.cpuImageNo = cpuImageNo;
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