package vo;


public class GpuImage {
	private int gpuImageNo;
	private String extension;
	private String name;
	private int size;
	private String kind;
	
	// getter + setter
	public int getGpuImageNo() {
		return gpuImageNo;
	}
	public void setGpuImageNo(int gpuImageNo) {
		this.gpuImageNo = gpuImageNo;
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
		return "GpuImage [gpuImageNo=" + gpuImageNo + ", extension=" + extension + ", name=" + name + ", size=" + size
				+ ", kind=" + kind + "]";
	}
}
