package jp.co.creambakery.bean;

import jp.co.creambakery.entity.*;

/**
 * ReviewBean
 */
public class ReviewBean
{
	private CustomerBean poster;
	private ItemBean item;
	private String description;
	private Integer score;

	ReviewBean(Review entity)
	{
		description = entity.getDescription();
		score = entity.getScore();
	}

	public CustomerBean getPoster() {
		return poster;
	}

	public void setPoster(CustomerBean poster) {
		this.poster = poster;
	}

	public ItemBean getItem() {
		return item;
	}

	public void setItem(ItemBean item) {
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