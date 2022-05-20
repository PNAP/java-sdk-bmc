package com.pnap.bmc_sdk.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Windows OS configuration request object.
 * @author DCAutomation
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class WindowsDTO implements Serializable {
	
	private static final long serialVersionUID = -6814558056585180811L;
	
	/**
	 * Disable RDP access on Windows OS.
	 * Default value: false
	 */
	private Boolean rdpDisable;
	
	/**
	 * List of IPs allowed for RDP access to Windows OS.
	 */
    private List<String> rdpAllowedIps;
    
    /**
     * Default constructor
     */
	public WindowsDTO() {
		
	}
	
	/**
	 * Params constructor
	 * @param rdpDisable
	 * @param rdpAllowedIps
	 */
	public WindowsDTO(Boolean rdpDisable, List<String> rdpAllowedIps) {
		this.rdpDisable = rdpDisable;
		this.rdpAllowedIps = rdpAllowedIps;
	}
	
	public Boolean getRdpDisable() {
		return rdpDisable;
	}
	public void setRdpDisable(Boolean rdpDisable) {
		this.rdpDisable = rdpDisable;
	}
	public List<String> getRdpAllowedIps() {
		return rdpAllowedIps;
	}
	public void setRdpAllowedIps(List<String> rdpAllowedIps) {
		this.rdpAllowedIps = rdpAllowedIps;
	}

	@Override
	public String toString() {
		return "WindowsDTO [rdpDisable=" + rdpDisable + ", rdpAllowedIps=" + rdpAllowedIps + "]";
	}
    
}
