package jp.co.creambakery.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * 
   * -- パン生地の種類
    CREATE TABLE bread (
    id INTEGER PRIMARY KEY,
    name V
    -- 読み仮名
    reading VARCHAR2(64 CH
    price INTEGER NOT NULL,
    description VARCHAR2(128 CHAR) N
    image VARCHAR2(64 CHAR) NOT NULL,
    date_created DATE DEFAULT 
   * 
  * );
 */

@Entity
@Table(name = "bre public class Bread {
    @Id
    @GeneratedValue(strategy = GenerationType.EQUENCE, generator = "seq_bread_gen")
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

        return id; }

    public String getName() {
        return name;
    } 
    public String getReading() {
        return reading;
    }
 public Integer getPrice() {
        return price;
    }

    public String getDescript     return description;
    }

    public String getImage() {
        return image; }

    public Date getDateCreated() {
        return dateCreated;
    } 
    public Integer getDeleted() {
        return deleted;
    }
 public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String      this.name = name;
    }


    } 
    public void setPrice(Integer price) {
        this.price = price;
    }
 public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {     this.image = image;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated; }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    } 
   