package jp.co.creambakery.entity;

import java.util.*;

import jakarta.persistence.*;

/**
 * itemテーブルのエンティティ
 * CREATE TABLE item (
 * id INTEGER PRIMARY KEY,
 * name VARCHAR2(32 CHAR) NOT NULL,
 * reading VARCHAR2(64 CHAR) NOT NULL,
 * bread INTEGER REFERENCES bread(id) NOT NULL,
 * description VARCHAR2(512 CHAR) NOT NULL,
 * deleted NUMBER(1) DEFAULT 0
 * );
 * CREATE SEQUENCE item_seq NOCACHE;
 */

@Entity
@Table(name = "item")
public class Item
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_gen")
    @SequenceGenerator(name = "item_gen", sequenceName = "item_seq", allocationSize = 1)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String reading;

    @ManyToOne
    @JoinColumn(name = "bread", referencedColumnName = "id", nullable = false)
    private Bread bread;

    @ManyToMany
    @JoinTable(name = "item_cream",
        joinColumns = @JoinColumn(name = "item"),
        inverseJoinColumns = @JoinColumn(name = "cream"))
    private List<Cream> creams;

    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date dateCreated;

    @Column(nullable = false)
    private String description;

    @Column(columnDefinition = "NUMBER(1) DEFAULT 0")
    private Integer deleted;

    @OneToMany(mappedBy = "item")
    private List<Review> reviews;

    @OneToOne(mappedBy = "item")
    private CustomItem custom;

    @OneToOne(mappedBy = "item")
    private StoreItem store;
    @OneToMany(mappedBy = "item")
    private List<Cart> cart;

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

    public Bread getBread() {
        return bread;
    }

    public void setBread(Bread bread) {
        this.bread = bread;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
    
    public List<Cream> getCreams() {
        return creams;
    }

    public void setCreams(List<Cream> creams) {
        this.creams = creams;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }

    public StoreItem getStore() {
        return store;
    }

    public void setStore(StoreItem storeItem) {
        store = storeItem;
    }

    public CustomItem getCustom() {
        return custom;
    }

    public void setCustom(CustomItem customItem) {
        custom = customItem;
    }
}
