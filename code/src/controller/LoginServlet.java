package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Messages;
import model.User;
import repository.UserManagement;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserManagement usermanagement ; 
       
    public LoginServlet() {
       usermanagement = new UserManagement();
       }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("index.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username  = request.getParameter("username");
		String password = request.getParameter("password");
		User u = usermanagement.getUser(username, password);

		if((username.equals("admin")) && (password.equals("admin")))
			response.sendRedirect("Admin");
		else if(u == null) {
		Messages message = new Messages(1, "username or password wrong !");
			request.setAttribute("message", message);
			request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	else {
		HttpSession session = request.getSession();
		session.setAttribute("user", u);
		response.sendRedirect("profil.jsp");
	}
	
	}

}
