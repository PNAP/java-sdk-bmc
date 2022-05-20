package com.pnap.bmc_sdk.command;

import static com.pnap.bmc_sdk.constant.ConstantContainer.*;

import com.pnap.bmc_sdk.client.Client;

/**
 * Power on specific server.
 * @author DCAutomation
 *
 */
public class PowerOnServerCommand implements Command {

	/**
	 * Client
	 */
	private Client client;
	
	/**
	 * Server id
	 */
	private String serverId;
	
	public PowerOnServerCommand(Client client, String serverId) {
		this.client = client;
		this.serverId = serverId;
	}
	
	@Override
	public String execute() {
		String resourceUrl = getResourceUrl(this.serverId);
		return this.client.post(resourceUrl, null);
	}
	
	/**
	 * Returns resource url
	 * @param serverId
	 * @return {String} Resource url			Example:/servers/{serverId}/actions/power-on
	 */
	private String getResourceUrl(String serverId) {
		StringBuilder sb = new StringBuilder();
		sb.append(SERVERS_RESOURCE).append("/").append(serverId).append(ACTIONS).append(POWER_ON);
		return sb.toString();
	}

}
