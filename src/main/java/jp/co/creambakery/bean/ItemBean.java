package jp.co.creambakery.bean;

import java.io.Serializable;
import java.util.*;

import jp.co.creambakery.entity.*;

public class ItemBean implements Serializable
{
    private Integer id;
    private String name;
    private String reading;
    private BreadBean bread;
    private List<CreamBean> creams;
    private Date dateCreated;
    private String description;
    private Boolean deleted;
    private List<ReviewBean> reviews;

    ItemBean(Item entity) {
        id = entity.getId();
        name = entity.getName();
        reading = entity.getReading();
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

	public BreadBean getBread() {
		return bread;
	}

	public void setBread(BreadBean bread) {
		this.bread = bread;
	}

	public List<CreamBean> getCreams() {
		return creams;
	}

	public void setCreams(List<CreamBean> creams) {
		this.creams = creams;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public List<ReviewBean> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewBean> reviews) {
		this.reviews = reviews;
	}

    public Integer getPrice() {
        var sum = bread.getPrice();

        for (var cream: creams)
        {
            sum += cream.getPrice();
        }

        return sum;
    }
}
