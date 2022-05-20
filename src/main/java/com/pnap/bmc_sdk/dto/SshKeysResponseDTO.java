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

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class SshKeysResponseDTO implements Serializable {

	private static final long serialVersionUID = -855157472615355469L;
	
	private List<SshKeyResponseDTO> sshKeys;

	public List<SshKeyResponseDTO> getSshKeys() {
		return sshKeys;
	}

	public void setSshKeys(List<SshKeyResponseDTO> sshKeys) {
		this.sshKeys = sshKeys;
	}
	
	public void fromString(String value){
		SshKeyResponseDTO[] keys = null;
		try {
			keys =  new ObjectMapper().readValue(value, SshKeyResponseDTO[].class);
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
		this.sshKeys = Arrays.asList(keys);
	}

	@Override
	public String toString() {
		return "SshKeysResponseDTO [sshKeys=" + sshKeys + "]";
	}

}
