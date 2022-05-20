package com.pnap.bmc_sdk.dto;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Error response DTO
 * @author DCAutomation
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class ErrorResponseDTO implements Serializable {

	private static final long serialVersionUID = -753387077477892102L;

	/**
	 * The description detailing the cause of the error code.
	 */
	private String message;
	
	/**
	 * Validation errors, if any.
	 */
	private List<String> validationErrors;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getValidationErrors() {
		return validationErrors;
	}

	public void setValidationErrors(List<String> validationErrors) {
		this.validationErrors = validationErrors;
	}
	
	public static ErrorResponseDTO fromString(String value){
		ErrorResponseDTO errorResponseDTO = null;
		try {
			errorResponseDTO =  new ObjectMapper().readValue(value, ErrorResponseDTO.class);
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
		return errorResponseDTO;
	}

}
