package fr.epita.quiz.web.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.epita.quiz.datamodel.Questions;
import fr.epita.quiz.datamodel.TypeOFQuestions;
import fr.epita.quiz.services.CreateQuestionDAO;
import fr.epita.quiz.web.actions.SpringServlet;

/**
 * 
 * @author Sindhu
 *
 */
@Service
@Transactional
@WebServlet(urlPatterns = "/modifyQuestion")
public class ModifyQuestion extends SpringServlet {
	private static final Logger LOGGER = LogManager.getLogger(ModifyQuestion.class);

	private static final long serialVersionUID = 1L;
	@Autowired
	private CreateQuestionDAO repository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("selection") != null) {
			if (request.getParameter("modify") != null) {
				Questions editQuestion = (Questions) repository
						.getById(Integer.parseInt(request.getParameter("selection")));
				request.getSession().setAttribute("addQuestion", editQuestion);
				LOGGER.info("Redirected to Update User Sucessfully");
				if (editQuestion.getType().equals(TypeOFQuestions.MCQ)) {
					response.sendRedirect("updateQuestion.jsp");
				} else if (editQuestion.getType().equals(TypeOFQuestions.OPN)) {
					response.sendRedirect("updateOpenQuestion.jsp");
				}

			} else if (request.getParameter("delete") != null) {
				Questions deleteQuestion = (Questions) repository
						.getById(Integer.parseInt(request.getParameter("selection")));
				try {
					repository.delete(deleteQuestion);
					LOGGER.info("Question Deleted Sucessfully");
					response.sendRedirect(request.getContextPath() + "/questionList");
				} catch (DataException e) {
					LOGGER.error(e);
					e.printStackTrace();
				}
			}
		} else if (request.getParameter("update") != null) {

			final Questions updateQuestion = prepareQuestion(request);

			updateQuestions(request, response, updateQuestion);
		} else if (request.getParameter("updateOpen") != null) {

			final Questions updateQuestion = prepareOpenQuestion(request);

			updateQuestions(request, response, updateQuestion);
		}

		else if (request.getParameter("deleteAll") != null) {

			final List<Questions> deleteAllQuestions = (List<Questions>) repository.searchAll(new Questions());
			try {
				repository.deleteAll(deleteAllQuestions);
				LOGGER.info("All Questions deleted Sucessfully");
				response.sendRedirect(request.getContextPath() + "/questionAction");

			} catch (DataException e) {
				LOGGER.error(e);
				e.printStackTrace();
			}

		} else {
			LOGGER.info("Something went Wrong!!!");
			response.sendRedirect(request.getContextPath() + "/questionList");
		}

	}

	/**
	 * @param request
	 * @param response
	 * @param updateQuestion
	 * @throws IOException
	 */
	private void updateQuestions(HttpServletRequest request, HttpServletResponse response,
			final Questions updateQuestion) throws IOException {
		try {
			repository.create(updateQuestion);
			LOGGER.info("Question Updated Sucessfully");
			response.sendRedirect(request.getContextPath() + "/questionList");
		} catch (DataException e) {
			LOGGER.error(e);
			e.printStackTrace();
		}
	}

	/**
	 * @param request
	 * @return
	 * @throws NumberFormatException
	 */
	private Questions prepareQuestion(HttpServletRequest request) throws NumberFormatException {
		final Questions updateQuestion = new Questions();
		updateQuestion.setQuestion(request.getParameter("question"));
		updateQuestion.setAnswer1(request.getParameter("answer1"));
		updateQuestion.setAnswer2(request.getParameter("answer2"));
		updateQuestion.setAnswer3(request.getParameter("answer3"));
		updateQuestion.setAnswer4(request.getParameter("answer4"));
		updateQuestion.setQuizName(request.getParameter("quizName"));
		updateQuestion.setType(TypeOFQuestions.MCQ);
		updateQuestion.setCorrectanswer(request.getParameter("correctanswer"));
		updateQuestion.setId(Integer.parseInt(request.getParameter("id")));
		return updateQuestion;
	}

	private Questions prepareOpenQuestion(HttpServletRequest request) throws NumberFormatException {
		final Questions updateQuestion = new Questions();
		updateQuestion.setQuestion(request.getParameter("question"));
		updateQuestion.setAnswer1("N/A");
		updateQuestion.setAnswer2("N/A");
		updateQuestion.setAnswer3("N/A");
		updateQuestion.setAnswer4("N/A");
		updateQuestion.setQuizName(request.getParameter("quizName"));
		updateQuestion.setType(TypeOFQuestions.OPN);
		updateQuestion.setCorrectanswer("");
		updateQuestion.setId(Integer.parseInt(request.getParameter("id")));
		return updateQuestion;
	}

}
