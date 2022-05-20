package com.pnap.bmc_sdk.command.sshkey;

import static com.pnap.bmc_sdk.constant.ConstantContainer.SSH_KEYS_RESOURCE;

import com.pnap.bmc_sdk.client.Client;
import com.pnap.bmc_sdk.command.Command;

/**
 * Edit SSH Key details.
 * @author DCAutomation
 *
 */
public class UpdateSshKeyCommand implements Command {
	
	/**
	 * The SSH Key's ID.
	 */
	private String sshKeyId;
	
	/**
	 * Client
	 */
	private Client client;
	
	/**
	 * Request body
	 */
	private Object body;
	
	public UpdateSshKeyCommand(Client client, String sshKeyId, Object body) {
		this.client = client;
		this.sshKeyId = sshKeyId;
		this.body = body;
	}

	@Override
	public String execute() {
		String resourceUrl = getResourceUrl(this.sshKeyId);
		return this.client.put(resourceUrl,this.body);
	}
	
	/**
	 * Returns resource url
	 * @param sshKeyId
	 * @return {String} Resource url -> Example:/ssh-keys/{ssh_key_id}
	 */
	private String getResourceUrl(String sshKeyId) {
		StringBuilder sb = new StringBuilder();
		sb.append(SSH_KEYS_RESOURCE).append("/").append(sshKeyId);
		return sb.toString();
	}
	
}
