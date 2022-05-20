package com.pnap.bmc_sdk.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class CreateServerRequestDTO implements Serializable {
	
	private static final long serialVersionUID = 3090304824443824236L;
	
	/**
	 * Hostname of server.
	 * 1 ≤ length ≤ 100
	 * matches ^(?=.*[a-zA-Z])([a-zA-Z0-9().-])+$
	 */
	private String hostname;
	
	/**
	 * Description of server.
	 * length ≤ 250
	 */
	private String description;
	
	/**
	 * The server’s OS ID used when the server was created. 
	 * Currently this field should be set to either ubuntu/bionic, centos/centos7, windows/srv2019std or windows/srv2019dc.
	 */
	private String os;
	
	/**
	 * Server type ID. Cannot be changed once a server is created. 
	 * Currently this field should be set to either 
	 * s1.c1.small, s1.c1.medium, s1.c2.medium, s1.c2.large, d1.c1.small, d1.c2.small, 
	 * d1.c3.small, d1.c4.small, d1.c1.medium, d1.c2.medium, d1.c3.medium, d1.c4.medium, d1.c1.large, d1.c2.large, d1.c3.large, 
	 * d1.c4.large, d1.m1.medium, d1.m2.medium, d1.m3.medium or d1.m4.medium.
	 */
	private String type;
	
	/**
	 * Server Location ID. Cannot be changed once a server is created. Currently this field should be set to PHX or ASH.
	 */
	private String location;
	
	/**
	 * Whether or not to install ssh keys marked as default in addition to any ssh keys specified in this request
	 * Default value: true
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
	 * Server reservation ID.
	 */
	private String reservationId;
	
	/**
	 * Server pricing model. Currently this field should be set to 
	 * HOURLY, ONE_MONTH_RESERVATION, TWELVE_MONTHS_RESERVATION, TWENTY_FOUR_MONTHS_RESERVATION or THIRTY_SIX_MONTHS_RESERVATION.
	 * Default value: "HOURLY"
	 */
	private String pricingModel;
	
	/**
	 * The type of network configuration for this server. Currently this field should be set to PUBLIC_AND_PRIVATE or PRIVATE_ONLY.
	 * Default value: "PUBLIC_AND_PRIVATE"
	 */
	private String networkType;
	
	/**
	 * OS specific configuration properties.
	 */
	private OsConfigurationDTO osConfiguration;
	
	/**
	 * Default constructor
	 */
	public CreateServerRequestDTO() {
		
	}
	
	/**
	 * Constructor
	 * @param hostname
	 * @param description
	 * @param os
	 * @param type
	 * @param location
	 * @param installDefaultSshKeys
	 * @param sshKeys
	 * @param sshKeyIds
	 * @param reservationId
	 * @param pricingModel
	 * @param networkType
	 * @param osConfiguration
	 */
	public CreateServerRequestDTO(String hostname, String description, String os, String type, String location,
			Boolean installDefaultSshKeys, List<String> sshKeys, List<String> sshKeyIds, String reservationId,
			String pricingModel, String networkType, OsConfigurationDTO osConfiguration) {
		this.hostname = hostname;
		this.description = description;
		this.os = os;
		this.type = type;
		this.location = location;
		this.installDefaultSshKeys = installDefaultSshKeys;
		this.sshKeys = sshKeys;
		this.sshKeyIds = sshKeyIds;
		this.reservationId = reservationId;
		this.pricingModel = pricingModel;
		this.networkType = networkType;
		this.osConfiguration = osConfiguration;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	public String getReservationId() {
		return reservationId;
	}
	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}
	public String getPricingModel() {
		return pricingModel;
	}
	public void setPricingModel(String pricingModel) {
		this.pricingModel = pricingModel;
	}
	public String getNetworkType() {
		return networkType;
	}
	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}
	public OsConfigurationDTO getOsConfiguration() {
		return osConfiguration;
	}
	public void setOsConfiguration(OsConfigurationDTO osConfiguration) {
		this.osConfiguration = osConfiguration;
	}

	@Override
	public String toString() {
		return "CreateServerRequestDTO [hostname=" + hostname + ", description=" + description + ", os=" + os
				+ ", type=" + type + ", location=" + location + ", installDefaultSshKeys=" + installDefaultSshKeys
				+ ", sshKeys=" + sshKeys + ", sshKeyIds=" + sshKeyIds + ", reservationId=" + reservationId
				+ ", pricingModel=" + pricingModel + ", networkType=" + networkType + ", osConfiguration="
				+ osConfiguration + "]";
	}
	
}
