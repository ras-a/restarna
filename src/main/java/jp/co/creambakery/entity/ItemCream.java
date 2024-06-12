package jp.co.creambakery.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * item_creamテーブルのエンティティ
 * CREATE TABLE item_cream (
 * item INTEGER REFERENCES item(id),
 * cream INTEGER REFERENCES cream(id),
 * CONSTRAINT pk_ic PRIMARY KEY (item, cream)
 * );
 */

@Entity
@Table(name = "item_cream")
public class ItemCream {

    @ManyToOne
    @JoinColumn(name = "item", referencedColumnName = "id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "cream", referencedColumnName = "id")
    private Cream cream;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Cream getCream() {
        return cream;
    }

    public void setCream(Cream cream) {
        this.cream = cream;
    }

}
