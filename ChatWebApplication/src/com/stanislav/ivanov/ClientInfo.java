package com.stanislav.ivanov;

import java.io.Serializable;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ClientInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	public String username;

	public Queue<String> unreadMessages = new ConcurrentLinkedQueue<>();

}
