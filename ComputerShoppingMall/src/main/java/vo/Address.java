package vo;

public class Address {
	private int addressId; 
	private String zipCode;
	private String province;
	private String city;
	private String town;
	private String street;
	
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", zipCode=" + zipCode + ", province=" + province + ", city=" + city
				+ ", town=" + town + ", street=" + street + "]";
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
}
