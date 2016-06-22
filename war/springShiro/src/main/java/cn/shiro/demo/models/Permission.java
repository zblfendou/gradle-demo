package cn.shiro.demo.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2016.4.28.
 */
@Entity
public class Permission implements Serializable {
	@Id
	private String perm;
	private String name;

	public String getPerm () {
		return perm;
	}

	public void setPerm (String perm) {
		this.perm = perm;
	}

	public String getName () {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}

	public Permission () {

	}
}
