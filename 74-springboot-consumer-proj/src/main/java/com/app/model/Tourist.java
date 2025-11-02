package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RequiredArgsConstructor
public class Tourist {

	private Integer tid;

	@NonNull
	private String tname;

	@NonNull
	private String taddrs;

	@NonNull
	private String plan;
	@NonNull
	private Double budget;
}
