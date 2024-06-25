package jp.co.creambakery.form;

public class CreamForm {

    private String name;
    
    private String reading;

    private Integer price;

    private String description;

    private Boolean deleted;

    public String getName() 
    {
        return name;
    }

    public String getReading() 
    {
        return reading;
    }

    public Integer getPrice() 
    {
        return price;
    }

    public String getDescription() 
    {
        return description;
    }

    public Boolean getDeleted() 
    {
        return deleted;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public void setReading(String reading) 
    {
        this.reading = reading;
    }

    public void setPrice(Integer price) 
    {
        this.price = price;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public void setDeleted(Boolean deleted) 
    {
        this.deleted = deleted;
    }
}