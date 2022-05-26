package vo;

public class Customer {
	private String customerId;
	private String customerPw;
	private String name;
	private String nickName;
	private String email;
	private String phone;
	private int zipCode;
	private String province; // 시도
	private String city; // 시군구
	private String town; // 읍면
	private String roadAddress; // 도로명
	private String detailAddress;
	private String createDate;
	private String updateDate;
	private int adminCk;
	private String lastPwDate; // 비밀번호 변경 날짜 + 3달
	private int active;

	public String getlastPwDate() {
		return lastPwDate;
	}

	public void setlastPwDate(String lastPwDate) {
		this.lastPwDate = lastPwDate;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerPw=" + customerPw + ", name=" + name + ", nickName="
				+ nickName + ", email=" + email + ", phone=" + phone + ", zipCode=" + zipCode + ", province=" + province
				+ ", city=" + city + ", town=" + town + ", roadAddress=" + roadAddress + ", detailAddress="
				+ detailAddress + ", createDate=" + createDate + ", updateDate=" + updateDate + ", adminCk=" + adminCk
				+ ", lastPwDate=" + lastPwDate + ", active=" + active + "]";
	}

	public String getLastPwDate() {
		return lastPwDate;
	}

	public void setLastPwDate(String lastPwDate) {
		this.lastPwDate = lastPwDate;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerPw() {
		return customerPw;
	}

	public void setCustomerPw(String customerPw) {
		this.customerPw = customerPw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getRoadAddress() {
		return roadAddress;
	}

	public void setRoadAddress(String roadAddress) {
		this.roadAddress = roadAddress;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
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

	public int getAdminCk() {
		return adminCk;
	}

	public void setAdminCk(int adminCk) {
		this.adminCk = adminCk;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

}