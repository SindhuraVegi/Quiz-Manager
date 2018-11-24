package fr.epita.quiz.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Sindhu
 *
 */
@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_role_id", unique = true, nullable = false)
	private Integer userRoleId;

	@Column(name = "user_name", unique = true, nullable = false)
	private String user_name;

	@Column(name = "psswd", nullable = false)
	private String psswd;

	@Column(name = "enable", nullable = false)
	private boolean enable;

	@Column(name = "role", nullable = false)
	private TypeOfRoles role;

	@Column(name = "mail", nullable = false)
	private String mail;

	/**
	 * @return the userRoleId
	 */
	public Integer getUserRoleId() {
		return userRoleId;
	}

	/**
	 * @param userRoleId the userRoleId to set
	 */
	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	/**
	 * @return the user_name
	 */
	public String getUser_name() {
		return user_name;
	}

	/**
	 * @param user_name the user_name to set
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	/**
	 * @return the psswd
	 */
	public String getPsswd() {
		return psswd;
	}

	/**
	 * @param psswd the psswd to set
	 */
	public void setPsswd(String psswd) {
		this.psswd = psswd;
	}

	/**
	 * @return the enable
	 */
	public boolean isEnable() {
		return enable;
	}

	/**
	 * @param enable the enable to set
	 */
	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	/**
	 * @return the role
	 */
	public TypeOfRoles getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(TypeOfRoles role) {
		this.role = role;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setPassword(String parameter) {
		// TODO Auto-generated method stub
		
	}

	

}
