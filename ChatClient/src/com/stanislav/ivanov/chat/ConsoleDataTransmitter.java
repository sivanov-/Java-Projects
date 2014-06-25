package com.stanislav.ivanov.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ConsoleDataTransmitter extends TextDataTransmitter {

	public ConsoleDataTransmitter(PrintWriter writer) {
		super(new BufferedReader(new InputStreamReader(System.in)), writer);
	}

	/**
	 * Serialize the user input as JSON command.
	 */
	@Override
	protected String beforeSendData(String data) throws Exception {
		
		SendBroadcastCommand cmd = new SendBroadcastCommand();
		cmd.message = data;
		
		String json = mapper.writeValueAsString(cmd);
		return json;
	}
}
