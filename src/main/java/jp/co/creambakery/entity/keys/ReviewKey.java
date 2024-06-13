package jp.co.creambakery.entity.keys;

import java.io.Serializable;

import jp.co.creambakery.entity.*;

public class ReviewKey implements Serializable
{
	private Customer poster;
	private Item item;

	public ReviewKey() {}

	public ReviewKey(Customer poster, Item item) {
		this.poster = poster;
		this.item = item;
	}

	public Customer getPoster() {
		return poster;
	}

	public void setPoster(Customer poster) {
		this.poster = poster;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ReviewKey))
			return false;

		var other = (ReviewKey) obj;

		return poster.equals(other.poster) && item.equals(other.item);
	}
}
