package vo;

public class Cpu {
	private int cpuNo;
	private String cpuName;
	private String cpuKind;
	private String socketSize;
	private String core;
	private String thread;
	private int price;
	private int quantity;
	private int cpuImageNo; // FK -> cpu_image
	private String memo;
	private String updateDate;
	
	@Override
	public String toString() {
		return "Cpu [cpuNo=" + cpuNo + ", cpuName=" + cpuName + ", cpuKind=" + cpuKind + ", socketSize=" + socketSize
				+ ", core=" + core + ", thread=" + thread + ", price=" + price + ", quantity=" + quantity
				+ ", cpuImageNo=" + cpuImageNo + ", memo=" + memo + ", updateDate=" + updateDate + "]";
	}
	
	public int getCpuNo() {
		return cpuNo;
	}
	public void setCpuNo(int cpuNo) {
		this.cpuNo = cpuNo;
	}
	public String getCpuName() {
		return cpuName;
	}
	public void setCpuName(String cpuName) {
		this.cpuName = cpuName;
	}
	public String getCpuKind() {
		return cpuKind;
	}
	public void setCpuKind(String cpuKind) {
		this.cpuKind = cpuKind;
	}
	public String getSocketSize() {
		return socketSize;
	}
	public void setSocketSize(String socketSize) {
		this.socketSize = socketSize;
	}
	public String getCore() {
		return core;
	}
	public void setCore(String core) {
		this.core = core;
	}
	public String getThread() {
		return thread;
	}
	public void setThread(String thread) {
		this.thread = thread;
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
	public int getCpuImageNo() {
		return cpuImageNo;
	}
	public void setCpuImageNo(int cpuImageNo) {
		this.cpuImageNo = cpuImageNo;
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