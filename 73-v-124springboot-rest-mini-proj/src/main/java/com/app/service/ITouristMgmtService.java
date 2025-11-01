package com.app.service;

import java.util.List;

import com.app.entity.Tourist;

public interface ITouristMgmtService {

	public String registerTourist(Tourist t);

	public List<Tourist> getAllTourist();

	public Tourist showTouristById(Integer id);

	public String updateTourist(Tourist t);

	public String deleteTouristById(Integer id);
	
	public String updateTouristBudgetById(Integer id,double hikePercentage);
}
