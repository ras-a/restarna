package jp.co.creambakery.entity;

import java.io.*;
import java.util.*;

import org.eclipse.persistence.annotations.*;

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
public class User implements Serializable
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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<AddressProfile> addresses;

    @OneToOne
    @JoinColumn(name = "main_address", referencedColumnName = "id")
    private AddressProfile mainAddress;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<CreditCard> creditCards;

    @OneToOne
    @JoinColumn(name = "main_credit_card", referencedColumnName = "id")
    private CreditCard mainCreditCard;

    @OneToMany(mappedBy = "creator", cascade = CascadeType.PERSIST)
    private List<CustomItem> createdItems;

    @Column(nullable = false)
    private String email;

    @ManyToMany
    @JoinTable(name = "favorite", joinColumns = @JoinColumn(name = "owner"), inverseJoinColumns = @JoinColumn(name = "item"))
    private List<Item> favorites;

    @OneToMany(mappedBy = "poster", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date dateCreated;

    @Column(columnDefinition = "NUMBER(1) DEFAULT 0")
    private Integer deleted;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @PrivateOwned
    private List<Cart> cart;

    @OneToMany(mappedBy = "user")
    private List<ProductOrder> orders;

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

    public List<AddressProfile> getAddresses() {
        if (addresses == null)
            return new ArrayList<>();
        return addresses;
    }

    public AddressProfile getAddress(Integer id) {
        AddressProfile out = null;
        for (var address : addresses) {
            if (address.getId() == id) {
                out = address;
            }
        }

        return out;
    }

    public void setAddresses(List<AddressProfile> addresses) {
        this.addresses = addresses;
    }

    public List<CreditCard> getCreditCards() {
        if (creditCards == null)
            return new ArrayList<>();
        return creditCards;
    }

    public CreditCard getCreditCard(Integer id) {
        CreditCard out = null;
        for (var card : creditCards) {
            if (card.getId() == id) {
                out = card;
            }
        }

        return out;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Item> getFavorites() {
        if (favorites == null)
            return new ArrayList<>();
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

    public List<Cart> getCart() {
        if (cart == null)
            return new ArrayList<>();
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }

    public List<ProductOrder> getOrders() {
        if (orders == null)
            return new ArrayList<>();
        return orders;
    }

    public void setOrders(List<ProductOrder> orders) {
        this.orders = orders;
    }

    public List<CustomItem> getCreatedItems() {
        if (createdItems == null)
            return new ArrayList<>();
        return createdItems;
    }

    public void setCreatedItems(List<CustomItem> createdItems) {
        this.createdItems = createdItems;
    }

    public CreditCard getMainCreditCard() {
        return mainCreditCard;
    }

    public void setMainCreditCard(CreditCard mainCreditCard) {
        this.mainCreditCard = mainCreditCard;
    }

	@Override
	public boolean equals(Object obj) {
		return obj instanceof User && id == ((User)obj).getId();
	}
}
