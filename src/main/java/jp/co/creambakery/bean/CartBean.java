package jp.co.creambakery.bean;

import jp.co.creambakery.entity.*;

/**
 * CartBean
 */
public class CartBean {

	private ItemBean item;
	private Integer quantity;

	CartBean(Cart entity)
	{
		quantity = entity.getQuantity();
	}
	 
	public ItemBean getItem() {
		return item;
	}
	 
	public void setItem(ItemBean item) {
		this.item = item;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return item.getPrice() * quantity;
	}
}
