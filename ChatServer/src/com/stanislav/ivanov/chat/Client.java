package com.stanislav.ivanov.chat;

public interface Client {

	void sendData(String data);
	
	void disconnect() throws Exception;
	
}
