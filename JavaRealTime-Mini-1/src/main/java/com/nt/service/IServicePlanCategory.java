package com.nt.service;

import java.util.List;

import com.nt.model.PlanCategoryTable;

public interface IServicePlanCategory {

	public String register(PlanCategoryTable pct);
	public PlanCategoryTable findPlanById(Integer id);
	public List<PlanCategoryTable> displayAllPlans();
	public String updatePlan(PlanCategoryTable pct);
	public String deletePlan(Integer id); 
	
}
