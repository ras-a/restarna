package jp.co.creambakery.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**-- パン生地の種類
*CREATE TABLE bread (
*	id INTEGER PRIMARY KEY,
*	name VARCHAR2(32 CHAR) NOT NULL,
*	-- 読み仮名
*	reading VARCHAR2(64 CHAR) NOT NULL,
*	price INTEGER NOT NULL,
*	description VARCHAR2(128 CHAR) NOT NULL,
*	image VARCHAR2(64 CHAR) NOT NULL,
*	date_created DATE DEFAULT CURRENT_DATE,
*	deleted NUMBER(1) DEFAULT 0
*);
*/

@Entity
@Table(name = "bread")
public class Bread 
{
    @Id
    @GeneratedValue(strategy = GenerationType. SEQUENCE, generator = "seq_bread_gen")
    @SequenceGenerator(name = "seq_bread_gen", sequenceName = "bread_seq", allocationSize = 1)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String reading;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private Date dateCreated;

    @Column(nullable = false, columnDefinition = "Integer default 0")
    private Integer deleted;


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

    public String getImage() 
    {
        return image;
    }

    public Date getDateCreated() 
    {
        return dateCreated;
    }

    public Integer getDeleted() 
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

    public void setImage(String image) 
    {
        this.image = image;
    }

    public void setDateCreated(Date dateCreated) 
    {
        this.dateCreated = dateCreated;
    }

    public void setDeleted(Integer deleted) 
    {
        this.deleted = deleted;
    }
}
