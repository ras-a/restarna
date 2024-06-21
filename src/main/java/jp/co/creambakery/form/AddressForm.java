package jp.co.creambakery.form;

import jakarta.validation.constraints.*;

public class AddressForm {

	@NotBlank
	private String name;

	@Pattern(regexp = "\\d{3}-?\\d{4}")
	private String postCode;

	@NotBlank
	private String address;

	@Pattern(regexp = "\\d{3}[- ]?\\d{4}[- ]?\\d{4}")
	private String phoneNumber;

	@Email
	private String email;

	@NotBlank
	private String addresseeName;

	@NotBlank
	@Pattern(regexp = "[ア-ン]+")
	private String addresseeReading;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {

		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddresseeName() {
		return addresseeName;
	}

	public void setAddresseeName(String addresseeName) {
		this.addresseeName = addresseeName;
	}

	public String getAddresseeReading() {
		return addresseeReading;
	}

	public void setAddresseeReading(String addresseeReading) {
		this.addresseeReading = addresseeReading;
	}

}
