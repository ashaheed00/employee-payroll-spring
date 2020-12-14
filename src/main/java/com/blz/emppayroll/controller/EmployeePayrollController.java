package com.blz.emppayroll.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

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

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EmployeePayrollController {

	@Autowired
	private IEmployeePayrollService employeePayrollService;

	@GetMapping("/employees")
	public List<EmployeePayroll> getAllEmployees() {
		log.info("Requesting to GET all employee payroll data");
		return employeePayrollService.getEmployeePayrollData();
	}

	@GetMapping("/employees/{empId}")
	public EmployeePayroll getAllEmployeeById(@PathVariable("empId") int empId) {
		log.info("Requesting to GET employee payroll data with Id {}", empId);
		return employeePayrollService.getEmployeePayrollDataById(empId);
	}

	@PostMapping("/employees/add")
	public EmployeePayroll createEmployee(@Valid @RequestBody EmployeePayroll employee) {
		log.info("Requesting to ADD employee payroll data with name {}", employee.getName());
		return employeePayrollService.createEmployeePayrollData(employee);
	}

	@PutMapping("/update/{empId}")
	public EmployeePayroll updateEmployeePayrollData(@PathVariable("empId") int empId,
			@Valid @RequestBody EmployeePayroll empPayroll) {
		log.info("Requesting to UPDATE employee payroll data with Id {}", empId);
		return employeePayrollService.updateEmployeePayrollData(empId, empPayroll);
	}

	@DeleteMapping("employee/delete/{empId}")
	public String deleteEmployeePayrollData(@PathVariable("empId") int empId) {
		log.info("Requesting to DELETE employee payroll data with Id {}", empId);
		employeePayrollService.deleteEmployeePayrollData(empId);
		return "Deleted Successfully and Deleted Id: " + empId;
	}

	@Autowired
	EmailService emailService;

	@RequestMapping("/send/{email}")
	public String sendWelcome(@PathVariable("email") String email) {
		log.info("Requesting to send email to employee with email {}", email);
		emailService.sendSimpleMessage(email, "Welcome to CG", "Hi, you are onboarded on " + LocalDateTime.now());
		return "Email Sent!";
	}
}