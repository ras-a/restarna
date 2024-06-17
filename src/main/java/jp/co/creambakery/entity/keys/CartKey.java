package jp.co.creambakery.entity.keys;

import java.io.*;

import jp.co.creambakery.entity.*;

public class CartKey implements Serializable
{
	private Customer customer;
	private Item item;

    public CartKey() {}

	public CartKey(Customer customer, Item item) {
		this.customer = customer;
		this.item = item;
	}

    
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

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CartKey))
           return false;
         
        var other = (CartKey) obj;
    
        return customer.equals(other.customer) && item.equals(other.item);
    }
    
	@Override
	public int hashCode() {
		 return super.hashCode();
	}

}
