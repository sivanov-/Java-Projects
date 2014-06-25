package com.stanislav.ivanov.chat;

import java.io.BufferedReader;
import java.io.PrintWriter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TextDataTransmitter extends Thread {
	
	private final BufferedReader reader;
	private final PrintWriter writer;
	protected ObjectMapper mapper;
	
	public TextDataTransmitter(BufferedReader reader, PrintWriter writer) {
		this.reader = reader;
		this.writer = writer;
		mapper = new ObjectMapper();
	}

	@Override
	public void run() {
		try {
			while (!isInterrupted()) {
				String data = reader.readLine();
				data = beforeSendData(data);
				writer.println(data);
				writer.flush();
			}
		} catch (Exception ex) {
			System.err.println("Lost connection to the server");
			System.exit(-1);
		}
	}
	
	/**
	 * Hook that allows descendant classes to modify the data before being sent.
	 * @param data Original data
	 * @return The data to send to the server
	 */
	protected String beforeSendData(String data) throws Exception {
		return data;
	}
	
}
