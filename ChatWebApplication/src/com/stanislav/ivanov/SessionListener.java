package com.stanislav.ivanov;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {

		ClientInfo client = new ClientInfo();
		HttpSession session = event.getSession();
		Util.setCurentClient(session, client);

		List<ClientInfo> allUsers = Util.getAllUsers(session.getServletContext());
		allUsers.add(client);
		System.out.println("Currently opened sessions: " + allUsers.size());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {

		HttpSession session = event.getSession();
		ClientInfo client = Util.getCurentClient(session);

		List<ClientInfo> allUsers = Util.getAllUsers(session.getServletContext());
		allUsers.remove(client);
	}

}
