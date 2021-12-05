package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Messages;
import model.User;
import repository.UserManagement;

/**
 * Servlet implementation class signup
 */
public class signup extends HttpServlet {
	UserManagement usermanagement ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup() {
    	usermanagement = new UserManagement();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("signup.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User u =new User(0,request.getParameter("email"),
				request.getParameter("name"),request.getParameter("surname"),
				request.getParameter("username"),request.getParameter("pass1"));
		if( usermanagement.verifUserByUsername(request.getParameter("username"))) {
			Messages message= new Messages(1,"user already exist ! please choose another one");
			request.setAttribute("message", message);
			request.getRequestDispatcher("signup.jsp").forward(request,response);
			
		}
		else if(!request.getParameter("pass1").equals(request.getParameter("pass2"))) {
			Messages message= new Messages(1,"password not match ! ");
			request.setAttribute("message", message);
			request.getRequestDispatcher("signup.jsp").forward(request,response);
			
		}
		else {
			usermanagement.addUser(u);
			Messages message= new Messages(2, "success ! you can login now");
			request.setAttribute("message", message);
			request.getRequestDispatcher("index.jsp").forward(request,response);
			
		}
		
	}

}
