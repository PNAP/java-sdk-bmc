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
public class ServersResponseDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9132629066034790403L;
	private List<ServerResponseDTO> servers;

	public List<ServerResponseDTO> getServers() {
		return servers;
	}

	public void setServers(List<ServerResponseDTO> servers) {
		this.servers = servers;
	}
	
	public void fromString(String value){
		ServerResponseDTO[] serversResponseDTO = null;
		try {
			serversResponseDTO =  new ObjectMapper().readValue(value, ServerResponseDTO[].class);
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
		this.servers = Arrays.asList(serversResponseDTO);
		
	}

	@Override
	public String toString() {
		return "ServersResponseDTO [servers=" + servers + "]";
	}

}
