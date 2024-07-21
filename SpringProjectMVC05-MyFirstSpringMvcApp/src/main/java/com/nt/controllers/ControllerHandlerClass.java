package com.nt.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeService;

@Controller
public class ControllerHandlerClass {

	@Autowired
	IEmployeeService empServi;
	
	@RequestMapping("/")
	public String allReq() {
		
		return "welcome";
	}
	
	@GetMapping("/show_emp_details")
	public String getEmpDetails(Map<String,Object> map) {
		List<Employee> list=empServi.findAllEmpdetails();
		map.put("empList", list);
		return "Display_all_employee";
	}
	@GetMapping("/add_emp")
	public String addEmployee(@ModelAttribute("emp") Employee emp_obj) {
		return "emp_add_details";
	}  
	
	@PostMapping("/add_emp")
	public String registerEmployee(@ModelAttribute("emp") Employee emp_obj,RedirectAttributes redatt) {
		String s=empServi.registerEmployee(emp_obj);
		System.out.println(s);
		/*List<Employee> list=empServi.findAllEmpdetails();
		map.put("empList", list);
		*/		
		redatt.addFlashAttribute("resultMsg", s);
		return "redirect:show_report";
	}
	@GetMapping("/show_report")
	public String showReport(Map<String,Object> map) {
		List<Employee> list=empServi.findAllEmpdetails();
		map.put("empList", list);
		return "Display_all_employee";		
	}
	@GetMapping("/edit")
	public String editEmployee(@RequestParam("no") int no,@ModelAttribute("emp") Employee emp1) {
			Employee emp2=empServi.findEmpById(no);
			BeanUtils.copyProperties(emp2, emp1);
		return "update_employee";
	}
	@PostMapping("/edit")
	public String updateEmp(@ModelAttribute("emp") Employee emp, RedirectAttributes redatt) {
		//use service
		String msg=empServi.saveEmployee(emp);
		redatt.addFlashAttribute("resultMsg", msg);
		return "redirect:show_report";
	}
	@GetMapping("/delete")
	public String deleteEmp(@RequestParam("no") int no, RedirectAttributes redatt) {
		String msg=empServi.deleteEmployeeById(no);
		redatt.addFlashAttribute("resultMsg", msg);
		return "redirect:show_report";
	}
	
}
