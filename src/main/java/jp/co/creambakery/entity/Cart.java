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
	private User user;

	@Id
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "item", referencedColumnName = "id")
	private Item item;

	@Column
	private Integer quantity;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Cart && user == ((Cart)obj).getUser() && item == ((Cart)obj).getItem();
	}
}