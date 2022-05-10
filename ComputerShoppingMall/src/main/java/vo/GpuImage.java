package vo;


public class GpuImage {
	private int gpu_image_no;
	private String extension;
	private String name;
	private int size;
	public int getGpu_image_no() {
		return gpu_image_no;
	}
	public void setGpu_image_no(int gpu_image_no) {
		this.gpu_image_no = gpu_image_no;
	}
	public String getExtension() {
		return extension;
	}
	@Override
	public String toString() {
		return "GpuImage [gpu_image_no=" + gpu_image_no + ", extension=" + extension + ", name=" + name + ", size="
				+ size + ", kind=" + kind + "]";
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
	private String kind;
	
}
