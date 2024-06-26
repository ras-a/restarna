package jp.co.creambakery.form;

import jakarta.validation.constraints.*;

public class CreamForm {
    @NotBlank
    @Size(max = 100)
    private String name;
    @NotBlank
    @Size(max = 100)
    private String reading;
    @NotNull
    private Integer price;
    @NotBlank
    @Size(max = 400)
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