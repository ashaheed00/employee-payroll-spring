package com.blz.emppayroll.dto;

import java.util.Arrays;

public class EmployeePayrollDTO {

	public String name;
	public String[] departMent;
	public String gender;
	public long salary;
	public String startDate;
	public String profileUrl;
	public String notes;

	public EmployeePayrollDTO(String name, String[] departMent, String gender, long salary, String startDate,
			String profileUrl, String notes) {
		super();
		this.name = name;
		this.departMent = departMent;
		this.gender = gender;
		this.salary = salary;
		this.startDate = startDate;
		this.profileUrl = profileUrl;
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "EmployeePayrollDTO [name=" + name + ", departMent=" + Arrays.toString(departMent) + ", gender=" + gender
				+ ", salary=" + salary + ", startDate=" + startDate + ", profileUrl=" + profileUrl + ", notes=" + notes
				+ "]";
	}

}
