package jp.co.creambakery.form;

import org.hibernate.validator.constraints.*;

import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotBlank;

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
