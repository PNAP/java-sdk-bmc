package com.pnap.bmc_sdk.command;

import static com.pnap.bmc_sdk.constant.ConstantContainer.*;

import com.pnap.bmc_sdk.client.Client;

/**
 * Reboot specific server
 * @author DCAutomation
 *
 */
public class RebootServerCommand implements Command {

	/**
	 * Client
	 */
	private Client client;
	
	/**
	 * Server id
	 */
	private String serverId;
	
	public RebootServerCommand(Client client, String serverId) {
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
	 * @return {String} Resource url			Example:/servers/{serverId}/actions/reboot
	 */
	private String getResourceUrl(String serverId) {
		StringBuilder sb = new StringBuilder();
		sb.append(SERVERS_RESOURCE).append("/").append(serverId).append(ACTIONS).append(REBOOT);
		return sb.toString();
	}

}
