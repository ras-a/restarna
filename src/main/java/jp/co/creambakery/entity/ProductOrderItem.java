package jp.co.creambakery.entity;

import java.io.Serializable;

import jakarta.persistence.*;

/**-- 注文の商品項目
*CREATE TABLE product_order_item (
*	product_order INTEGER REFERENCES product_order(id) NOT NULL,
*	item INTEGER REFERENCES item(id) NOT NULL,
*	amount INTEGER CHECK (amount > 0),
*	CONSTRAINT pk PRIMARY KEY (product_order, item)
*);
*/

@Entity
@IdClass(ProductOrderItemKey.class)
@Table(name = "product_order_item")
public class ProductOrderItem 
{
    @Id
    @ManyToOne
    @JoinColumn(name = "product_order", referencedColumnName = "id", nullable = false)
    private ProductOrder productOrder;

    @Id
    @ManyToOne
    @JoinColumn(name = "item", referencedColumnName = "id", nullable = false)
    private Item item;

    @Column(nullable = false)
    private Integer amount;
    

    public ProductOrder getProductOrder() {
        return productOrder;
    }

    public Item getItem() {
        return item;
    }

    public Integer getAmount() {
        return amount;
    }


    public void setProductOrder(ProductOrder productOrder) {
        this.productOrder = productOrder;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}

class ProductOrderItemKey implements Serializable {
    private ProductOrder productOrder;
    private Item item;

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

    ProductOrderItemKey(ProductOrder productOrder, Item item) {
        this.productOrder = productOrder;
        this.item = item;
    }

	@Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ProductOrderItemKey))
            return false;
        var other = (ProductOrderItemKey) obj;

        return productOrder.equals(other.productOrder) && item.equals(other.item);
    }
}