package com.rajabhay.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Role_Table")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer roleId;
	private String roleName;
	
	@ManyToMany(mappedBy = "roles")
	List<User> users;
}
