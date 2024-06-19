package jp.co.creambakery.bean;

import java.io.*;
import java.util.*;

import jp.co.creambakery.entity.*;

public class AdminBean implements Serializable
{
	private Integer id;
	private String name;
	private String password;
	private Date dateCreated;
	private Boolean system;

	public AdminBean (Admin entity)
	{
		id = entity.getId();
		name = entity.getName();
		password = entity.getPassword();
		dateCreated = entity.getDateCreated();
		system = entity.getSystem() != 0;
	}
	
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

	public Boolean getSystem()
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

	public void setSystem(Boolean system)
	{
		this.system = system;
	}
}
