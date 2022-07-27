package com.sachin.demo.error;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDetails {

	private String errorcode;
	private Date timestamp;
	private String message;

}
