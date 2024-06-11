package jp.co.creambakery.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**-- 注文の商品項目
*CREATE TABLE product_order_item (
*	product_order INTEGER REFERENCES product_order(id) NOT NULL,
*	item INTEGER REFERENCES item(id) NOT NULL,
*	amount INTEGER CHECK (amount > 0),
*	CONSTRAINT pk PRIMARY KEY (product_order, item)
*);
*/

@Entity
@Table(name = "product_order_item")
public class ProductOrderItem 
{
    @ManyToOne
    @JoinColumn(name = "product_order", referencedColumnName = "id")
    private ProductOrder productOrder;

    @JoinColumn(name = "item", referencedColumnName = "id")
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
