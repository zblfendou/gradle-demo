package cn.shiro.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Administrator on 2016.4.28.
 */
@Entity
public class User implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	private String loginName;
	private String password;
	@ManyToMany (fetch = FetchType.EAGER)
	@JoinTable (joinColumns = @JoinColumn (name = "user"), inverseJoinColumns = @JoinColumn (name = "role"))
	private Set<Role> roles;
	@JsonIgnore
	private String securitySalt = UUID.randomUUID ().toString ();

	private Boolean locked;

	public User (Boolean locked) {
		this.locked = locked;
	}

	public User () {

	}

	public long getId () {
		return id;
	}

	public void setId (long id) {
		this.id = id;
	}

	public String getLoginName () {
		return loginName;
	}

	public void setLoginName (String loginName) {
		this.loginName = loginName;
	}

	public String getPassword () {
		return password;
	}

	public void setPassword (String password) {
		this.password = password;
	}

	public Set<Role> getRoles () {
		return roles;
	}

	public void setRoles (Set<Role> roles) {
		this.roles = roles;
	}

	public String getSecuritySalt () {
		return securitySalt;
	}

	public void setSecuritySalt (String securitySalt) {
		this.securitySalt = securitySalt;
	}

	public Boolean getLocked () {
		return locked;
	}
}
