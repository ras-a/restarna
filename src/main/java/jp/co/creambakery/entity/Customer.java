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
 * customerテーブルのエンティティ
 * CREATE TABLE customer (
 * id INTEGER PRIMARY KEY,
 * name VARCHAR2(32 CHAR) NOT NULL,
 * -- 読み仮名
 * reading VARCHAR2(64 CHAR) NOT NULL,
 * password VARCHAR2(128) NOT NULL,
 * email VARCHAR2(64 CHAR) NOT NULL,
 * date_created DATE DEFAULT CURRENT_DATE,
 * deleted NUMBER(1) DEFAULT 0
 * );
 *
 * CREATE SEQUENCE customer_seq NOCACHE;
 */

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_gen")
    @SequenceGenerator(name = "costomer_gen", sequenceName = "customer_seq", allocationSize = 1)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String reading;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

}
