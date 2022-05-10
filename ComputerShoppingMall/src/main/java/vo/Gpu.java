package vo;

public class Gpu {

	private String customer_id;
	@Override
	public String toString() {
		return "Gpu [customer_id=" + customer_id + ", adrress_id=" + adrress_id + ", name=" + name + ", detail_address="
				+ detail_address + ", customer_pw=" + customer_pw + ", email=" + email + ", nickname=" + nickname
				+ ", phone=" + phone + ", create_date=" + create_date + ", updatedate=" + updatedate + "]";
	}
	private int adrress_id;
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public int getAdrress_id() {
		return adrress_id;
	}
	public void setAdrress_id(int adrress_id) {
		this.adrress_id = adrress_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail_address() {
		return detail_address;
	}
	public void setDetail_address(String detail_address) {
		this.detail_address = detail_address;
	}
	public String getCustomer_pw() {
		return customer_pw;
	}
	public void setCustomer_pw(String customer_pw) {
		this.customer_pw = customer_pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	private String name;
	private String detail_address;
	private String customer_pw;
	private String email;
	private String nickname;
	private int phone;
	private String create_date;
	private String updatedate;

	
}
