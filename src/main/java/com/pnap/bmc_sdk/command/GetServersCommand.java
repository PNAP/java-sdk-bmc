package com.pnap.bmc_sdk.command;

import static com.pnap.bmc_sdk.constant.ConstantContainer.SERVERS_RESOURCE;

import com.pnap.bmc_sdk.client.Client;

/**
 * List all servers owned by account.
 * @author DCAutomation
 *
 */
public class GetServersCommand implements Command {

	/**
	 * Client
	 */
	private Client client;
	
	public GetServersCommand(Client client) {
		this.client = client;
	}
	
	@Override
	public String execute() {
		return this.client.get(SERVERS_RESOURCE);
	}

}
