package com.pnap.bmc_sdk.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
/*import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;*/
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

import com.pnap.bmc_sdk.dto.PNAPClientDTO;

public class PNAPClient implements Client {
	
    private String apiBaseURL;
    private OAuth2RestTemplate restTemplate; 
    
    public PNAPClient(PNAPClientDTO clientData) {
    	
    	this.apiBaseURL = clientData.getApiBaseURL();	
    	
    	ClientCredentialsResourceDetails resource = new ClientCredentialsResourceDetails();

		List<String> scopes = new ArrayList<String>(2);
		scopes.add("bmc");
		scopes.add("bmc.read");
		resource.setAccessTokenUri(clientData.getAccessTokenURI());
		resource.setClientId(clientData.getClientID());
		resource.setClientSecret(clientData.getClientSecret());
		resource.setGrantType("client_credentials");
		resource.setScope(scopes);
		
		AccessTokenRequest atr = new DefaultAccessTokenRequest();
		
		restTemplate = new OAuth2RestTemplate(resource, new DefaultOAuth2ClientContext(atr));
		
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();        
		//Add the Jackson Message converter
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		// Note: here we are making this converter to process any kind of response, 
		// not only application/*json, which is the default behaviour
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));        
		messageConverters.add(converter);  
		restTemplate.getMessageConverters().add(converter);
		//restTemplate.setMessageConverters(messageConverters); 
    }
	
	@Override
	public String get(String resourceUrl) {
		//String restUrl = String.format("https://api-dev.phoenixnap.com/bmc/v1/servers");
		String url = getUrl(resourceUrl);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
		return response.getBody();

	}

	@Override
	public String put(String resourceUrl, Object body) {
		String url = getUrl(resourceUrl);
		HttpEntity<Object> request = new HttpEntity<>(body);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, request, String.class);
		return response.getBody();

	}

	@Override
	public String post(String resourceUrl, Object body) {
		String url = getUrl(resourceUrl);
		HttpEntity<Object> request = null;
		if(body!=null) {
			request = new HttpEntity<>(body);
		}
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
		return response.getBody();
	}

	@Override
	public String delete(String resourceUrl) {
		String url = getUrl(resourceUrl);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);
		return response.getBody();
	}

	/**
	 * Create complete request url
	 * @param resourceUrl
	 * @return {String} Request url
	 */
	private String getUrl(String resourceUrl) {
		StringBuilder sb = new StringBuilder();
		sb.append(this.apiBaseURL).append(resourceUrl);
		return sb.toString();
	}

}
