package com.springjms.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2016.4.21.
 */
@Entity
public class User {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	@Basic
	private String name;
	@Basic
	private String address;
	@Basic
	@Temporal (TemporalType.TIMESTAMP)
	private Date birthday;

	public User () {
	}

	public String getName () {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}

	public String getAddress () {
		return address;
	}

	public void setAddress (String address) {
		this.address = address;
	}

	public Date getBirthday () {
		return birthday;
	}

	public void setBirthday (Date birthday) {
		this.birthday = birthday;
	}

	public long getId () {
		return id;
	}

	public void setId (long id) {
		this.id = id;
	}

	public User (String name, String address, Date birthday) {
		this.name = name;
		this.address = address;
		this.birthday = birthday;
	}
}
