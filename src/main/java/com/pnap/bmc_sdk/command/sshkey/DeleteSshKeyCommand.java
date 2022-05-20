package com.pnap.bmc_sdk.command.sshkey;

import static com.pnap.bmc_sdk.constant.ConstantContainer.SSH_KEYS_RESOURCE;

import com.pnap.bmc_sdk.client.Client;
import com.pnap.bmc_sdk.command.Command;

/**
 * Delete an SSH Key.
 * @author DCAutomation
 *
 */
public class DeleteSshKeyCommand implements Command {
	
	/**
	 * The SSH Key's ID.
	 */
	private String sshKeyId;
	private Client client;
	
	public DeleteSshKeyCommand(Client client, String sshKeyId) {
		this.client = client;
		this.sshKeyId = sshKeyId;
	}

	@Override
	public String execute() {
		String resourceUrl = getResourceUrl(this.sshKeyId);
		return client.delete(resourceUrl);
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
