package jp.co.creambakery.entity;

import jakarta.persistence.*;

/** 
*-- 既存の(店の)商品
*CREATE TABLE store_item (
*	item INTEGER PRIMARY KEY REFERENCES item(id),
*	image VARCHAR2(64 CHAR) NOT NULL
*);
*/

@Entity
@Table(name = "store_item")
public class StoreItem 
{
    @Id
    @OneToOne
    private Item item;

    @Column(nullable = false)
    private String image;

    public Item getItem() {
        return item;
    }

    public String getImage() {
        return image;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
