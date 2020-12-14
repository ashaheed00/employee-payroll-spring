package com.blz.emppayroll.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
public @Data @NoArgsConstructor class EmployeePayroll {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Pattern(regexp = "^[A-Z]{1}[a-z]{2,}\\s?([A-Z]{1}[a-z]{1,}\\s?){0,2}$", message = "Please enter correct name in correct format. Eg. John Smith")
	private String name;

	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<Department> departMent;

	private String gender;

	@Min(value = 1000, message = "Min. required Salary is 1000")
	private long salary;

	private String startDate;
	private String profileUrl;
	private String notes;

}
