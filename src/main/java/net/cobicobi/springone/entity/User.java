package net.cobicobi.springone.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="user_data")
@NamedQuery(name="User.findByName", query = "select u from User u where u.username = :username")
public class User {
	
	@Id
	@GeneratedValue
	@Column
	private Long id;
	
	@Column(length=32, unique=true)
	private String username;

	@Column(length=40, nullable=true)
	private String password;
	
	@Column(length=100)
	private String name;
	
	@ManyToMany
	@JoinTable(name = "user_role",
	joinColumns =  @JoinColumn(name = "user_id"),
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<Role>();
	
	public Long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean addRole(Role role) {
		return roles.add(role);
	}
	public Set<Role> getRoles() {
		return roles;
	}
}
