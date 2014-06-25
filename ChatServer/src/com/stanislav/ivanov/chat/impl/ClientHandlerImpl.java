package com.stanislav.ivanov.chat.impl;

import java.io.IOException;
import java.net.Socket;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stanislav.ivanov.chat.Client;
import com.stanislav.ivanov.chat.ClientCallback;
import com.stanislav.ivanov.chat.ClientHandler;
import com.stanislav.ivanov.chat.Command;
import com.stanislav.ivanov.chat.SendBroadcastCommand;
import com.stanislav.ivanov.chat.SendPrivateMessageCommand;

public class ClientHandlerImpl implements ClientHandler {

	private Map<UUID, Client> clients;
	private ObjectMapper mapper;
	
	public ClientHandlerImpl() {
		clients = new ConcurrentHashMap<>();
		mapper = new ObjectMapper();
	} 
	
	public Client createNewClient(Socket socket) throws Exception {
		
		final UUID clientId = UUID.randomUUID();
		final Client client = new ClientImpl(socket, new ClientCallback() {
			
			@Override
			public void onError(Exception ex) {
				
				Client client = clients.get(clientId);
				if (client == null) {
					return;
				}
				
				try {
					client.disconnect();
				} catch (Exception e) {
				}
				
				clients.remove(clientId);
			}
			
			@Override
			public void onDataReceived(String jsonData) {
				
				Command command = null;
				try {
					command = mapper.readValue(jsonData, Command.class);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
				
				if (command instanceof SendBroadcastCommand) {
					SendBroadcastCommand cmd = (SendBroadcastCommand) command;
					broadbastMessage(cmd.message);
					
				} else if (command instanceof SendPrivateMessageCommand) {
					SendPrivateMessageCommand cmd = (SendPrivateMessageCommand) command;
					
				}
				
			}

			
		});
		
		clients.put(clientId, client);
		
		return client;
	}
	
	private void broadbastMessage(String data) {
		for (Client c : clients.values()) {
			c.sendData(data);
		}
	}
}
