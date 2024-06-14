package jp.co.creambakery.entity;

import java.util.*;

import jakarta.persistence.*;

/**
 * customerテーブルのエンティティ
 * CREATE TABLE customer (
 * id INTEGER PRIMARY KEY,
 * name VARCHAR2(32 CHAR) NOT NULL,
 * -- 読み仮名
 * reading VARCHAR2(64 CHAR) NOT NULL,
 * password VARCHAR2(128) NOT NULL,
 * email VARCHAR2(64 CHAR) NOT NULL,
 * date_created DATE DEFAULT CURRENT_DATE,
 * deleted NUMBER(1) DEFAULT 0
 * );
 *
 * CREATE SEQUENCE customer_seq NOCACHE;
 */

@Entity
@Table(name = "customer")
public class Customer
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_gen")
    @SequenceGenerator(name = "customer_gen", sequenceName = "customer_seq", allocationSize = 1)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String reading;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "customer")
    private List<AddressProfile> addresses;

    @OneToMany(mappedBy = "owner")
    private List<CreditCard> creditCards;

    @OneToOne
    @JoinColumn(name = "main_address", referencedColumnName = "id")
    private AddressProfile mainAddress;

    @Column(nullable = false)
    private String email;

    @ManyToMany
    @JoinTable(name = "favorite",
        joinColumns = @JoinColumn(name = "owner"),
        inverseJoinColumns = @JoinColumn(name = "item"))
    private List<Item> favorites;

    @OneToMany(mappedBy = "poster")
    private List<Review> reviews;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReading() {
        return reading;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<AddressProfile> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressProfile> addresses) {
        this.addresses = addresses;
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public AddressProfile getMainAddress() {
        return mainAddress;
    }

    public void setMainAddress(AddressProfile mainAddress) {
        this.mainAddress = mainAddress;
    }

    public List<Item> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Item> favorites) {
        this.favorites = favorites;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

}
