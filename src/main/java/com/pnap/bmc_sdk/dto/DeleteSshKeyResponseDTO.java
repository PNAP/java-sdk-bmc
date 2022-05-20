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
 * BMC Cloud API response DTO object when the ssh-key was deleted
 * Result of a successful delete action on a SSH Key.
 * @author DCAutomation
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class DeleteSshKeyResponseDTO implements Serializable {
	
	private static final long serialVersionUID = -6201526803485754005L;

	/**
	 * Resource has been deleted.
	 * Example: "Resource has been deleted."
	 */
	private String result;
	
	/**
	 * The unique identifier of the deleted resource.
	 * Example: "5fa54d1e91867c03a0a7b4a4"
	 */
	private String sshKeyId;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getSshKeyId() {
		return sshKeyId;
	}

	public void setSshKeyId(String sshKeyId) {
		this.sshKeyId = sshKeyId;
	}
	
	public static DeleteSshKeyResponseDTO fromString(String value){
		DeleteSshKeyResponseDTO deleteSshKeyResponseDTO = null;
		try {
			deleteSshKeyResponseDTO =  new ObjectMapper().readValue(value, DeleteSshKeyResponseDTO.class);
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
		return deleteSshKeyResponseDTO;
	}

}
