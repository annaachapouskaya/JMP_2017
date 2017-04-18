package com.epam.achapouskaya;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7898145435614628407L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		SimpleService service = new SimpleService();
		service.runService();

	}

}
