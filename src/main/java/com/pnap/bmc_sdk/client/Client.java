package com.pnap.bmc_sdk.client;

import org.springframework.http.ResponseEntity;

public interface Client {
	
//	ResponseEntity<?> get(String resource);
//	ResponseEntity<?> put(String resource, Object body);
//	ResponseEntity<?> post(String resource, Object body);
//	ResponseEntity<?> delete(String resource);
	
	String get(String resource);
	String put(String resource, Object body);
	String post(String resource, Object body);
	String delete(String resource);
	
}
