package jp.co.creambakery.entity;

import jakarta.persistence.*;
import jp.co.creambakery.entity.keys.*;

@Entity
@IdClass(CartKey.class)
@Table(name = "cart")
public class Cart 
{

    @Id
	@ManyToOne
	@JoinColumn(name = "customer", referencedColumnName = "id")
	private Customer customer;

	@Id
	@ManyToOne
	@JoinColumn(name = "item", referencedColumnName = "id")
	private Item item;

	@Column
	private Integer quantity;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}