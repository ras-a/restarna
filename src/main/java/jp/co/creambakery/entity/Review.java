package jp.co.creambakery.entity;

import jakarta.persistence.*;
import jp.co.creambakery.entity.keys.ReviewKey;

@Entity
@IdClass(ReviewKey.class)
@Table(name = "review")
public class Review
{
	@Id
	@ManyToOne
	@JoinColumn(name = "poster", referencedColumnName = "id")
	private Customer poster;
	@Id
	@ManyToOne
	@JoinColumn(name = "item", referencedColumnName = "id")
	private Item item;
	@Column
	private String description;
	@Column
	private Integer score;

	public Customer getPoster() {
		return poster;
	}
	public void setPoster(Customer poster) {
		this.poster = poster;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
}