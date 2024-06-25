package jp.co.creambakery.entity;

import java.io.*;

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
public class StoreItem implements Serializable
{
    @Id
    @OneToOne
    @MapsId
    @JoinColumn(name = "item", referencedColumnName = "id", nullable = false)
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

	@Override
	public boolean equals(Object obj) {
		return obj instanceof StoreItem && item == ((StoreItem)obj).getItem();
	}
}
