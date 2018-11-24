package fr.epita.quiz.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Sindhu
 */

@Entity
public class Questions {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(unique = true, nullable = false)
	private String question;

	private String answer1;

	private String answer2;

	private String answer3;

	private String answer4;

	private String correctanswer;
	@Column(nullable = false)
	private TypeOFQuestions type;
	@Column(nullable = false)
	private String quizName;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	/**
	 * @return the answer1
	 */
	public String getAnswer1() {
		return answer1;
	}
	/**
	 * @param answer1 the answer1 to set
	 */
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	/**
	 * @return the answer2
	 */
	public String getAnswer2() {
		return answer2;
	}
	/**
	 * @param answer2 the answer2 to set
	 */
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	/**
	 * @return the answer3
	 */
	public String getAnswer3() {
		return answer3;
	}
	/**
	 * @param answer3 the answer3 to set
	 */
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	/**
	 * @return the answer4
	 */
	public String getAnswer4() {
		return answer4;
	}
	/**
	 * @param answer4 the answer4 to set
	 */
	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}
	/**
	 * @return the correctanswer
	 */
	public String getCorrectanswer() {
		return correctanswer;
	}
	/**
	 * @param correctanswer the correctanswer to set
	 */
	public void setCorrectanswer(String correctanswer) {
		this.correctanswer = correctanswer;
	}
	/**
	 * @return the type
	 */
	public TypeOFQuestions getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(TypeOFQuestions type) {
		this.type = type;
	}
	/**
	 * @return the quizName
	 */
	public String getQuizName() {
		return quizName;
	}
	/**
	 * @param quizName the quizName to set
	 */
	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}

	

}