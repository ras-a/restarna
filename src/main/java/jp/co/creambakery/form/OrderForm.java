package jp.co.creambakery.form;

import jp.co.creambakery.entity.*;

public class OrderForm {
    
    private Integer paymentMethod;
    private CreditCard creditCard;
    private AddressProfile address;
    private String optionalDetails;
    public Integer getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(Integer paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public CreditCard getCreditCard() {
        return creditCard;
    }
    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }
    public AddressProfile getAddress() {
        return address;
    }
    public void setAddress(AddressProfile address) {
        this.address = address;
    }
    public String getOptionalDetails() {
        return optionalDetails;
    }
    public void setOptionalDetails(String optionalDetails) {
        this.optionalDetails = optionalDetails;
    }

}
