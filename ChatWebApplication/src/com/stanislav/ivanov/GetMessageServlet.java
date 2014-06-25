package com.stanislav.ivanov;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetMessageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		ClientInfo currentUser = Util.getCurentClient(req.getSession());
		if (currentUser == null || currentUser.username == null) {
			// The user is not logged in.
			resp.sendError(-100, "User is not logged in");
			return;
		}

		StringBuilder result = new StringBuilder();
		while(currentUser.unreadMessages.size() > 0) {
			String message = currentUser.unreadMessages.poll();
			result.append(message);
			result.append('\n');
		}

		resp.getWriter().write(result.toString());
		resp.getWriter().flush();

	}


}
