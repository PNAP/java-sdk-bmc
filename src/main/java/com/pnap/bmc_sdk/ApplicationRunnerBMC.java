package com.pnap.bmc_sdk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.oauth2.client.resource.OAuth2AccessDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import com.pnap.bmc_sdk.client.PNAPClient;
import com.pnap.bmc_sdk.command.DeleteServerCommand;
import com.pnap.bmc_sdk.command.GetServerCommand;
import com.pnap.bmc_sdk.dto.ErrorsResponseDTO;
import com.pnap.bmc_sdk.dto.PNAPClientDTO;
import com.pnap.bmc_sdk.dto.ServerResponseDTO;
import com.pnap.bmc_sdk.dto.TokenErrorResponseDTO;


@Component
public class ApplicationRunnerBMC implements ApplicationRunner  {
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationRunnerBMC.class);
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		
		PNAPClientDTO dto = new PNAPClientDTO();
		dto.setAccessTokenURI("https://auth-dev.phoenixnap.com/auth/realms/BMC/protocol/openid-connect/token");		
		dto.setClientID("");
		dto.setClientSecret("");
		dto.setApiBaseURL("https://api-dev.phoenixnap.com/bmc/v1");
		
		PNAPClient cl = new PNAPClient(dto);
		//GetServersCommand com = new GetServersCommand(cl);
		//ResponseEntity<String> response = (ResponseEntity<String>) com.execute();
		//<200,[{"id":"6008c14dba6d0e7bdb157b7b","status":"powered-on","hostname":"test-pavle","description":null,"os":"ubuntu/bionic","type":"s1.c1.medium","location":"PHX","cpu":"E-2276G","ram":"128GB RAM","storage":"2x 1TB NVMe","privateIpAddresses":["10.0.0.11"],"publicIpAddresses":["10.111.14.50","10.111.14.51","10.111.14.52","10.111.14.53","10.111.14.54"],"reservationId":null,"pricingModel":"HOURLY","password":null,"networkType":"PUBLIC_AND_PRIVATE"}],[Date:"Thu, 21 Jan 2021 20:29:28 GMT", Content-Type:"application/json", Content-Length:"446", Connection:"keep-alive", Cache-Control:"no-cache, no-store, max-age=0, must-revalidate", Expires:"0", Pragma:"no-cache", Strict-Transport-Security:"max-age=31536000 ; includeSubDomains", Vary:"Accept-Encoding", X-Content-Type-Options:"nosniff", X-Frame-Options:"DENY", X-Xss-Protection:"1; mode=block"]>
		//LongServersDTO s = new LongServersDTO();
		//s.fromString(response.getBody());
		//System.out.println(response);
		//<200,[{"id":"6008c14dba6d0e7bdb157b7b","status":"powered-on","hostname":"test-pavle","description":null,"os":"ubuntu/bionic","type":"s1.c1.medium","location":"PHX","cpu":"E-2276G","ram":"128GB RAM","storage":"2x 1TB NVMe","privateIpAddresses":["10.0.0.11"],"publicIpAddresses":["10.111.14.50","10.111.14.51","10.111.14.52","10.111.14.53","10.111.14.54"],"reservationId":null,"pricingModel":"HOURLY","password":null,"networkType":"PUBLIC_AND_PRIVATE"}],[Date:"Thu, 21 Jan 2021 20:29:28 GMT", Content-Type:"application/json", Content-Length:"446", Connection:"keep-alive", Cache-Control:"no-cache, no-store, max-age=0, must-revalidate", Expires:"0", Pragma:"no-cache", Strict-Transport-Security:"max-age=31536000 ; includeSubDomains", Vary:"Accept-Encoding", X-Content-Type-Options:"nosniff", X-Frame-Options:"DENY", X-Xss-Protection:"1; mode=block"]>
		
		//getServerExample(cl);
		deleteServer(cl);
		
	}

	private void deleteServer(PNAPClient cl) {
		DeleteServerCommand getServerComand = new DeleteServerCommand(cl,"6083436fcd99742bede1338d");
		String response = null;
		try {
			response = getServerComand.execute();
			//ServerResponseDTO fromString = ServerResponseDTO.fromString(response);
			System.out.println(response);
			//{"id":"600b09304fa7c22bbad7070e","status":"powered-on","hostname":"test-luca","description":null,"os":"ubuntu/bionic","type":"s1.c1.medium","location":"PHX","cpu":"E-2276G","ram":"128GB RAM","storage":"2x 1TB NVMe","privateIpAddresses":["10.0.0.12"],"publicIpAddresses":["10.111.14.154","10.111.14.155","10.111.14.156","10.111.14.157","10.111.14.158"],"reservationId":null,"pricingModel":"HOURLY","password":null,"networkType":"PUBLIC_AND_PRIVATE"}
		} catch (OAuth2AccessDeniedException e) {
			//error="access_denied", error_description="Error requesting access token."
			//Caused by: org.springframework.web.client.HttpClientErrorException$Unauthorized: 401 Unauthorized: [no body]
			System.out.println(e.getMessage());
			TokenErrorResponseDTO t = new TokenErrorResponseDTO();
			t.fromException(e);
			e.printStackTrace();
		} catch (HttpClientErrorException e) {
			System.out.println(e.getMessage());
			//403 Forbidden: [{"message":"The request failed since this resource cannot be accessed by the provided credentials.","validationErrors":null}]
			ErrorsResponseDTO errors = new ErrorsResponseDTO();
			errors.fromString(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	/**
	 * 
	 * @param cl
	 * @param resourceId
	 */
	private void getServerExample(PNAPClient cl) {
		GetServerCommand getServerComand = new GetServerCommand(cl,"600b09304fa7c22bbad7070e");
		String response = null;
		try {
			response = getServerComand.execute();
			ServerResponseDTO responseDTO = new ServerResponseDTO();
			responseDTO.fromString(response);
			System.out.println(response);
			//{"id":"600b09304fa7c22bbad7070e","status":"powered-on","hostname":"test-luca","description":null,"os":"ubuntu/bionic","type":"s1.c1.medium","location":"PHX","cpu":"E-2276G","ram":"128GB RAM","storage":"2x 1TB NVMe","privateIpAddresses":["10.0.0.12"],"publicIpAddresses":["10.111.14.154","10.111.14.155","10.111.14.156","10.111.14.157","10.111.14.158"],"reservationId":null,"pricingModel":"HOURLY","password":null,"networkType":"PUBLIC_AND_PRIVATE"}
		} catch (OAuth2AccessDeniedException e) {
			//error="access_denied", error_description="Error requesting access token."
			//Caused by: org.springframework.web.client.HttpClientErrorException$Unauthorized: 401 Unauthorized: [no body]
			System.out.println(e.getMessage());
			TokenErrorResponseDTO t = new TokenErrorResponseDTO();
			t.fromException(e);
			e.printStackTrace();
		} catch (HttpClientErrorException e) {
			System.out.println(e.getMessage());
			//403 Forbidden: [{"message":"The request failed since this resource cannot be accessed by the provided credentials.","validationErrors":null}]
			ErrorsResponseDTO errors = new ErrorsResponseDTO();
			errors.fromString(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
}
