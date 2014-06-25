package com.stanislav.ivanov;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

public class Util {

	private static final String USERS_LIST_ATTR_NAME = "usersMapServletContextAttributeName";

	private static final String CLIENT_INFO_ATTR_NAME = "clientInfoSessionAttributeName";

	/**
	 * @return Return synchronized list with all currently active users.
	 */
	@SuppressWarnings("unchecked")
	public static List<ClientInfo> getAllUsers(ServletContext servletContext) {

		synchronized(servletContext) {
			List<ClientInfo> allUsers = (List<ClientInfo>) servletContext.getAttribute(USERS_LIST_ATTR_NAME);
			if (allUsers == null) {
				allUsers = Collections.synchronizedList(new ArrayList<ClientInfo>());
				servletContext.setAttribute(USERS_LIST_ATTR_NAME, allUsers);
			}
			return allUsers;
		}

	}

	public static ClientInfo getCurentClient(HttpSession session) {
		return (ClientInfo) session.getAttribute(CLIENT_INFO_ATTR_NAME);
	}

	public static void setCurentClient(HttpSession session, ClientInfo client) {
		session.setAttribute(CLIENT_INFO_ATTR_NAME, client);
	}

}
