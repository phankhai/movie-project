package com.examplespringboot.demo.Entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.examplespringboot.demo.Entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "roles")
public class Role {
	@Id
	private String id;
	@NotBlank(message = "Tên Không Để Trống")
	private String name;
	@NotBlank(message = "Mô Tả Không Để Trống")
	private String description;
	
	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<User> users;
	
	public Role() {}
	public Role(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
