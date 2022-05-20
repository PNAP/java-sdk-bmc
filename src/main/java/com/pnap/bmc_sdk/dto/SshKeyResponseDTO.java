package com.pnap.bmc_sdk.dto;

import java.io.IOException;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * BMC Cloud API response DTO object when create or edit or get the ssh key
 * @author DCAutomation
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class SshKeyResponseDTO implements Serializable {

	private static final long serialVersionUID = -5532517650654195573L;

	/**
	 * The unique identifier of the SSH Key.
	 * Example: "5fa54d1e91867c03a0a7b4a4"
	 */
	private String id;
	
	/**
	 * Keys marked as default are always included on server creation and reset unless toggled off in creation/reset request.
	 * Example: true
	 */
	@JsonProperty("default")
	private Boolean def;
	
	/**
	 * Friendly SSH Key name to represent an SSH key.
	 * Example: "sshkey-name-01"
	 */
	private String name;
	
	/**
	 * SSH Key value.
	 * Example: "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQDF9LdAFElNCi7JoWh6KUcchrJ2Gac1aqGRPpdZNowObpRtmiRCecAMb7bUgNAaNfcmwiQi7tos9
	 * 			TlnFgprIcfMWb8MSs3ABYHmBgqEEt3RWYf0fAc9CsIpJdMCUG28TPGTlRXCEUVNKgLMdcseAlJoGp1CgbHWIN65fB3he3kAZcfpPn5mapV0tsl2p+Z
	 * 			yuAGRYdn5dJv2RZDHUZBkOeUobwsij+weHCKAFmKQKtCP7ybgVHaQjAPrj8MGnk1jBbjDt5ws+Be+9JNjQJee9zCKbAOsIo3i+GcUIkrw5jxPU/RTG
	 * 			lWBcemPaKHdciSzGcjWboapzIy49qypQhZe1U75 user@my_ip"
	 */
	private String key;
	
	/**
	 * SSH Key auto-generated SHA-256 fingerprint.
	 * Example: "iL4k5YTrOnzvlxFMN+WU4BPI/QqrMcvvhU0xlfeMwZI"
	 */
	private String fingerprint;
	
	/**
	 * Date and time of creation
	 * Example: "2020-03-19T16:39:00Z"
	 */
	private String createdOn;
	
	/**
	 * Date and time of last update.
	 * Example: "2020-03-19T16:39:00Z"
	 */
	private String lastUpdatedOn;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getDef() {
		return def;
	}

	public void setDef(Boolean def) {
		this.def = def;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(String lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}
	
	public static SshKeyResponseDTO fromString(String value){
		SshKeyResponseDTO key = null;
		try {
			key =  new ObjectMapper().readValue(value, SshKeyResponseDTO.class);
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
		return key;
	}

	@Override
	public String toString() {
		return "SshKeyResponseDTO [id=" + id + ", def=" + def + ", name=" + name + ", key=" + key + ", fingerprint="
				+ fingerprint + ", createdOn=" + createdOn + ", lastUpdatedOn=" + lastUpdatedOn + "]";
	}

}
