package jp.co.creambakery.form;

import jakarta.validation.constraints.*;
import jp.co.creambakery.bean.*;
import jp.co.creambakery.entity.*;

/**
 * ユーザ情報を編集する時の入力フォーム
 */
public class UserEditForm 
{
    @NotBlank
    private String name;
    @NotBlank
    private String reading;
    @NotBlank
    private String password;
    @Email
    private String email;

    	public void populateWith(UserBean bean)
	{
		name = bean.getName();
		reading = bean.getReading();
		password = bean.getPassword();
		email = bean.getEmail();
	}

	public void populate(User entity)
	{
		if (name != null)
			entity.setName(name);
		if (reading != null)
			entity.setReading(reading);;
		if (password != null)
			entity.setPassword(password);
		if (email != null)
			entity.setEmail(email);
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
}
