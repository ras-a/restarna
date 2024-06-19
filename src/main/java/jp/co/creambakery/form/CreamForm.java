package jp.co.creambakery.form;

public class CreamForm {
    
    private Integer id;

    private String name;
    
    private String reading;

    private Integer price;

    private String description;

    private Boolean deleted;

    public Integer getId() 
    {
        return id;
    }

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

    public void setId(Integer id) 
    {
        this.id = id;
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