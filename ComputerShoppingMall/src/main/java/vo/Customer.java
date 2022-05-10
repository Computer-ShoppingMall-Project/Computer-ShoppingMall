package vo;

public class Customer {
	private int gpu_no;
	private String gpu_name;
	private String company_name;
	private String chipset_companyname;
	private int gpu_size; 
	public int getGpu_no() {
		return gpu_no;
	}
	@Override
	public String toString() {
		return "Customer [gpu_no=" + gpu_no + ", gpu_name=" + gpu_name + ", company_name=" + company_name
				+ ", chipset_companyname=" + chipset_companyname + ", gpu_size=" + gpu_size + ", price=" + price
				+ ", quantity=" + quantity + ", gpu_image_no=" + gpu_image_no + ", memo=" + memo + ", updatedate="
				+ updatedate + "]";
	}
	public void setGpu_no(int gpu_no) {
		this.gpu_no = gpu_no;
	}
	public String getGpu_name() {
		return gpu_name;
	}
	public void setGpu_name(String gpu_name) {
		this.gpu_name = gpu_name;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getChipset_companyname() {
		return chipset_companyname;
	}
	public void setChipset_companyname(String chipset_companyname) {
		this.chipset_companyname = chipset_companyname;
	}
	public int getGpu_size() {
		return gpu_size;
	}
	public void setGpu_size(int gpu_size) {
		this.gpu_size = gpu_size;
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
	public int getGpu_image_no() {
		return gpu_image_no;
	}
	public void setGpu_image_no(int gpu_image_no) {
		this.gpu_image_no = gpu_image_no;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	private int price;  
	private int quantity;
	private int gpu_image_no;
	private String memo; 
	private String updatedate;

}
