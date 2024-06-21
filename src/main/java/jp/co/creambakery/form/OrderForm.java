package jp.co.creambakery.form;

public class OrderForm {
    
    private Integer paymentMethod;
    private Integer creditCard;
    private Integer address;
    private String optionalDetails;
    public Integer getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(Integer paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public Integer getCreditCard() {
        return creditCard;
    }
    public void setCreditCard(Integer creditCard) {
        this.creditCard = creditCard;
    }
    public Integer getAddress() {
        return address;
    }
    public void setAddress(Integer address) {
        this.address = address;
    }
    public String getOptionalDetails() {
        return optionalDetails;
    }
    public void setOptionalDetails(String optionalDetails) {
        this.optionalDetails = optionalDetails;
    }

}
