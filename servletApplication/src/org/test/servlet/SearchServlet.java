package org.test.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jnit.dao.CustomerDao;
import org.jnit.domain.Customer;


@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerDao custDao = new CustomerDao();
		List<Customer>customers = null;
		String action = request.getParameter("action");
		if(action.equals("SearchByCity"))
		{
			customers = custDao.fetchCustomerbyCity(request.getParameter("cityorstate"));
		}
		else if(action.equals("SearchByState"))
		{
			customers = custDao.fetchCustomerbyState(request.getParameter("cityorstate"));
		}
		//List<Customer>customers = custDao.fetchCustomerbyCity(request.getParameter("city"));
		StringBuffer sb = new StringBuffer("<table border = 1>");
		sb.append("<td>CustomerId</td><td>Name</td><td>City</td><td>Street</td><td>State</td><td>Country</td>");
		for (Customer customer : customers) {
			sb.append("<tr><td>");
			sb.append(customer.getCustomerId());
			sb.append("</td><td>");
			sb.append(customer.getName());
			sb.append("</td><td>");
			sb.append(customer.getCity());
			sb.append("</td><td>");
			sb.append(customer.getStreet());
			sb.append("</td><td>");;
			sb.append(customer.getState());
			sb.append("</td><td>");
			sb.append(customer.getCountry());
			sb.append("</td></tr>");
		}
		sb.append("</table>");
		response.getWriter().println(sb.toString());
	}

	/**
	 * @see HttpServlet#doTrace(HttpServletRequest, HttpServletResponse)
	 */
	protected void doTrace(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
