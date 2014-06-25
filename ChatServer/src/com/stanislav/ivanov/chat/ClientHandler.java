package com.stanislav.ivanov.chat;

import java.net.Socket;

public interface ClientHandler {

	Client createNewClient(Socket socket) throws Exception;
	
}
