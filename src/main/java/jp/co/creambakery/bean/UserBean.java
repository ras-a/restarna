package jp.co.creambakery.bean;

import java.io.*;
import java.util.*;

import jp.co.creambakery.entity.*;

/**
 * UserBean
 */
public class UserBean implements Serializable
{
	private Integer id;
	private String name;
	private String reading;
	private String password;
	private List<AddressBean> addresses;
	private List<CreditCardBean> creditCards;
	private Integer mainAddress;
	private String email;
	private List<ItemBean> favorites;
	private List<ReviewBean> reviews;
	private Date dateCreated;
	private Boolean deleted;
	private List<CartBean> cart;
	private List<OrderBean> orders;
	private List<CustomItemBean> createdItems;

	public UserBean(User entity) {
		id = entity.getId();
		name = entity.getName();
		reading = entity.getReading();
		password = entity.getPassword();
		email = entity.getEmail();
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<AddressBean> getAddresses() {
		return addresses;
	}

	public AddressBean getAddress(Integer id)
	{
		AddressBean out = null;
		for (var address: addresses)
		{
			if (address.getId() == id)
			{
				out = address;
			}
		}

		return out;
	}

	public void setAddresses(List<AddressBean> addresses) {
		this.addresses = addresses;
	}

	public List<CreditCardBean> getCreditCards() {
		return creditCards;
	}

	public CreditCardBean getCreditCard(Integer id)
	{
		CreditCardBean out = null;
		for (var card: creditCards)
		{
			if (card.getId() == id)
			{
				out = card;
			}
		}

		return out;
	}

	public void setCreditCards(List<CreditCardBean> creditCards) {
		this.creditCards = creditCards;
	}

	public Integer getMainAddress() {
		return mainAddress;
	}

	public void setMainAddress(Integer mainAddress) {
		this.mainAddress = mainAddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<ItemBean> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<ItemBean> favorites) {
		this.favorites = favorites;
	}

	public List<ReviewBean> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewBean> reviews) {
		this.reviews = reviews;
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

	public List<CartBean> getCart() {
		return cart;
	}

	public void setCart(List<CartBean> cart) {
		this.cart = cart;
	}

	public List<OrderBean> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderBean> orders) {
		this.orders = orders;
	}
	public List<CustomItemBean> getCreatedItems() {
		return createdItems;
	}

	public void setCreatedItems(List<CustomItemBean> createdItems) {
		this.createdItems = createdItems;
	}
}