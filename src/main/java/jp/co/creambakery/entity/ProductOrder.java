package jp.co.creambakery.entity;

import java.util.*;

import jakarta.persistence.*;
import jp.co.creambakery.form.*;

/**
 * product_orderテーブルのエンティティ
 * -- 注文
 * CREATE TABLE product_order (
 * id INTEGER PRIMARY KEY,
 * customer INTEGER REFERENCES customer(id),
 * payment_method NUMBER(1) NOT NULL CHECK (payment_method BETWEEN 0 AND 4),
 * credit_card INTEGER CHECK ((payment_method = 0 AND credit_card IS NOT NULL)
 * OR payment_method <> 0) REFERENCES credit_card(id),
 * date_created DATE DEFAULT CURRENT_DATE,
 * cancelled NUMBER(1) DEFAULT 0,
 * address INTEGER REFERENCES address_profile(id) NOT NULL,
 * optional_details VARCHAR2(512),
 * completed DATE
 * );
 * 
 */

@Entity
@Table(name = "product_order")
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_gen")
    @SequenceGenerator(name = "order_gen", sequenceName = "order_seq", allocationSize = 1)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer", referencedColumnName = "id")
    private User user;

    @Column(nullable = false)
    private Integer paymentMethod;

    @ManyToOne
    @JoinColumn(name = "credit_card", referencedColumnName = "id", nullable = true)
    private CreditCard creditCard;

    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date dateCreated;

    @Column(columnDefinition = "NUMBER(1) DEFAULT 0")
    private Integer cancelled = 0;

    @ManyToOne
    @JoinColumn(name = "address", nullable = false, referencedColumnName = "id")
    private AddressProfile address;

    @OneToMany(mappedBy = "productOrder")
    List<ProductOrderItem> items;

    @Column
    private String optionalDetails;

    @Column
    private Date completed;

    public ProductOrder()
    {
        dateCreated = new Date();
        completed = null;
    }
    
    public ProductOrder(User user, OrderForm form)
    {
        this();
        this.user = user;
        paymentMethod = form.getPaymentMethod();
        optionalDetails = form.getOptionalDetails();
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

    public Integer getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Integer paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Integer getCancelled() {
        return cancelled;
    }

    public void setCancelled(Integer cancelled) {
        this.cancelled = cancelled;
    }

    public AddressProfile getAddress() {
        return address;
    }

    public void setAddress(AddressProfile address) {
        this.address = address;
    }

    public String getOptionalDetails() {
        return optionalDetails;
    }

    public void setOptionalDetails(String optionalDetails) {
        this.optionalDetails = optionalDetails;
    }

    public Date getCompleted() {
        return completed;
    }

    public void setCompleted(Date completed) {
        this.completed = completed;
    }

    public List<ProductOrderItem> getItems() {
        if (items == null)
            return new ArrayList<>();

        return items;
    }

    public void setItems(List<ProductOrderItem> items) {
        this.items = items;
    }

}
