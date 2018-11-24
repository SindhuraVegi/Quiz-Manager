package fr.epita.quiz.web.actions;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;

import fr.epita.quiz.datamodel.TypeOfRoles;
import fr.epita.quiz.datamodel.Users;
import fr.epita.quiz.services.AuthenticationService;
import fr.epita.quiz.services.UsersDAO;

/**
 * @author Sindhu
 * 
 *         Servlet implementation class Login
 */

@WebServlet(urlPatterns = "/login")
public class Login extends SpringServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LogManager.getLogger(Login.class);

	@Inject
	AuthenticationService auth;
	@Autowired
	private UsersDAO repository;

	/**
	 * Default constructor.
	 */
	public Login() {
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

		if (request.getParameter("login") != null) {
			try {
				final String login = request.getParameter("login");
				final String password = request.getParameter("password");

				List<Users> users = (List<Users>) repository.searchUsers(new Users());
				for (Users user : users) {
					if (user.getUser_name().equals(login) && user.getPsswd().equals(password)) {
						final boolean authenticated = auth.authenticate(login, password);
						request.getSession().setAttribute("authenticated", authenticated);
						request.getSession().setAttribute("userName", login);
						if (user.getRole().name().equals(TypeOfRoles.Admin.name())) {
							LOGGER.info("Admin Login Sucessfully");
							response.sendRedirect("selectQuestionType.jsp");
						} else if (user.getRole().name().equals(TypeOfRoles.User.name())) {
							LOGGER.info("User Login Sucessfully");
							response.sendRedirect("selectQuiz.jsp");

						}
					}
				}
			} catch (Exception e) {
				LOGGER.error(e);
				LOGGER.info("Incorrect User Name or Password");
				e.printStackTrace();
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}

		} else if (request.getParameter("registerAdmin") != null) {
			try {
				createUsers(request, response, TypeOfRoles.Admin);
				LOGGER.info("Admin Registered Sucessfully");
			} catch (Exception e) {
				LOGGER.error(e);
				e.printStackTrace();
			}

		} else if (request.getParameter("registerUser") != null) {
			try {
				createUsers(request, response, TypeOfRoles.User);
				LOGGER.info("User Registered Sucessfully");
			} catch (Exception e) {
				LOGGER.error(e);
				e.printStackTrace();
			}

		} else {
			LOGGER.error("Login Authentication Failed");
			request.getSession().setAttribute("authenticated", false);
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @param roleType
	 * @throws ServletException
	 * @throws IOException
	 */
	private void createUsers(HttpServletRequest request, HttpServletResponse response, TypeOfRoles roleType)
			throws ServletException, IOException {
		final Users user = prepareUser(request, roleType);
		try {
			repository.create(user);
			LOGGER.info("User Registered Sucessfully");
			response.sendRedirect(request.getContextPath() + "/index.html");
		} catch (DataException e) {
			LOGGER.error(e);
			e.printStackTrace();
		}
	}

	/**
	 * @param request
	 * @param roleType
	 * @return
	 */
	private Users prepareUser(HttpServletRequest request, TypeOfRoles roleType) {
		final Users user = new Users();
		user.setUser_name(request.getParameter("user_name"));
		user.setPsswd(request.getParameter("psswd"));
		user.setMail(request.getParameter("mail"));
		user.setEnable(true);
		user.setRole(roleType);
		return user;
	}

}
