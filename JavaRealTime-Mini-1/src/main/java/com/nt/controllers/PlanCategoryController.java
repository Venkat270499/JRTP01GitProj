package com.nt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.PlanCategoryTable;
import com.nt.service.ServicePlanCategory;

import jakarta.validation.ReportAsSingleViolation;


@RestController
@RequestMapping("/plan/category")
public class PlanCategoryController {
	
	@Autowired
	ServicePlanCategory spc;
	
	@PostMapping("/register")
	public ResponseEntity<?> registerPlan(@RequestBody PlanCategoryTable pct) {
		System.out.println(pct);
			String s=spc.register(pct);
		
		return new ResponseEntity<String>(s,HttpStatus.OK) ;
	}
	@PutMapping("/update")
	public ResponseEntity<?> updatePlan(@RequestBody PlanCategoryTable pct2) {
		String s=spc.updatePlan(pct2);
		
		return	new ResponseEntity<String>(s,HttpStatus.OK);
	}
		
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		PlanCategoryTable p=spc.findPlanById(id);
		
		return	new ResponseEntity<PlanCategoryTable>(p,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePlan(@PathVariable Integer id) {
		String s=spc.deletePlan(id);
		
		return	new ResponseEntity<String>(s,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> viewAllPlans(){
		List<PlanCategoryTable> lst=spc.displayAllPlans();
		return new ResponseEntity<List<PlanCategoryTable>>(lst,HttpStatus.OK);
	}
	
}
