package com.stanislav.ivanov;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendMessageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		ClientInfo currentUser = Util.getCurentClient(req.getSession());
		if (currentUser == null || currentUser.username == null) {
			// The user is not logged in.
			resp.sendError(-100, "User is not logged in");
			return;
		}

		List<ClientInfo> allUsers = Util.getAllUsers(this.getServletContext());

		String message = currentUser.username + ": " + req.getParameter("msg");
		String recepient = req.getParameter("recepient");

		if (recepient == null) {
			// Broadcast to all users
			for (ClientInfo client : allUsers) {
				if (client != currentUser) {	// Do not send back to the current user
					client.unreadMessages.add(message);
				}
			}

		} else {
			// Find the user
			for (ClientInfo client : allUsers) {
				if (client.username == recepient) {
					client.unreadMessages.add(message);
					break;
				}
			}
		}
	}


}
