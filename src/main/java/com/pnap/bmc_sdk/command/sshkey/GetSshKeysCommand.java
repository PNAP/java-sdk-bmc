package com.pnap.bmc_sdk.command.sshkey;

import static com.pnap.bmc_sdk.constant.ConstantContainer.SSH_KEYS_RESOURCE;

import com.pnap.bmc_sdk.client.Client;
import com.pnap.bmc_sdk.command.Command;

/**
 * List all SSH Keys.
 * @author DCAutomation
 *
 */
public class GetSshKeysCommand implements Command {
	
	/**
	 * Client
	 */
	private Client client;
	
	public GetSshKeysCommand(Client client) {
		this.client = client;
	}
	
	@Override
	public String execute() {
		return this.client.get(SSH_KEYS_RESOURCE);
	}

}
