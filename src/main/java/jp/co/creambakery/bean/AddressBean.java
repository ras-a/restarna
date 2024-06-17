package jp.co.creambakery.bean;

import java.util.*;

import jp.co.creambakery.entity.*;

/**
 * AddressBean
 */
public class AddressBean
{
	private Integer id;
	private CustomerBean customer;
	private String name;
	private String postCode;
	private String address;
	private String phoneNumber;
	private String email;
	private String addresseeName;
	private String addresseeReading;
	private Date dateCreated;
	private Boolean deleted;

	AddressBean(AddressProfile entity)
	{
		id = entity.getId();
		name = entity.getName();
		postCode = entity.getPostCode();
		address = entity.getAddress();
		phoneNumber = entity.getPhoneNumber();
		email = entity.getEmail();
		addresseeName = entity.getAddresseeName();
		addresseeReading = entity.getAddresseeReading();
		dateCreated = entity.getDateCreated();
		deleted = entity.getDeleted() != 0;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public CustomerBean getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerBean customer) {
		this.customer = customer;
	}
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
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
}