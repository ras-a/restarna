package jp.co.creambakery.entity;

import java.io.*;
import java.util.*;

import jakarta.persistence.*;

/**
*-- 管理者
*CREATE TABLE admin (
*	id INTEGER PRIMARY KEY,
*	name VARCHAR2(16 CHAR),
*	password VARCHAR2(32),
*	date_created DATE DEFAULT CURRENT_DATE,
*	system NUMBER(1) DEFAULT 0
*);
*/

@Entity
@Table(name = "admin")
public class Admin  implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType. SEQUENCE, generator = "seq_admin_gen")
    @SequenceGenerator(name = "seq_admin_gen", sequenceName = "admin_seq", allocationSize = 1)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date dateCreated;

    @Column(nullable = false, columnDefinition = "NUMBER(1) DEFAULT 0")
    private Integer system;

    
    public Integer getId()
    {
        return id;
    }

    public String getName() 
    {
        return name;
    }

    public String getPassword() 
    {
        return password;
    }

    public Date getDateCreated() 
    {
        return dateCreated;
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

    public void setPassword(String password) 
    {
        this.password = password;
    }

    public void setDateCreated(Date dateCreated) 
    {
        this.dateCreated = dateCreated;
    }

    public void setSystem(Integer system) 
    {
        this.system = system;
    }

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Admin && id == ((Admin)obj).getId();
	}
}
