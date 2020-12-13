package com.blz.emppayroll.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeePayroll {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<Department> departMent;
	private String gender;
	private long salary;
	private String startDate;
	private String profileUrl;
	private String notes;

	public EmployeePayroll() {
	}

	public EmployeePayroll(String name, List<Department> departMent, String gender, long salary, String startDate,
			String profileUrl, String notes) {
		this.name = name;
		this.departMent = departMent;
		this.gender = gender;
		this.salary = salary;
		this.startDate = startDate;
		this.profileUrl = profileUrl;
		this.notes = notes;
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

	public List<Department> getDepartMent() {
		return departMent;
	}

	public void setDepartMent(List<Department> departMent) {
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

}
