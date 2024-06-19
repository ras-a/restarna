package jp.co.creambakery.bean;

import jp.co.creambakery.entity.*;

/**
 * CartBean
 */
public class CartBean {

	private CustomerBean poster;
	private ItemBean item;
	private Integer quantity;
    
    CartBean(Cart entity)
	{
		quantity = entity.getQuantity();
	}
    
	public CustomerBean getPoster() {
		return poster;
	}

	public void setPoster(CustomerBean poster) {
        this.poster = poster;
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

}
