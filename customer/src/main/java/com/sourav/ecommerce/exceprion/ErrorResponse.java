package com.sourav.ecommerce.exceprion;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {

	private HttpStatus errorCode;
	private String errorDesc;
	private LocalDateTime timeStamp;

	
}
