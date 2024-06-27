package jp.co.creambakery.bean;

import java.io.*;

import jp.co.creambakery.entity.*;

public class OrderItemBean implements Serializable
{
	private ItemBean item;
	private Integer amount;

	public OrderItemBean() {}
	public OrderItemBean(ProductOrderItem entity)
	{
		amount = entity.getAmount();
	}

	public ItemBean getItem() {
		return item;
	}

	public void setItem(ItemBean item) {
		this.item = item;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getPrice()
	{
		return item.getPrice() * amount;
	}
}
