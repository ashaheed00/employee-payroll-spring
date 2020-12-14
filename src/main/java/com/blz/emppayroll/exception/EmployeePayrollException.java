package com.blz.emppayroll.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public @Getter @Setter @AllArgsConstructor @NoArgsConstructor class EmployeePayrollException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

}
