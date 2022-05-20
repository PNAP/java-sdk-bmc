package com.pnap.bmc_sdk.command;

import static com.pnap.bmc_sdk.constant.ConstantContainer.SERVERS_RESOURCE;

import com.pnap.bmc_sdk.client.Client;

/**
 * Deprovision specific server.
 * @author DCAutomation
 *
 */
public class DeleteServerCommand implements Command {

	/**
	 * Client
	 */
	private Client client;
	
	/**
	 * Server id
	 */
	private String serverId;
	
	public DeleteServerCommand(Client client, String serverId) {
		this.client = client;
		this.serverId = serverId;
	}
	
	@Override
	public String execute() {
		String resourceUrl = getResourceUrl(this.serverId);
		return this.client.delete(resourceUrl);
	}

	/**
	 * Returns resource url
	 * @param serverId
	 * @return {String} Resource url			Example:/servers/{serverId}
	 */
	private String getResourceUrl(String serverId) {
		StringBuilder sb = new StringBuilder();
		sb.append(SERVERS_RESOURCE).append("/").append(serverId);
		return sb.toString();
	}

}
