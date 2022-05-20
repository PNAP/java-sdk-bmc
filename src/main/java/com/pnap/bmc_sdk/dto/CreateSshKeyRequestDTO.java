package com.pnap.bmc_sdk.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author DCAutomation
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class CreateSshKeyRequestDTO implements Serializable {
	
	private static final long serialVersionUID = 6383828037857753699L;
	
	/**
	 * default - required 
	 * Keys marked as default are always included on server creation and reset unless toggled off in creation/reset request.
	 * Example: true
	 */
	@JsonProperty("default")
	private Boolean def;
	
	/**
	 * name - required
	 * Friendly SSH Key name to represent an SSH key.
	 * 1 ≤ length ≤ 100
	 * Example: sshkey-name-01
	 */
	private String name;
	
	/**
	 * key - required
	 * SSH Key actual key value.
	 * Example: "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQDF9LdAFElNCi7JoWh6KUcchrJ2Gac1aqGRPpdZNowObpRtmiRCecAMb7bUgNAaNfcmwiQi7tos9TlnF
	 * 			 gprIcfMWb8MSs3ABYHmBgqEEt3RWYf0fAc9CsIpJdMCUG28TPGTlRXCEUVNKgLMdcseAlJoGp1CgbHWIN65fB3he3kAZcfpPn5mapV0tsl2p+
	 * 			 ZyuAGRYdn5dJv2RZDHUZBkOeUobwsij+weHCKAFmKQKtCP7ybgVHaQjAPrj8MGnk1jBbjDt5ws+Be+9JNjQJee9zCKbAOsIo3i+GcUIkrw5jxPU/
	 * 			 RTGlWBcemPaKHdciSzGcjWboapzIy49qypQhZe1U75 user@my_ip"
	 */
	private String key;
	
	/**
	 * Default constructor
	 */
	public CreateSshKeyRequestDTO() {
	
	}
	
	/**
	 * Parameterized constructor
	 * @param def
	 * @param name
	 * @param key
	 */
	public CreateSshKeyRequestDTO(Boolean def, String name, String key) {
		this.def = def;
		this.name = name;
		this.key = key;
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
		//TODO: validate string length 1 ≤ length ≤ 100
		this.name = name;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "CreateSshKeyRequestDTO [def=" + def + ", name=" + name + ", key=" + key + "]";
	}

}
