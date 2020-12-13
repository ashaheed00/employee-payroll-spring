package com.blz.emppayroll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blz.emppayroll.model.EmployeePayroll;
import com.blz.emppayroll.repository.EmployeePayrollRepository;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	@Autowired
	EmployeePayrollRepository employeePayrollRepository;

	@Override
	public List<EmployeePayroll> getEmployeePayrollData() {
		return employeePayrollRepository.findAll();
	}

	@Override
	public EmployeePayroll getEmployeePayrollDataById(int empId) {
		return employeePayrollRepository.findById((long) empId).orElse(null);
	}

	@Override
	public EmployeePayroll createEmployeePayrollData(EmployeePayroll empPayroll) {
		return employeePayrollRepository.save(empPayroll);
	}

	@Override
	public EmployeePayroll updateEmployeePayrollData(int empId, EmployeePayroll empPayroll) {
		empPayroll.setId(empId);
		return employeePayrollRepository.save(empPayroll);
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		employeePayrollRepository.deleteById((long) empId);
	}

}