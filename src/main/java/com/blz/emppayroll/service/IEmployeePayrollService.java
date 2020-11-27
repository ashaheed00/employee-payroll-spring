package com.blz.emppayroll.service;

import java.util.List;

import com.blz.emppayroll.dto.EmployeePayrollDTO;
import com.blz.emppayroll.model.EmployeePayroll;

public interface IEmployeePayrollService {
	List<EmployeePayroll> getEmployeePayrollData();

	EmployeePayroll getEmployeePayrollDataById(int empId);

	EmployeePayroll createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);

	EmployeePayroll updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO);

	void deleteEmployeePayrollData(int empId);
}
