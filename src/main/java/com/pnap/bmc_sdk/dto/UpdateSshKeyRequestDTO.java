package com.pnap.bmc_sdk.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Edit SSH Key details request object.
 * @author DCAutomation
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class UpdateSshKeyRequestDTO implements Serializable {
	
	private static final long serialVersionUID = 4726678764223154027L;

	/**
	 * name - required
	 * Friendly SSH Key name to represent an SSH key.
	 * 1 ≤ length ≤ 100
	 * Example: sshkey-name-01
	 */
	private String name;
	
	/**
	 * default - required 
	 * Keys marked as default are always included on server creation and reset unless toggled off in creation/reset request.
	 * Example: true
	 */
	@JsonProperty("default")
	private Boolean def;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		//TODO: Validate length 1 ≤ length ≤ 100
		this.name = name;
	}

	public Boolean getDef() {
		return def;
	}

	public void setDef(Boolean def) {
		this.def = def;
	}

	/**
	 * Default constructor
	 */
	public UpdateSshKeyRequestDTO() {
	
	}

	/**
	 * Params constructor
	 * @param name
	 * @param def
	 */
	public UpdateSshKeyRequestDTO(String name, Boolean def) {
		this.name = name;
		this.def = def;
	}

	@Override
	public String toString() {
		return "UpdateSshKeyRequestDTO [name=" + name + ", def=" + def + "]";
	}
	
}
