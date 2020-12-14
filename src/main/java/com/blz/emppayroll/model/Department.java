package com.blz.emppayroll.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public @Data @NoArgsConstructor class Department {

	@Id
	private String departmentName;

}
