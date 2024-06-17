package jp.co.creambakery.bean;

import java.util.*;

import jp.co.creambakery.entity.*;

/**
 * CreamBean
 */
public class CreamBean
{
	private Integer id;
	private String name;
	private String reading;
	private Integer price;
	private String description;
	private String image;
	private Date dateCreated;
	private Boolean deleted;

	CreamBean(Cream entity) {
		id = entity.getId();
		name = entity.getName();
		reading = entity.getReading();
		price = entity.getPrice();
		description = entity.getDescription();
		image = entity.getImage();
		dateCreated = entity.getDateCreated();
		deleted = entity.getDeleted() != 0;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReading() {
		return reading;
	}

	public void setReading(String reading) {
		this.reading = reading;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
}