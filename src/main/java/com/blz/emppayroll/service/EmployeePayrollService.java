package com.blz.emppayroll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blz.emppayroll.exception.EmployeePayrollException;
import com.blz.emppayroll.model.Department;
import com.blz.emppayroll.model.EmployeePayroll;
import com.blz.emppayroll.repository.EmployeePayrollRepository;

import lombok.extern.slf4j.Slf4j;

@Service
public @Slf4j class EmployeePayrollService implements IEmployeePayrollService {
	
	//Singleton -- one object per application
	//Prototype -- multiple object

	@Autowired
	EmployeePayrollRepository employeePayrollRepository;

	@Override
	public List<EmployeePayroll> getEmployeePayrollData() {
		log.info("All Employee Payroll data fetched");
		return employeePayrollRepository.findAll();
	}

	@Override
	public EmployeePayroll getEmployeePayrollDataById(int empId) {
		if (!employeePayrollRepository.existsById((long) empId))
			throw new EmployeePayrollException("No employee found with id: " + empId);
		log.info("Employee Payroll data fetched with empId: " + empId);
		return employeePayrollRepository.findById((long) empId).orElse(null);
	}

	@Override
	public EmployeePayroll createEmployeePayrollData(EmployeePayroll empPayroll) {
		for (Department dept : empPayroll.getDepartMent()) {
			dept.setDepartmentName(dept.getDepartmentName());
		}
		return employeePayrollRepository.save(empPayroll);
	}

	@Override
	public EmployeePayroll updateEmployeePayrollData(int empId, EmployeePayroll empPayroll) {
		if (!employeePayrollRepository.existsById((long) empId))
			throw new EmployeePayrollException("No employee found with id: " + empId);
		empPayroll.setId(empId);
		log.info("Employee Payroll data updated with empId: " + empId);
		return employeePayrollRepository.save(empPayroll);
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		if (!employeePayrollRepository.existsById((long) empId))
			throw new EmployeePayrollException("No employee found with id: " + empId);
		employeePayrollRepository.deleteById((long) empId);
		log.info("Employee Payroll data deleted with empId: " + empId);
	}

}