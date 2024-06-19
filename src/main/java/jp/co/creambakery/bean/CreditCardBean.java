package jp.co.creambakery.bean;

import java.io.*;

import jp.co.creambakery.entity.*;

/**
 * CreditCardBean
 */
public class CreditCardBean implements Serializable
{
	private Integer id;
	private CustomerBean owner;
	private String name;
	private String holderName;
	private String number;
	private String cvc;

	CreditCardBean(CreditCard entity)
	{
		id = entity.getId();
		name = entity.getName();
		holderName = entity.getHolderName();
		number = entity.getNo();
		cvc = entity.getCvc();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CustomerBean getOwner() {
		return owner;
	}

	public void setOwner(CustomerBean owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCvc() {
		return cvc;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}
}