package com.app.controller;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "emp101")
@Data
@Entity
public class Employee {
	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "ename")
	private String ename;
}
