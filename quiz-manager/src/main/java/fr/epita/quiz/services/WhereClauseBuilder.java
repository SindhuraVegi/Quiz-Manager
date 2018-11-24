package fr.epita.quiz.services;

import java.util.Map;

/**
 * 
 * @author Sindhu
 *
 * @param <T>
 */
public class WhereClauseBuilder<T> {

	private Map<String, Object> parameters;
	private String queryString;

	/**
	 * @return the parameters
	 */
	public Map<String, Object> getParameters() {
		return parameters;
	}

	/**
	 * @param parameters
	 *            the parameters to set
	 */
	public void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}

	/**
	 * @return the queryString
	 */
	public String getQueryString() {
		return queryString;
	}

	/**
	 * @param queryString
	 *            the queryString to set
	 */
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

}
