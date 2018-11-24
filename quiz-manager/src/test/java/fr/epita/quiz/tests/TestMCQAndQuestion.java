/**
 * Ce fichier est la propriété de Thomas BROUSSARD
 * Code application :
 * Composant :
 */
package fr.epita.quiz.tests;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.datamodel.Questions;
import fr.epita.quiz.datamodel.TypeOFQuestions;
import fr.epita.quiz.datamodel.TypeOfRoles;
import fr.epita.quiz.datamodel.Users;
import fr.epita.quiz.services.CreateQuestionDAO;
import fr.epita.quiz.services.UsersDAO;

/**
 * <h3>Description</h3>
 * <p>
 * This class allows to ...
 * </p>
 *
 * <h3>Usage</h3>
 * <p>
 * This class should be used as follows:
 * 
 * <pre>
 * <code>${type_name} instance = new ${type_name}();</code>
 * </pre>
 * </p>
 *
 * @since $${version}
 * @see See also $${link}
 * @author ${user}
 *
 *         ${tags}
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TestMCQAndQuestion {

	@Inject
	CreateQuestionDAO questDAO;
	@Inject
	UsersDAO userDAO;
	@Inject
	SessionFactory factory;

	// @Test
	public void testSaveOrUpdateQuestion() {
		final Session session = factory.openSession();
		final Transaction tx = session.beginTransaction();
		final Questions question = new Questions();
		question.setQuestion("How to configure Hibernate?");
		question.setType(TypeOFQuestions.MCQ);
		question.setCorrectanswer(
				"add dependency and create a bean of session factory with data source properties and hibernate poperties injecting to Spring and propertis of java packages need to be scanned by hibenate ");
		questDAO.create(question);

		questDAO.create(question);
		tx.commit();
		session.close();
	}

	// @Test
	public void testGetQuizType() {
		final Questions question = new Questions();
		question.setType(TypeOFQuestions.MCQ);
		List<Questions> stri = questDAO.getQuizName(question);
		System.out.println(stri.size());
	}

	@Test
	public void testGetByUserName() {
		Users user = new Users();
		user = userDAO.getUsersByUserName("Sindhu");
		System.out.println(user.getUser_name());
	}

	// @Test
	public void testGetQuestionsByQuizType() {
		final Questions question = new Questions();
		question.setQuizName("test");
		List<Questions> stri = questDAO.getQuestions(question);
		System.out.println(stri.size());
	}

	// @Test
	public void testGetAllQuestions() {
		final Questions question = new Questions();
		List<Questions> questions = questDAO.getQuestions(question);
		System.out.println(questions.size());
	}

	// @Test
	public void testCreateOrUpdateUser() {
		final Session session = factory.openSession();
		final Transaction tx = session.beginTransaction();
		final Users user = new Users();
		user.setUser_name("tetuser");
		user.setMail("testmail@test.com");
		user.setPsswd("testing123");
		user.setRole(TypeOfRoles.Admin);
		user.setEnable(true);
		userDAO.create(user);
		tx.commit();
		session.close();
	}

	// @Test
	public void testGetAllUsers() {
		final Users user = new Users();
		List<Users> users = (List<Users>) userDAO.searchUsers(user);
		System.out.println(users.size());
	}

	// @Test
	public void testDeleteAllQuestion() {
		final List<Questions> question = new ArrayList<Questions>();
		questDAO.deleteAll(question);
	}

	// @Test
	public void testDeleteQuestionById() {
		final Questions ques = new Questions();
		ques.setId(101);
		questDAO.delete(ques);
	}
}
