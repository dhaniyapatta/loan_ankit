package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Employee;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.AdminLoginService;

@RestController
public class AdminController {
	@Autowired
	private AdminRepository adminRepo;
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	AdminLoginService loginService;
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello!";
	}
	@PostMapping("/addAdmin")
	public Admin addAdmin(@RequestBody Admin admin) {
		return (Admin) adminRepo.save(admin) ;
	}

	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return (Employee) employeeRepo.save(employee) ;
	}

	@PostMapping("/login")
	public String login(@RequestBody Admin admin) {
		System.out.println(admin.getAdminId());
		return loginService.login(admin);
	}

}
