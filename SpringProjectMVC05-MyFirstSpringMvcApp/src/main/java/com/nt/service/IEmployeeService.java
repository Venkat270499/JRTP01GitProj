package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeService {
	public List<Employee> findAllEmpdetails();
	public String registerEmployee(Employee emp);
	public Employee findEmpById(int id);
	public String saveEmployee(Employee emp);
	public String deleteEmployeeById(int id);

}
