package jp.co.creambakery.form;

public class OrderForm {
    private String name;
    private String homeAddress;
    private Integer phoneNumber;
    private String mailAddress;

    
    public String getName() {
        return name;
    }
    public String getHomeAddress() {
        return homeAddress;
    }
    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public String getMailAddress() {
        return mailAddress;
    }
    

    public void setName(String name) {
        this.name = name;
    }
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }
    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }


    
}
