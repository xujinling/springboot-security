package com.example.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 学生实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="student")
public class Student implements UserDetails {

	private static final long serialVersionUID = 3538715626741949867L;

	@Id
	@Column(name="stu_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;	//学生id
	@Column(name="stu_sname")
	private String sname;	//学生姓名
	@Column(name="stu_spwd")
	private String spwd;	//学生密码
	/*
	 * 学生角色多对多映射
	 */
	@ManyToMany(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinTable(name="stu_role",joinColumns=@JoinColumn(name="stu_id"),
		inverseJoinColumns=@JoinColumn(name="role_id"))
	private List<Role> roles;
	
	public Student(){
		
	}
	
	public Student(int id, String sname, String spwd) {
		this.id = id;
		this.sname = sname;
		this.spwd = spwd;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSpwd() {
		return spwd;
	}
	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	/*
	 *	将用户的角色作为权限 
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Role> lists=this.getRoles();
		List<GrantedAuthority> gas=new ArrayList<>();
		for(Role role:lists){
			System.out.println("-----------------------"+role.getType());
			gas.add(new SimpleGrantedAuthority(role.getType()));
		}
		return gas;
	}

	@Override
	public String getPassword() {
		return this.getSpwd();
	}

	@Override
	public String getUsername() {
		return this.getSname();
	}

	//账户是否过期
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	//账户是否被锁定
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	//判断用户凭证是否过期
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	//是否授权
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
	
}
