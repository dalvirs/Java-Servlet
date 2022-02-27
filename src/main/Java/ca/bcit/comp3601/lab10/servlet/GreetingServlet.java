package ca.bcit.comp3601.lab10.servlet;

/**
 * @author Dalvir Chiount, A01258927
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.bcit.comp3601.lab10.InitParams;

public class GreetingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	InitParams parameters = new InitParams();

	@Override
	public void init() throws ServletException {
		
		parameters.setInstruction(getServletConfig().getInitParameter("instruction"));
		parameters.setGreeting(getServletConfig().getInitParameter("greeting"));
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("parameter", parameters);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("name");
		if (firstName != null && firstName.trim().length() > 0) {
			request.setAttribute("parameter", parameters);
			request.setAttribute("name", firstName);
			request.getRequestDispatcher("results.jsp").forward(request, response);
		} else {
			doGet(request, response);
		}
	}
}
