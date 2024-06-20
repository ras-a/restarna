package jp.co.creambakery.entity.keys;

import java.io.*;

import jp.co.creambakery.entity.*;

public class CartKey implements Serializable
{
	private User user;
	private Item item;

    public CartKey() {}

	public CartKey(User user, Item item) {
		this.user = user;
		this.item = item;
	}

    
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

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CartKey))
           return false;
         
        var other = (CartKey) obj;
    
        return user.equals(other.user) && item.equals(other.item);
    }
    
	@Override
	public int hashCode() {
		 return super.hashCode();
	}

}
