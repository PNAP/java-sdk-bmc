package com.pnap.bmc_sdk.dto;

import java.io.IOException;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * BMC Cloud API response DTO object when reset is completed
 * Result of a successful reset action.
 * @author DCAutomation
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class ResetResponseDTO implements Serializable {
	
	private static final long serialVersionUID = -1166135715811848930L;

	/**
	 * Message describing the reset result.
	 */
	private String result;
	
	/**
	 * Password set for user Admin on Windows server.
	 */
	private String password;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public static ResetResponseDTO fromString(String value){
		ResetResponseDTO resetResponseDTO = null;
		try {
			resetResponseDTO =  new ObjectMapper().readValue(value, ResetResponseDTO.class);
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
		return resetResponseDTO;
	}
	
}
