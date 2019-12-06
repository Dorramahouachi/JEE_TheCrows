package tn.esprit.pidev.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.pidev.entities.UserTwo;
import tn.esprit.pidev.services.impl.UserService;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String login;
	private String password;
	static UserTwo user;
	private Boolean loggedIn;
	private String message;
	private UserTwo loggedUser;
	
	
	@EJB
	UserService userService;
	
	public String doLogin() {
		String navigateTo = "null";
		System.out.println("login est" );
		System.out.println(login);
		user = userService.getUserByEmailAndPassword(this.login, this.password);
		if (user != null ) {
			navigateTo = "/pages/admin/evaluation?faces-redirect=true"; loggedIn = true; 
			System.out.println(user.getFirstname());
		}
		else {
			this.message="Bad Credentials";
		}
	return navigateTo; 
	}

	public String logOut() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true"; 
	}
	
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}




	public UserTwo getLoggedUser() {
		return user;
	}

	public void setLoggedUser(UserTwo loggedUser) {
		this.loggedUser = loggedUser;
	}


	
	
	
	

}
