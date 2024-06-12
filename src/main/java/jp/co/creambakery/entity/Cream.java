package jp.co.creambakery.entity;

import java.util.Date;

import jakarta.persistence.*;

/**
 * creamテーブルのエンティティ
 * CREATE TABLE cream (
 * id INTEGER PRIMARY KEY,
 * name VARCHAR2(32 CHAR) NOT NULL,
 * reading VARCHAR2(64 CHAR) NOT NULL,
 * price INTEGER NOT NULL,
 * description VARCHAR2(128 CHAR) NOT NULL,
 * image VARCHAR2(64 CHAR) NOT NULL,
 * date_created DATE DEFAULT CURRENT_DATE,
 * deleted NUMBER(1) DEFAULT 0
 * );
 * CREATE SEQUENCE cream_seq NOCACHE;
 */

@Entity
@Table(name = "cream")
public class Cream {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cream_gen")
    @SequenceGenerator(name = "cream_gen", sequenceName = "cream_seq", allocationSize = 1)
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

    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date date_created;

    @Column(columnDefinition = "NUMBER(1) DEFAULT 0")
    private Integer deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}
