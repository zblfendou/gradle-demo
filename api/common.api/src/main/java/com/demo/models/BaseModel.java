package com.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 数据实体基础模型
 * Created by Administrator on 2016.1.29.
 */
@MappedSuperclass
public class BaseModel implements Serializable {
	@Id
	@GeneratedValue
	private long id;
	@Version
	@JsonIgnore
	private long version;

	public long getId () {
		return id;
	}

	public void setId (long id) {
		this.id = id;
	}

	public long getVersion () {
		return version;
	}

	public void setVersion (long version) {
		this.version = version;
	}
}
