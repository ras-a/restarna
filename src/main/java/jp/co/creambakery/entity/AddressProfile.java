package jp.co.creambakery.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

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
public class AddressProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_profile_gen")
    @SequenceGenerator(name = "address_profile_gen", sequenceName = "address_profile_seq", allocationSize = 1)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer", referencedColumnName = "id", nullable = false)
    private Customer customer;

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
    private String addressName;

    @Column(nullable = false)
    private String addressReading;

    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date dateCreated;

    @Column(columnDefinition = "NUMBER(1) DEFAULT 0")
    private Integer deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
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

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getAddressReading() {
        return addressReading;
    }

    public void setAddressReading(String addressReading) {
        this.addressReading = addressReading;
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
