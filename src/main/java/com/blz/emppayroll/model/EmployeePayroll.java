package com.blz.emppayroll.model;

import java.util.Date;

import com.blz.emppayroll.dto.EmployeePayrollDTO;

public class EmployeePayroll {
	private long id;
	private String name;
	private String[] departMent;
	private String gender;
	private long salary;
	private String startDate;
	private String profileUrl;
	private String notes;

	public EmployeePayroll(long id, EmployeePayrollDTO employeePayrollDTO) {
		this.id = new Date().getTime();
//		this.id = id;
		this.name = employeePayrollDTO.name;
		this.departMent = employeePayrollDTO.departMent;
		this.gender = employeePayrollDTO.gender;
		this.salary = employeePayrollDTO.salary;
		this.startDate = employeePayrollDTO.startDate;
		this.profileUrl = employeePayrollDTO.profileUrl;
		this.notes = employeePayrollDTO.notes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String[] getDepartMent() {
		return departMent;
	}

	public void setDepartMent(String[] departMent) {
		this.departMent = departMent;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

//	private int employeeId;
//	private String name;
//	private long salary;
//
//	public EmployeePayroll(int employeeId, EmployeePayrollDTO empPayrollDTO) {
//		this.employeeId = employeeId;
//		this.name = empPayrollDTO.name;
//		this.salary = empPayrollDTO.salary;
//	}
//
//	public int getEmployeeId() {
//		return employeeId;
//	}
//
//	public void setEmployeeId(int employeeId) {
//		this.employeeId = employeeId;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public long getSalary() {
//		return salary;
//	}
//
//	public void setSalary(long salary) {
//		this.salary = salary;
//	}

}
