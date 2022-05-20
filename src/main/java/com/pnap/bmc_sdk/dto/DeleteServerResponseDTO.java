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
 * BMC Cloud API response DTO object when resource is deleted
 * @author DCAutomation
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class DeleteServerResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 7613585484062456175L;

	/**
	 * Server has been deleted.
	 */
	private String result;
	
	/**
	 * The unique identifier of the server.
	 */
	private String serverId;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getServerId() {
		return serverId;
	}

	public void setServerId(String serverId) {
		this.serverId = serverId;
	}
	
	public static DeleteServerResponseDTO fromString(String value){
		DeleteServerResponseDTO  deleteServerResponseDTO = null;
		try {
			deleteServerResponseDTO =  new ObjectMapper().readValue(value, DeleteServerResponseDTO.class);
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
		return deleteServerResponseDTO;
	}

}
