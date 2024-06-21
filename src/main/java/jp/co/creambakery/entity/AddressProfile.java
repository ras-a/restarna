package jp.co.creambakery.entity;

import java.util.Date;

import jakarta.persistence.*;
import jp.co.creambakery.form.*;

/**
 * address_profileテーブルのエンティティ
 * CREATE TABLE address_profile (
 * id INTEGER PRIMARY KEY,
 * customer INTEGER REFERENCES customer(id) NOT NULL,
 * name VARCHAR2(32 CHAR) UNIQUE NOT NULL,
 * post_code VARCHAR2(8 BYTE) NOT NULL,
 * address VARCHAR2(128 CHAR) NOT NULL,
 * phone_number VARCHAR(11 BYTE),
 * email VARCHAR2(64 CHAR),
 * addressee_name VARCHAR2(32 CHAR) NOT NULL,
 * addressee_reading VARCHAR2(64 CHAR) NOT NULL,
 * date_created DATE DEFAULT CURRENT_DATE,
 * deleted NUMBER(1) DEFAULT 0
 * );
 * 
 * CREATE SEQUENCE address_seq NOCACHE;
 */

@Entity
@Table(name = "address_profile")
public class AddressProfile
{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_gen")
	@SequenceGenerator(name = "address_gen", sequenceName = "address_seq", allocationSize = 1)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "customer", referencedColumnName = "id", nullable = false)
	private User user;

	@Column(nullable = false, unique = true)
	private String name;

	@Column(nullable = false)
	private String postCode;

	@Column(nullable = false)
	private String address;

	@Column
	private String phoneNumber;

	@Column
	private String email;

	@Column(nullable = false)
	private String addresseeName;

	@Column(nullable = false)
	private String addresseeReading;

	@Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private Date dateCreated;

	@Column(columnDefinition = "NUMBER(1) DEFAULT 0")
	private Integer deleted = 0;

	public AddressProfile() {}

	public AddressProfile (User user, AddressForm form)
	{
		this.user = user;
		setName(form.getName());
		setPostCode(form.getPostCode());
		setAddress(form.getAddress());
		setPhoneNumber(form.getPhoneNumber());
		setEmail(form.getEmail());
		setAddresseeName(form.getAddresseeName());
		setAddresseeReading(form.getAddresseeReading());
		setDateCreated(new Date());

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		this.phoneNumber = phoneNumber
			.replace(" ", "")
			.replace("-", "");
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

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
}
