package fr.epita.quiz.web.services.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.epita.quiz.datamodel.Users;
import fr.epita.quiz.services.UsersDAO;
import fr.epita.quiz.web.actions.SpringServlet;
import fr.epita.quiz.web.services.QuestionList;

/**
 * 
 * @author Sindhu
 *
 */
@Service
@Transactional
@WebServlet(urlPatterns = "/usersService")
public class UsersService extends SpringServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LogManager.getLogger(QuestionList.class);

	@Autowired
	UsersDAO repository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Users> usersList = (List<Users>) repository.searchUsers(new Users());
			request.getSession().setAttribute("usersList", usersList);
			LOGGER.info("Redirected Sucessfully");
			response.sendRedirect("usersList.jsp");
		} catch (Exception e) {
			LOGGER.error(e);
			e.printStackTrace();
		}
	}
}
