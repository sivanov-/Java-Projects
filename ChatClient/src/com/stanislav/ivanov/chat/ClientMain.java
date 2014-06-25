package com.stanislav.ivanov.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientMain {

	private static final String SERVER_HOSTNAME = "localhost";
	private static final int SERVER_PORT = 5555;
	private static PrintWriter socketWriter;
	private static BufferedReader socketReader;

	public static void main(String[] args) {

		// Connect to the server
		try {
			// TODO: close the socket on exit.
			Socket socket = new Socket(SERVER_HOSTNAME, SERVER_PORT);
			socketReader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			socketWriter = new PrintWriter(new OutputStreamWriter(
					socket.getOutputStream()));
			System.out.println(" Connected to server " + SERVER_HOSTNAME + ": "
					+ SERVER_PORT);
		} catch (IOException ioe) {
			System.err.println("Cannot connect to " + SERVER_HOSTNAME + ": "
					+ SERVER_PORT);
			ioe.printStackTrace();
			System.exit(-1);
		}
		
		// socket -> console data transmit
		PrintWriter consoleWriter = new PrintWriter(System.out);
		TextDataTransmitter t1 = new TextDataTransmitter(socketReader, consoleWriter);
		t1.start();
		
		// console -> socket data transmit
		ConsoleDataTransmitter t2 = new ConsoleDataTransmitter(socketWriter);
		t2.start();

	}

}
