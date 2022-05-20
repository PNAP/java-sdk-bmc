package com.pnap.bmc_sdk.command;

import static com.pnap.bmc_sdk.constant.ConstantContainer.SERVERS_RESOURCE;

import com.pnap.bmc_sdk.client.Client;

/**
 * Create a new server.
 * @author DCAutomation
 *
 */
public class CreateServerCommand implements Command {
	
	/**
	 * Client
	 */
	private Client client;
	
	/**
	 * Request body
	 */
	private Object body;
	
	public CreateServerCommand(Client client, Object body) {
		this.client = client;
		this.body = body;
	}

	@Override
	public String execute() {
		return this.client.post(SERVERS_RESOURCE,this.body);
	}

}
