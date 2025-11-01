package com.app.model;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Actor {

	private Integer id;
	private String name;
	private String addrs;
	private Double fee;
	private String category;
}
