package org.test.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jnit.dao.CustomerDao;
import org.jnit.domain.Customer;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Cookie[] cookie = request.getCookies();
		boolean isUserLoggedin = false;
		/*if((cookie!=null)&&cookie.length>0 )
		{
			for (Cookie cookie2 : cookie) 
			{
				if (cookie2.getName().equals("username"))
				{
					isUserLoggedin = true;
				}
			}
		}*/
		HttpSession session = request.getSession(false);
		if(session!= null)
		{
			isUserLoggedin = true;
		}
		//session.setAttribute("uname", request.getParameter("userName"));
		if(isUserLoggedin)
		{
			CustomerDao custDao = new CustomerDao();
			Customer customer = new Customer();
			customer.setStreet(request.getParameter("street"));
			customer.setCity(request.getParameter("city"));
			customer.setName(request.getParameter("name"));
			customer.setState(request.getParameter("state"));
			customer.setCountry(request.getParameter("country"));
			customer.setZipCode(request.getParameter("ZipCode"));
			int noOfRows = custDao.insertCustomer(customer);
			if(noOfRows == 1)
			{
				response.getWriter().println(customer.getName() + " has been successfully saved.");
			}
		}
		else
		{
			request.getRequestDispatcher("login.html").forward(request, response);
		}
	}

}
