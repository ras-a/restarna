package jp.co.creambakery.entity.keys;

import java.io.*;

import jp.co.creambakery.entity.*;

public class FavoriteKey implements Serializable
{
	private Customer owner;
	private Item item;

    public FavoriteKey() {}

	public FavoriteKey(Customer owner, Item item) {
		this.owner = owner;
		this.item = item;
	}


    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof FavoriteKey))
           return false;
         
        var other = (FavoriteKey) obj;
    
        return owner.equals(other.owner) && item.equals(other.item);
    }
    
	@Override
	public int hashCode() {
		 return super.hashCode();
	}

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    
    
}
