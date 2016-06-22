package org.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GoodByeServlet
 */
@WebServlet("/GoodByeServlet")
public class GoodByeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public void init()
	{
		System.out.println("Initializing the servlets.");
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		PrintWriter out = resp.getWriter();
		out.println("Good Bye");
	}

}
