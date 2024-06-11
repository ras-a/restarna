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
*-- 管理者
*CREATE TABLE admin (
*	id INTEGER PRIMARY KEY,
*	name VARCHAR2(16 CHAR),
*	password VARCHAR2(32),
*	date_created DATE DEFAULT CURRENT_DATE,
*	deleted NUMBER(1) DEFAULT 0,
*	system NUMBER(1) DEFAULT 0
*);
*/

@Entity
@Table(name = "admin")
public class Admin 
{
    @Id
    @GeneratedValue(strategy = GenerationType. SEQUENCE, generator = "seq_admin_gen")
    @SequenceGenerator(name = "seq_admin_gen", sequenceName = "admin_seq", allocationSize = 1)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String reading;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, columnDefinition = "CURRENT_DATE")
    private Date dateCreated;

    @Column(nullable = false, columnDefinition = "Integer default 0")
    private Integer deleted;

    @Column(nullable = false, columnDefinition = "Integer default 0")
    private Integer system;

    
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

    public String getPassword() 
    {
        return password;
    }

    public Date getDateCreated() 
    {
        return dateCreated;
    }

    public Integer getDeleted() 
    {
        return deleted;
    }
    
    public Integer getSystem() 
    {
        return system;
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

    public void setPassword(String password) 
    {
        this.password = password;
    }

    public void setDateCreated(Date dateCreated) 
    {
        this.dateCreated = dateCreated;
    }

    public void setDeleted(Integer deleted) 
    {
        this.deleted = deleted;
    }

    public void setSystem(Integer system) 
    {
        this.system = system;
    }

}
