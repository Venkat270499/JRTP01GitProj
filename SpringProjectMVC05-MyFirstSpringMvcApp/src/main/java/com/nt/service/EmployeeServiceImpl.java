package com.nt.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repositories.IEmployeeRepo;

@Service
public class EmployeeServiceImpl  implements IEmployeeService {
	
	@Autowired
	IEmployeeRepo empRepo;
	
	@Override
	public List<Employee> findAllEmpdetails() {
		List<Employee> i=empRepo.findAll();
		return i;
	}

	@Override
	public String registerEmployee(Employee emp) {
		Employee emp1=empRepo.save(emp);
		return "Employee saved succesfully with emp no"+emp1.getEmp_id();
	}

	@Override
	public Employee findEmpById(int id) {
		Optional<Employee> op=empRepo.findById(id);
		return op.get();
	}

	@Override
	public String saveEmployee(Employee emp) {
		return "Employee updated successfully with emp ID "+empRepo.save(emp).getEmp_id();
	}

	@Override
	public String deleteEmployeeById(int id) {
		empRepo.deleteById(id);
		return "Employee ID "+id+" deleted Sucessfully";
	}

}
