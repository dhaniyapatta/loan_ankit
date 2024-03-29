package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Employee;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.AdminEmployeeService;
import com.example.demo.service.AdminLoginService;

@RestController
public class AdminController {
	@Autowired
	private AdminRepository adminRepo;
	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	AdminLoginService loginService;
	
	@Autowired
	AdminEmployeeService adminservice;
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello!";
	}
	@PostMapping("/addAdmin")
	public Admin addAdmin(@RequestBody Admin admin) {
		return (Admin) adminRepo.save(admin) ;
	}

	@PostMapping("/addEmployee")
	public Employee addCustomer(@RequestBody Employee employee) {
		Employee temp= adminservice.addEmployee(employee);
		return temp;
	}
	
	@GetMapping("/showAllEmployee")
	public List<Employee> showallcust(){
		return adminservice.ShowAllEmployee();
	}
	
	 @DeleteMapping("/deleteEmployee/{id}")	
		public ResponseEntity<String> deleteEmployee(@PathVariable("id") String id) {
		 return adminservice.deleteEmployee(id);
	   
	}
	
	 @PostMapping("/updateEmployee")
		public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
				return adminservice.updateEmployee(employee);
			}

	@PostMapping("/login")
	public String login(@RequestBody Admin admin) {
		System.out.println(admin.getAdminId());
		return loginService.login(admin);
	}

}
