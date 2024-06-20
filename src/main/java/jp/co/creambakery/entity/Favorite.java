package jp.co.creambakery.entity;

import jakarta.persistence.*;
import jp.co.creambakery.entity.keys.*;

@Entity
@IdClass(FavoriteKey.class)
@Table(name = "favorite")
public class Favorite {

    @Id
	@ManyToOne
	@JoinColumn(name = "owner", referencedColumnName = "id")
	private User owner;

	@Id
	@ManyToOne
	@JoinColumn(name = "item", referencedColumnName = "id")
	private Item item;

    
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    


    
}
