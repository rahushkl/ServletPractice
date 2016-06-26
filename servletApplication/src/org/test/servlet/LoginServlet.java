package org.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.setContentType("text/html");
		System.out.println(request.getParameter("username"));
		System.out.println(request.getParameter("password"));
		PrintWriter out = response.getWriter();
		//.forward(request, response)
		if("rahul".equals(request.getParameter("username")))
		{
			if("raman".equals(request.getParameter("password")))
			{
				Cookie cookie = new Cookie("username", request.getParameter("username"));
				response.addCookie(cookie);
				HttpSession session = request.getSession();
				session.setAttribute("uname", request.getParameter("userName"));
				out.println("Welcome to your login page.");
				request.getRequestDispatcher("register.html").forward(request, response);
			}
			else
			{
				out.println("Please check your username or password.");
				request.getRequestDispatcher("login.html").forward(request, response);
			}
		}
		else
		{
			out.println("Please check your username or password: ");
			request.getRequestDispatcher("login.html").forward(request, response);
		}
		//out.println("Welcome to your login page.");
	}

}
