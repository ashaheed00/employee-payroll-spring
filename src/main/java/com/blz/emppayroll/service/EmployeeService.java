package com.blz.emppayroll.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.blz.emppayroll.dto.EmployeePayrollDTO;
import com.blz.emppayroll.model.EmployeePayroll;

@Service
public class EmployeeService implements IEmployeePayrollService {
	private List<EmployeePayroll> employeePayrollList = new ArrayList<>();

	@Override
	public List<EmployeePayroll> getEmployeePayrollData() {
		return employeePayrollList;
	}

	@Override
	public EmployeePayroll getEmployeePayrollDataById(int empId) {
		return employeePayrollList.get(empId - 1);
	}

	@Override
	public EmployeePayroll createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		EmployeePayroll empData = null;
		empData = new EmployeePayroll(employeePayrollList.size() + 1, empPayrollDTO);
		employeePayrollList.add(empData);
		return empData;
	}

	@Override
	public EmployeePayroll updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
		EmployeePayroll empData = this.getEmployeePayrollDataById(empId);
		empData.setName(empPayrollDTO.name);
		empData.setSalary(empPayrollDTO.salary);
		employeePayrollList.set(empId - 1, empData);
		return empData;
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		employeePayrollList.remove(empId - 1);
	}
}
