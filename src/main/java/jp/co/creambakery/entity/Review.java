package jp.co.creambakery.entity;

import java.io.*;
import java.util.*;

import jakarta.persistence.*;
import jp.co.creambakery.entity.keys.*;

@Entity
@IdClass(ReviewKey.class)
@Table(name = "review")
public class Review implements Serializable
{
	@Id
	@ManyToOne
	@JoinColumn(name = "poster", referencedColumnName = "id")
	private User poster;
	@Id
	@ManyToOne
	@JoinColumn(name = "item", referencedColumnName = "id")
	private Item item;
	@Column
	private String description;
	@Column
	private Integer score;

	@Column(columnDefinition = "NUMBER(1) DEFAULT 0")
	private Integer deleted;

	@Column(nullable = false)
	private Date dateCreated;

	public Review()
	{
		dateCreated = new Date();
	}

	public Review(Item item, User poster, Integer score, String description)
	{
		this();
		this.item = item;
		this.poster = poster;
		this.score = score;
		this.description = description;
	}

	public User getPoster() {
		return poster;
	}
	public void setPoster(User poster) {
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
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Review && poster == ((Review)obj).getPoster() && item == ((Review)obj).getItem();
	}
}