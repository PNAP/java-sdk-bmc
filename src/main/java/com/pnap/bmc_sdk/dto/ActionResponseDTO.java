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
 * BMC Cloud API response DTO object when action (power-on, power-off, reset, reboot, shutdown) is completed
 * Result of a successful action.
 * @author DCAutomation
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class ActionResponseDTO implements Serializable {
	
	private static final long serialVersionUID = -7257052281271282652L;
	
	/**
	 * Message describing the action's result
	 */
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public static ActionResponseDTO fromString(String value){
		ActionResponseDTO actionResponseDTO = null;
		try {
			actionResponseDTO =  new ObjectMapper().readValue(value, ActionResponseDTO.class);
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
		return actionResponseDTO;
	}

}
