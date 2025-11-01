package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actor {

	private Integer id;
	private String name;
	private String addrs;
	private Double fee;
	private String category;
}
