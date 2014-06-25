package com.stanislav.ivanov.chat;

public interface ClientCallback {

	void onDataReceived(String data);
	
	void onError(Exception ex);
	
}
