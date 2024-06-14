package jp.co.creambakery.form;
import jakarta.validation.constraints.*;
public class UserLoginForm
{
	private String email;
	@Pattern(regexp = "^[0-9a-zA-Z]+$")
	@Size(max = 16)
	private String password;

	public String getEmail()
    {
		return email;
	}

	public void setEmail(String email)
    {
		this.email = email;
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
