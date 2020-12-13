package com.blz.emppayroll.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blz.emppayroll.model.EmployeePayroll;
import com.blz.emppayroll.service.EmailService;
import com.blz.emppayroll.service.IEmployeePayrollService;

@CrossOrigin(origins = "http://localhost:3000/home")
@RestController
public class EmployeePayrollController {

	@Autowired
	private IEmployeePayrollService employeePayrollService;

	@GetMapping("/employees")
	public List<EmployeePayroll> getAllEmployees() {
		return employeePayrollService.getEmployeePayrollData();
	}

	@GetMapping("/employees/{empId}")
	public EmployeePayroll getAllEmployeeById(@PathVariable("empId") int empId) {
		return employeePayrollService.getEmployeePayrollDataById(empId);
	}

	@PostMapping("/employees")
	public EmployeePayroll createEmployee(@RequestBody EmployeePayroll employee) {
		return employeePayrollService.createEmployeePayrollData(employee);
	}

	@PutMapping("/update/{empId}")
	public EmployeePayroll updateEmployeePayrollData(@PathVariable("empId") int empId,
			@RequestBody EmployeePayroll empPayroll) {
		return employeePayrollService.updateEmployeePayrollData(empId, empPayroll);
	}

	@DeleteMapping("employee/delete/{empId}")
	public String deleteEmployeePayrollData(@PathVariable("empId") int empId) {
		employeePayrollService.deleteEmployeePayrollData(empId);
		return "Deleted Successfully and Deleted Id: " + empId;
	}

	@Autowired
	EmailService emailService;

	@RequestMapping("/send/{email}")
	public String sendWelcome(@PathVariable("email") String email) {
		emailService.sendSimpleMessage(email, "Welcome to CG", "Hi, you are onboarded on " + LocalDateTime.now());
		return "Email Sent!";
	}
}