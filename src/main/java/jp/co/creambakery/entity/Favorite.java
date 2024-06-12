package jp.co.creambakery.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * favoriteテーブルのエンティティ
 * -- 会員のお気に入り登録
 * CREATE TABLE favorite (
 * owner INTEGER REFERENCES customer(id),
 * item INTEGER REFERENCES item(id),
 * CONSTRAINT pk_fav PRIMARY KEY (owner, item)
 * );
 * 
 */

@Entity
@Table(name = "favorite")
public class Favorite {

    @Id
    @ManyToOne
    @JoinColumn(name = "customer", referencedColumnName = "id")
    private Customer owner;

    @Id
    @ManyToOne
    @JoinColumn(name = "item", referencedColumnName = "id")
    private Item item;

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
