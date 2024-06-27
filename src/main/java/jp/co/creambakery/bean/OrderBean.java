package jp.co.creambakery.bean;

import java.io.*;
import java.util.*;

import jp.co.creambakery.entity.*;

public class OrderBean implements Serializable
{
	private Integer id;
	private UserBean user;
	private Integer paymentMethod;
	private CreditCardBean creditCard;
	private Date dateCreated;
	private Boolean cancelled;
	private AddressBean address;
	private String optionalDetails;
	private List<OrderItemBean> items;
	private Date completed;

	public OrderBean() {}

	public OrderBean(ProductOrder entity)
	{
		id = entity.getId();
		paymentMethod = entity.getPaymentMethod();
		dateCreated = entity.getDateCreated();
		cancelled = entity.getCancelled() != 0;
		optionalDetails = entity.getOptionalDetails();
		completed = entity.getCompleted();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	public Integer getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(Integer paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public CreditCardBean getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCardBean creditCard) {
		this.creditCard = creditCard;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Boolean getCancelled() {
		return cancelled;
	}

	public void setCancelled(Boolean cancelled) {
		this.cancelled = cancelled;
	}

	public AddressBean getAddress() {
		return address;
	}

	public void setAddress(AddressBean address) {
		this.address = address;
	}

	public String getOptionalDetails() {
		return optionalDetails;
	}

	public void setOptionalDetails(String optionalDetails) {
		this.optionalDetails = optionalDetails;
	}

	public Date getCompleted() {
		return completed;
	}

	public void setCompleted(Date completed) {
		this.completed = completed;
	}
	
	public Integer getPrice() {
		return items.stream().reduce(0, (val, i) -> val + i.getPrice(), (a,b) -> a + b);
	}

	public List<OrderItemBean> getItems() {
		return items;
	}

	public void setItems(List<OrderItemBean> items) {
		this.items = items;
	}
}
