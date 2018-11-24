package fr.epita.quiz.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.epita.quiz.datamodel.Questions;
import fr.epita.quiz.datamodel.Users;

/**
 * 
 * @author Sindhu
 *
 * @param <T>
 */
public abstract class GenericORMDao<T> {

	@Inject
	SessionFactory sf;

	/**
	 * 
	 * @param entity
	 */
	public final void create(T entity) {
		if (!beforeCreate(entity)) {
			return;
		}

		final Session session = sf.openSession();
		final Transaction tx = session.beginTransaction();
		session.saveOrUpdate(entity);
		tx.commit();
		session.close();
	}

	/**
	 * 
	 * @param entity
	 * @return
	 */
	protected boolean beforeCreate(T entity) {
		return entity != null;
	}

	/**
	 * 
	 * @param entity
	 */
	public final void delete(T entity) {
		final Session session = sf.openSession();
		final Transaction tx = session.beginTransaction();
		session.delete(entity);
		tx.commit();
		session.close();
	}

	/**
	 * 
	 * @param entity
	 */
	public final void deleteAll(List<T> entity) {
		final Session session = sf.openSession();
		final Transaction tx = session.beginTransaction();
		session.delete(entity);
		tx.commit();
		session.close();
	}

	/**
	 * 
	 * @param entity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public final List<T> getQuizName(T entity) {
		final Session session = sf.openSession();
		final WhereClauseBuilder<T> wcb = getWhereClauseBuilder(entity);
		final Query getTypeQuery = session.createQuery(wcb.getQueryString()).setProperties(wcb.getParameters());
		for (final Entry<String, Object> parameterEntry : wcb.getParameters().entrySet()) {
			getTypeQuery.setParameter(parameterEntry.getKey(), parameterEntry.getValue());
		}

		return getTypeQuery.list();
	}

	/**
	 * 
	 * @param entity
	 * @return
	 */
	public final List<Questions> getQuestions(Questions entity) {
		final Session session = sf.openSession();
		String hql = "from Questions s where s.quizName = :quizName";
		Query<Questions> query = session.createQuery(hql);
		query.setParameter("quizName", entity.getQuizName());
		List<Questions> result = query.getResultList();
		return result;
	}

	/**
	 * 
	 * @param entity
	 * @return
	 */
	public Collection<T> searchAll(T entity) {
		List<T> list = new ArrayList<>();
		final Session session = sf.openSession();
		list = (List<T>) session.createQuery("from Questions", Questions.class).list();
		return list;
	}

	/**
	 * 
	 * @param entity
	 * @return
	 */
	public Collection<T> searchUsers(T entity) {
		final Session session = sf.openSession();
		return (List<T>) session.createQuery("from Users", Users.class).list();
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Users getUsersById(int id) {
		final Session session = sf.openSession();
		return session.get(Users.class, id);
	}

	/**
	 * 
	 * @param username
	 * @return
	 */
	public Users getUsersByUserName(String username) {
		final Session session = sf.openSession();
		String hql = "from Users s where s.username = :username";
		Query<Users> query = session.createQuery(hql);
		query.setParameter("username", username);
		List<Users> use = query.getResultList();
		return use.get(0);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Questions getById(int id) {
		final Session session = sf.openSession();
		return session.get(Questions.class, id);
	}

	/**
	 * 
	 * @param entity
	 * @return
	 */
	public final List<T> search(T entity) {
		final Session session = sf.openSession();
		final WhereClauseBuilder<T> wcb = getWhereClauseBuilder(entity);
		final Query searchQuery = session.createQuery(wcb.getQueryString());
		for (final Entry<String, Object> parameterEntry : wcb.getParameters().entrySet()) {
			searchQuery.setParameter(parameterEntry.getKey(), parameterEntry.getValue());
		}

		return searchQuery.list();
	}

	/**
	 * 
	 * @param entity
	 * @return
	 */
	protected abstract WhereClauseBuilder getWhereClauseBuilder(T entity);

	// Old conception
	// protected abstract String getSearchQuery(T entity);
	//
	// protected abstract void completeQuery(T entity, Query toBeCompleted);

}
