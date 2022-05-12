package vo;

public class Customer {
	private String customerId;
	private int addressId;
	private String name;
	private String detailAddress;
	private String customerPw;
	private String email;
	private String nickName;
	private String phone;
	private String createDate;
	private String updateDate;
	private int customerCk;
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", addressId=" + addressId + ", name=" + name + ", detailAddress="
				+ detailAddress + ", customerPw=" + customerPw + ", email=" + email + ", nickName=" + nickName
				+ ", phone=" + phone + ", createDate=" + createDate + ", updateDate=" + updateDate + ", customerCk="
				+ customerCk + "]";
	}
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public int getCustomerCk() {
		return customerCk;
	}

	public void setCustomerCk(int customerCk) {
		this.customerCk = customerCk;
	}

	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	public String getCustomerPw() {
		return customerPw;
	}
	public void setCustomerPw(String customerPw) {
		this.customerPw = customerPw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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