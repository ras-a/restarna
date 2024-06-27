package jp.co.creambakery.form;

import org.hibernate.validator.constraints.*;

import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotBlank;
import jp.co.creambakery.bean.*;
import jp.co.creambakery.entity.*;

public class CreditCardForm
{
	@NotBlank
	private String name;

	@NotNull
	@Pattern(regexp = "[a-zA-Z]+( [a-zA-Z]+)+")
	private String holderName;

	@CreditCardNumber
	private String no;

	@NotNull
	@Pattern(regexp = "\\d{3}")
	private String cvc;

	public void populateWith(CreditCardBean bean) {
		name = bean.getName();
		holderName = bean.getHolderName();
		
	}
	
	public void populate(CreditCard entity) {
		if (name != null)
			entity.setName(name);
		if (holderName != null)
			entity.setHolderName(holderName);
		if (no != null)
			entity.setNo(no);
		if (cvc != null)
			entity.setCvc(cvc);
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

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getCvc() {
		return cvc;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}
}
