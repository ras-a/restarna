package jp.co.creambakery.entity.keys;

import java.io.*;

import jp.co.creambakery.entity.*;

public class ProductOrderItemKey implements Serializable
{
	private ProductOrder productOrder;
	private Item item;

	public ProductOrderItemKey(){}

	public ProductOrderItemKey(ProductOrder productOrder, Item item) {
		 this.productOrder = productOrder;
		 this.item = item;
	}

	public ProductOrder getProductOrder() {
		 return productOrder;
	}

	public void setProductOrder(ProductOrder productOrder) {
		 this.productOrder = productOrder;
	}

	public Item getItem() {
		 return item;
	}

	public void setItem(Item item) {
		 this.item = item;
	}

	@Override
	public boolean equals(Object obj) {
		 if (!(obj instanceof ProductOrderItemKey))
			  return false;
		 var other = (ProductOrderItemKey) obj;

		 return productOrder.equals(other.productOrder) && item.equals(other.item);
	}
	
  	@Override
	public int hashCode() {
		 return super.hashCode();
	}

}
