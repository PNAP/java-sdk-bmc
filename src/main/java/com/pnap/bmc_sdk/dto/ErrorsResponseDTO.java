package com.pnap.bmc_sdk.dto;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Errors response DTO
 * @author DCAutomation
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class ErrorsResponseDTO implements Serializable {
	
	private static final long serialVersionUID = -1388016697961186875L;
	
	private String statusCode;
	private List<ErrorResponseDTO> errors;
	
	public String getErrorStatus() {
		return statusCode;
	}

	public void setErrorStatus(String errorStatus) {
		this.statusCode = errorStatus;
	}

	public List<ErrorResponseDTO> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorResponseDTO> errors) {
		this.errors = errors;
	}

	/**
	 * 
	 * @param value -> 403 Forbidden: [{"message":"The request failed since this resource cannot be accessed by the provided credentials.","validationErrors":null}]
	 */
	public void fromString(String value){
		
		ErrorResponseDTO[] errors = null;
		
		try {
			String[] split = value.split(":", 2);
			this.statusCode = split[0];
			errors =  new ObjectMapper().readValue(split[1].trim(), ErrorResponseDTO[].class);
			this.errors = Arrays.asList(errors);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
