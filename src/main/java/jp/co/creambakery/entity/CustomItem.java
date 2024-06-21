package jp.co.creambakery.entity;

import jakarta.persistence.*;

/**
 * custom_itemテーブルのエンティティ
 * CREATE TABLE custom_item (
 * item INTEGER PRIMARY KEY REFERENCES item(id) NOT NULL,
 * creator INTEGER REFERENCES customer(id) NOT NULL,
 * -- 公開済か否か
 * is_public NUMBER(1) DEFAULT 0
 * );
 */

@Entity
@Table(name = "custom_item")
public class CustomItem
{
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item", referencedColumnName = "id", nullable = false)
    private Item item;

    @ManyToOne
    @JoinColumn(name = "creator", referencedColumnName = "id", nullable = false)
    private User creator;

    @Column(columnDefinition = "NUMBER(1) DEFAULT 0")
    private Integer isPublic = 0;

    public CustomItem() {
        isPublic = 0;
    }

    public CustomItem(User user, Item item) {
        creator = user;
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Integer getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Integer isPublic) {
        this.isPublic = isPublic;
    }

}
