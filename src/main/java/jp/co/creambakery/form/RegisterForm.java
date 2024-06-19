package jp.co.creambakery.form;

/**
 * ユーザ登録するためのフォーム
 */
public class RegisterForm 
{
    private String name;
    private String reading;
    private String password;
    private String email;
    
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
