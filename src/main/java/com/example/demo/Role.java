package com.example.demo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 角色实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="role")
public class Role {
	@Id
	@Column(name="role_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;	//角色Id
	
	@Column(name="role_type")
	private String type;	//admin角色,user角色

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
