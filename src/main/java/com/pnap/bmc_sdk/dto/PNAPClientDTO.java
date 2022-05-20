package com.pnap.bmc_sdk.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;



@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class PNAPClientDTO implements Serializable {
	private static final long serialVersionUID = 6012502729989324847L;
    
    private String clientID;
    private String clientSecret;
    private String accessTokenURI;
    private String apiBaseURL;
	public String getClientID() {
		return clientID;
	}
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	public String getAccessTokenURI() {
		return accessTokenURI;
	}
	public void setAccessTokenURI(String accessTokenURI) {
		this.accessTokenURI = accessTokenURI;
	}
	public String getApiBaseURL() {
		return apiBaseURL;
	}
	public void setApiBaseURL(String apiBaseURL) {
		this.apiBaseURL = apiBaseURL;
	}
	
}