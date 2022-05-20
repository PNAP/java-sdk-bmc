package com.pnap.bmc_sdk.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Reset specific server request object.
 * @author DCAutomation
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class ResetServerRequestDTO implements Serializable {

	private static final long serialVersionUID = -3508279449881772221L;
	
	/**
	 * Whether or not to install ssh keys marked as default in addition to any ssh keys specified in this request.
	 * Default true
	 */
	private Boolean installDefaultSshKeys;
	
	/**
	 * A list of SSH Keys that will be installed on the server.
	 */
	private List<String> sshKeys;
	
	/**
	 * A list of SSH Key IDs that will be installed on the server in addition to any ssh keys specified in this request.
	 */
	private List<String> sshKeyIds;
	
	/**
	 * OS specific configuration properties.
	 */
	private OsConfigurationDTO osConfiguration;
	
	
	/**
	 * Default constructor
	 */
	public ResetServerRequestDTO() {
		
	}
	
	/**
	 * Params constructor
	 * @param installDefaultSshKeys
	 * @param sshKeys
	 * @param sshKeyIds
	 * @param osConfiguration
	 */
	public ResetServerRequestDTO(Boolean installDefaultSshKeys, List<String> sshKeys, List<String> sshKeyIds,
			OsConfigurationDTO osConfiguration) {
		this.installDefaultSshKeys = installDefaultSshKeys;
		this.sshKeys = sshKeys;
		this.sshKeyIds = sshKeyIds;
		this.osConfiguration = osConfiguration;
	}

	public Boolean getInstallDefaultSshKeys() {
		return installDefaultSshKeys;
	}
	public void setInstallDefaultSshKeys(Boolean installDefaultSshKeys) {
		this.installDefaultSshKeys = installDefaultSshKeys;
	}
	public List<String> getSshKeys() {
		return sshKeys;
	}
	public void setSshKeys(List<String> sshKeys) {
		this.sshKeys = sshKeys;
	}
	public List<String> getSshKeyIds() {
		return sshKeyIds;
	}
	public void setSshKeyIds(List<String> sshKeyIds) {
		this.sshKeyIds = sshKeyIds;
	}
	public OsConfigurationDTO getOsConfiguration() {
		return osConfiguration;
	}
	public void setOsConfiguration(OsConfigurationDTO osConfiguration) {
		this.osConfiguration = osConfiguration;
	}

	@Override
	public String toString() {
		return "ResetServerRequestDTO [installDefaultSshKeys=" + installDefaultSshKeys + ", sshKeys=" + sshKeys
				+ ", sshKeyIds=" + sshKeyIds + ", osConfiguration=" + osConfiguration + "]";
	}
	
}
