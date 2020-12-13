package com.blz.emppayroll.service;

import java.util.List;

import com.blz.emppayroll.model.EmployeePayroll;

public interface IEmployeePayrollService {
	List<EmployeePayroll> getEmployeePayrollData();

	EmployeePayroll getEmployeePayrollDataById(int empId);

	EmployeePayroll createEmployeePayrollData(EmployeePayroll empPayroll);

	EmployeePayroll updateEmployeePayrollData(int empId, EmployeePayroll empPayroll);

	void deleteEmployeePayrollData(int empId);
}
