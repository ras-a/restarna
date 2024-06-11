package jp.co.creambakery.entity;

import java.util.Date;

import jakarta.persistence.*;

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
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer", referencedColumnName = "id")
    private Customer customer;

    @Column(nullable = false)
    private Integer paymentMethod;

    @ManyToOne
    @JoinColumn(name = "creditcard", referencedColumnName = "id", nullable = true)
    private CreditCard creditCard;

    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date dateCreated;

    @Column(columnDefinition = "NUMBER(1) DEFAULT 0")
    private Integer cancelled = 0;

    @ManyToOne
    @JoinColumn(name = "address", nullable = false, referencedColumnName = "id")
    private AddressProfile address;

    @Column
    private String optionalDetails;

    @Column
    private Date completed;

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

}
