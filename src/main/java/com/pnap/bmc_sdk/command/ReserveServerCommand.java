package com.pnap.bmc_sdk.command;

import static com.pnap.bmc_sdk.constant.ConstantContainer.*;

import com.pnap.bmc_sdk.client.Client;

/**
 * Reserve specific server
 * @author DCAutomation
 *
 */
public class ReserveServerCommand implements Command {
	
	/**
	 * Client
	 */
	private Client client;
	
	/**
	 * Server id
	 */
	private String serverId;
	
	/**
	 * Request body
	 */
	private Object body;

	public ReserveServerCommand(Client client, String serverId, Object body) {
		this.client = client;
		this.serverId = serverId;
		this.body = body;
	}

	@Override
	public String execute() {
		String resourceUrl = getResourceUrl(this.serverId);
		return this.client.post(resourceUrl, this.body);
	}
	
	/**
	 * Returns resource url
	 * @param serverId
	 * @return {String} Resource url			Example:/servers/{serverId}/actions/reserve
	 */
	private String getResourceUrl(String serverId) {
		StringBuilder sb = new StringBuilder();
		sb.append(SERVERS_RESOURCE).append("/").append(serverId).append(ACTIONS).append(RESERVE);
		return sb.toString();
	}

}
