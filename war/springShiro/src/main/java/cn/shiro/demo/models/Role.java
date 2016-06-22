package cn.shiro.demo.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Administrator on 2016.4.28.
 */
@Entity
public class Role implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	private String name;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(joinColumns=@JoinColumn(name = "role"),inverseJoinColumns = @JoinColumn(name = "perm"))
	private Set<Permission> permissions;

	public long getId () {
		return id;
	}

	public void setId (long id) {
		this.id = id;
	}

	public String getName () {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}

	public Set<Permission> getPermissions () {
		return permissions;
	}

	public void setPermissions (Set<Permission> permissions) {
		this.permissions = permissions;
	}

	public Role () {

	}
}
