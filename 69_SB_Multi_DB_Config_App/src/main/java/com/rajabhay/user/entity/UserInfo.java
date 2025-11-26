package com.rajabhay.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "UserInfo_Tbl")
@Entity
public class UserInfo {

	@Id
	private Integer id;
	private String name;
}

