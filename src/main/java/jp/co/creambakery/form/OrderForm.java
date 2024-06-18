package jp.co.creambakery.form;

public class OrderForm {
    private String name;
    private String address;
    private String postCode;
    private String email;

    
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getPostCode() {
        return postCode;
    }
    public String getEmail() {
        return email;
    }


    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    

}
