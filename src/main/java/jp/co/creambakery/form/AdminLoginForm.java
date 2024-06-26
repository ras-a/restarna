package jp.co.creambakery.form;

import jakarta.validation.constraints.*;
public class AdminLoginForm {
	@NotBlank
	@Size(max = 100)
    private String name;
	@Pattern(regexp = "^[0-9a-zA-Z]+$")
	@Size(max = 16)
	private String password;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
}
