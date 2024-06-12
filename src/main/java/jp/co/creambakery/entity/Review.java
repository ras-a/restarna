package jp.co.creambakery.entity;

import java.io.Serializable;

import jakarta.persistence.*;

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

class ReviewKey implements Serializable
{
	private Customer poster;
	private Item item;

	ReviewKey(Customer poster, Item item) {
		this.poster = poster;
		this.item = item;
	}

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

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ReviewKey))
			return false;

		var other = (ReviewKey) obj;

		return poster.equals(other.poster) && item.equals(other.item);
	}
}