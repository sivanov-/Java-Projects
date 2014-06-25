package com.stanislav.ivanov.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.stanislav.ivanov.chat.impl.ClientHandlerImpl;


public class ServerMain {

	private static ServerSocket mServerSocket;
	private static ClientHandler clientHandler;
	private static final int LISTENING_PORT = 5555;
	
	public static void main(String[] args) {
		
		initSocket();
		
		clientHandler = new ClientHandlerImpl();
		
		waitClientConnection(clientHandler);
	}
	
	public static void initSocket () {
		try {
			mServerSocket = new ServerSocket(LISTENING_PORT);
			System.out.println("Chat server listening started on port: " + LISTENING_PORT);
			
		} catch (IOException ioe) {
			System.err.println ("Can not start listening on port:" + LISTENING_PORT);
			ioe.printStackTrace();
			System.exit(-1);
		}
		
	}
	
	private static void waitClientConnection(ClientHandler clientHandler) {
		while (true) {
			try {
				Socket socket = mServerSocket.accept();
				System.out.println("New client connected.");
				Client client = clientHandler.createNewClient(socket);
				client.sendData("Hello from the chat server");
				
			} catch (Exception e) {
				System.out.println("[ERROR] " + e.getMessage());
			}
		}
	}
}
