package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.PlanCategoryTable;
import com.nt.repository.IPlanCategoryRepo;

@Service
public class ServicePlanCategory implements IServicePlanCategory {
	
	@Autowired
	IPlanCategoryRepo repo;
	
	

	@Override
	public String register(PlanCategoryTable pct) {
		// TODO Auto-generated method stub
		PlanCategoryTable plancat=repo.save(pct);
		return plancat!=null?"Plan Saved sucessfully id"+plancat.getPlanid():"No such plan"; 
	}

	@Override
	public PlanCategoryTable findPlanById(Integer id) {
		// TODO Auto-generated method stub
		Optional<PlanCategoryTable> op=repo.findById(id);		
		return op.get();
	}

	@Override
	public List<PlanCategoryTable> displayAllPlans() {
		// TODO Auto-generated method stub
		List<PlanCategoryTable> lst=new ArrayList<>();
		lst=repo.findAll();
		return lst;
	}

	@Override
	public String updatePlan(PlanCategoryTable pct) {
		// TODO Auto-generated method stub
		Optional<PlanCategoryTable> op=repo.findById(pct.getPlanid());
		int id=repo.save(op.get()).getPlanid();
		return "updated the plan sucessfully with id "+id;
	}

	@Override
	public String deletePlan(Integer id) {
		// TODO Auto-generated method stub
		Optional<PlanCategoryTable> op=repo.findById(id);
		repo.deleteById(op.get().getPlanid());
		
		return "Deleted the plan sucessfully with id "+op.get().getPlanid();
	}

}
