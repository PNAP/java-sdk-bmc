package com.pnap.bmc_sdk.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * OS specific configuration properties.
 * @author DCAutomation
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class OsConfigurationDTO implements Serializable {

	private static final long serialVersionUID = -3444657221307504886L;
	
	private WindowsDTO windows;
	
	
	/**
	 * Default constructor
	 */
	public OsConfigurationDTO() {
	
	}
	
	/**
	 * Param constructor
	 * @param windows
	 */
	public OsConfigurationDTO(WindowsDTO windows) {
		this.windows = windows;
	}

	public WindowsDTO getWindows() {
		return windows;
	}

	public void setWindows(WindowsDTO windows) {
		this.windows = windows;
	}

	@Override
	public String toString() {
		return "OsConfigurationDTO [windows=" + windows + "]";
	}
	
}
