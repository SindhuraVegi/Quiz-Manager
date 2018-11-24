package fr.epita.quiz.services;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import fr.epita.quiz.datamodel.Questions;

/**
 * 
 * @author Sindhu
 *
 */
public class QuestionDAO {

	@Inject
	@Named("questionQuery")
	String query;

	/**
	 * 
	 * @param entity
	 * @return
	 */
	protected WhereClauseBuilder<Questions> getWhereClauseBuilder(Questions entity) {
		final WhereClauseBuilder<Questions> wcb = new WhereClauseBuilder<>();
		wcb.setQueryString(query);

		final Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("question", entity.getQuestion());
		wcb.setParameters(parameters);
		return wcb;

	}

	// @Override
	// protected String getSearchQuery(Question question) {
	// return query;
	// }
	//
	// /*
	// * (non-Javadoc)
	// * @see
	// fr.epita.quiz.services.GenericHibernateDao#completeQuery(org.hibernate.query.Query)
	// */
	// @Override
	// protected void completeQuery(Question question, Query toBeCompleted) {
	//
	// toBeCompleted.setParameter("type", question.getType());
	// toBeCompleted.setParameter("question", question.getQuestion());
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.epita.quiz.services.GenericHibernateDao#getWhereClauseBuilder(java.lang.
	 * Object)
	 */

}
