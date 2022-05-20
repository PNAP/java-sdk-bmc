package com.pnap.bmc_sdk.dto;

import java.io.Serializable;

import org.springframework.security.oauth2.client.resource.OAuth2AccessDeniedException;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedClientException;
import org.springframework.web.client.HttpClientErrorException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * For dev environment when client id and client secret are null, empty or incorrect 
 * @author DCAutomation
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class TokenErrorResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 2360937531408312247L;
	
	private String statusCode;
	private String message;
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * When client id and client secret are null or empty
	 * @param {OAuth2AccessDeniedException} ex
	 */
	public void fromException(OAuth2AccessDeniedException ex) {
		this.message = ex.getMessage();
		if(ex.getCause() != null && ex.getCause() instanceof HttpClientErrorException) {
			String[] split = ex.getCause().getMessage().split(":");
			if(split[0] != null) {
				this.statusCode = split[0];
			}
		} else if(ex.getCause() != null && ex.getCause() instanceof UnauthorizedClientException) {
			this.message = this.message + ex.getCause().getMessage();
			this.statusCode = "Unknown";
		}
	}
	
}
