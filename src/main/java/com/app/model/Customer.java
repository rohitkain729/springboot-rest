package com.app.model;

import java.util.List;
import java.util.Map;
import java.util.Set;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Entity
@Builder
@RequiredArgsConstructor
public class Customer {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@NonNull
	private Integer cno;
	@NonNull
	private String cname;
	@NonNull
	private String cadd;
	@NonNull
	private Float billAmt;
	
	private List<String> friends;

	private Set<Long> phones;
	
	private Map<String, Object> idDetails;
	
	private Company company;

}
