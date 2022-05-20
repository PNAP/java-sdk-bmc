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

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class ServerResponseDTO implements Serializable{
	
	private static final long serialVersionUID = -141813825352286168L;
	
	private String id;
	private String status;
	private String hostname;
	
	private String description;
	private List<String> privateIpAddresses;
	private List<String> publicIpAddresses;
	private String os;
	private String type;
	private String location;
	private String cpu;
	private String ram;
	private String storage;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getStorage() {
		return storage;
	}
	public void setStorage(String storage) {
		this.storage = storage;
	}
	public List<String> getPrivateIpAddresses() {
		return privateIpAddresses;
	}
	public void setPrivateIpAddresses(List<String> privateIpAddresses) {
		this.privateIpAddresses = privateIpAddresses;
	}
	public List<String> getPublicIpAddresses() {
		return publicIpAddresses;
	}
	public void setPublicIpAddresses(List<String> publicIpAddresses) {
		this.publicIpAddresses = publicIpAddresses;
	}
	
	/**
	 * 
	 * @param {String} value - JSON string
	 * @return
	 */
	public  void fromString(String value){
		ServerResponseDTO serverResponseDTO = null;
		try {
			serverResponseDTO =  new ObjectMapper().readValue(value, ServerResponseDTO.class);
			this.id = serverResponseDTO.getId();
			this.cpu = serverResponseDTO.getCpu();
			this.description = serverResponseDTO.getDescription();
			
			
			this.hostname = serverResponseDTO.getHostname();
			this.location = serverResponseDTO.getCpu();
			this.os = serverResponseDTO.getOs();
			this.privateIpAddresses = serverResponseDTO.getPrivateIpAddresses();
			this.publicIpAddresses = serverResponseDTO.getPublicIpAddresses();
			this.ram = serverResponseDTO.getRam();
			this.status = serverResponseDTO.getStatus();
			this.storage = serverResponseDTO.getStorage();
			this.type = serverResponseDTO.getType();
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
	
	@Override
	public String toString() {
		return "ServerResponseDTO [id=" + id + ", status=" + status + ", hostname=" + hostname + ", description="
				+ description + ", privateIpAddresses=" + privateIpAddresses + ", publicIpAddresses="
				+ publicIpAddresses + ", os=" + os + ", type=" + type + ", location=" + location + ", cpu=" + cpu
				+ ", ram=" + ram + ", storage=" + storage + "]";
	}
	
}
