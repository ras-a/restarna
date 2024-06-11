package jp.co.creambakery.entity;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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

@ManyToOne
@JoinColumn(name = "item", referencedColumnName = "id")
private Item storeIt;

@Column
private String image;

public Item getStoreIt() {
    return storeIt;
}

public String getImage() {
    return image;
}

public void setStoreIt(Item storeIt) {
    this.storeIt = storeIt;
}

public void setImage(String image) {
    this.image = image;
}

}
