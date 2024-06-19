package jp.co.creambakery.bean;

import java.io.*;
import java.util.Date;
import jp.co.creambakery.entity.*;

/**
 * BreadBean
 */
public class BreadBean implements Serializable
{
	public Integer id;
	public String name;
	public String reading;
	public Integer price;
	public String description;
	public String image;
	public Date dateCreated;
	public Boolean deleted;

	BreadBean(Bread entity)
	{
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

	public void setDescription(String description) {
		this.description = description;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setReading(String reading) {
		this.reading = reading;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getReading() {
		return reading;
	}

	public Integer getPrice() {
		return price;
	}
    
	public String getDescription() {
		return description;
	}

	public String getImage() {
		return image;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public Boolean isDeleted() {
		return deleted;
	}
}