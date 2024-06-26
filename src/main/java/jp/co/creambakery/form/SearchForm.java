package jp.co.creambakery.form;

import java.util.*;
import jp.co.creambakery.entity.*;

public class SearchForm {
	private String name;
	private Bread bread;
	private List<Cream> creams;
	private Integer sortBy;
	private Boolean asc;

	public SearchForm()
	{
		creams = new ArrayList<>();
		sortBy = 0;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Bread getBread() {
		return bread;
	}
	public void setBread(Bread bread) {
		this.bread = bread;
	}
	public List<Cream> getCreams() {
		return creams;
	}
	public void setCreams(List<Cream> creams) {
		this.creams = creams;
	}
	public Integer getSortBy() {
		return sortBy;
	}
	public void setSortBy(Integer sortBy) {
		this.sortBy = sortBy;
	}
	public Boolean getAsc() {
		return asc;
	}
	public void setAsc(Boolean asc) {
		this.asc = asc;
	}
}
