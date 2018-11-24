package fr.epita.quiz.web.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import fr.epita.quiz.datamodel.Users;
import fr.epita.quiz.services.UsersDAO;

/**
 * 
 * @author Sindhu
 *
 */
@WebServlet(urlPatterns = "/forgotPassword")
public class Password extends SpringServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LogManager.getLogger(Password.class);
	@Autowired
	private UsersDAO repository;

	/**
	 * Default constructor.
	 */
	public Password() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("forgotPassword") != null) {
			try {
				// users.setUsername(request.getParameter("username"));
				// users.setEmail(request.getParameter("email"));
				Users user = (Users) repository.getUsersByUserName(request.getParameter("username"));
				if (!user.equals(null) && (user.getMail().equals(request.getParameter("email")))) {
					request.getSession().setAttribute("user", user);
					LOGGER.info("Redirected to change password");
					response.sendRedirect("resetPassword.jsp");
				} else {
					LOGGER.error("Wrong username or Password Entered");
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			} catch (Exception e) {
				LOGGER.error("Something Went Wrong!!!");
				e.printStackTrace();
			}
		} else if (request.getParameter("resetPassword") != null) {
			try {
				Users users = new Users();
				String newPsswd = request.getParameter("newpassword");
				String verifyPassword = request.getParameter("verifypassword");
				users = repository.getUsersById(Integer.parseInt(request.getParameter("id")));
				if (newPsswd.equals(verifyPassword)) {
					users.setPsswd(newPsswd);
					repository.create(users);
					LOGGER.error("Password Changed Sucessfully!!!");
					response.sendRedirect("index.html");
				} else {
					LOGGER.warn("Password did not match!!!");
					request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
				}
			} catch (NumberFormatException e) {
				LOGGER.error("Something Went Wrong!!!");
				e.printStackTrace();
			}
		} else {
			LOGGER.error("Forget Password Request Failed");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
}
