package com.demo.models;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户实体
 * Created by Administrator on 2016.1.29.
 */
@Entity
public class User extends BaseModel {
	@Basic
	private String name;
	@Basic
	private int age;
	@Basic
	@Temporal (TemporalType.DATE)
	private Date birthday;
	@Basic
	private boolean sex;
	@Basic
	private String address;

	public User (String name, int age, Date birthday, boolean sex, String address) {

		this.name = name;
		this.age = age;
		this.birthday = birthday;
		this.sex = sex;
		this.address = address;
	}

	public User () {

	}

	public String getName () {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}

	public int getAge () {
		return age;
	}

	public void setAge (int age) {
		this.age = age;
	}

	public Date getBirthday () {
		return birthday;
	}

	public void setBirthday (Date birthday) {
		this.birthday = birthday;
	}

	public boolean isSex () {
		return sex;
	}

	public void setSex (boolean sex) {
		this.sex = sex;
	}

	public String getAddress () {
		return address;
	}

	public void setAddress (String address) {
		this.address = address;
	}
}
