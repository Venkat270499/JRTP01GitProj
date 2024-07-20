package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.PlanCategoryTable;

public interface IPlanCategoryRepo extends JpaRepository<PlanCategoryTable, Integer> {

}
