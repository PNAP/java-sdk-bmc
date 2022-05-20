package com.pnap.bmc_sdk.command.sshkey;

import static com.pnap.bmc_sdk.constant.ConstantContainer.SSH_KEYS_RESOURCE;

import com.pnap.bmc_sdk.client.Client;
import com.pnap.bmc_sdk.command.Command;

/**
 * Create an SSH Key. SSH Keys created can be used for server creation and reset functionality.
 * @author DCAutomation
 *
 */
public class CreateSshKeyCommand implements Command {
	
	private Client client;
	private Object body;
	
	public CreateSshKeyCommand(Client client, Object body) {
		this.client = client;
		this.body = body;
	}

	@Override
	public String execute() {
		return client.post(SSH_KEYS_RESOURCE,body);
	}


}
