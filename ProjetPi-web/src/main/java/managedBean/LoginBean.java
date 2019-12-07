package managedBean;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.User;
import services.UserService;

@ManagedBean(name = "loginBean")
@SessionScoped
public   class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private  String login;
	private String password;
	private static User uuser;
	@EJB
	UserService  us;
	public String doLogin() {
		String navigateTo = "null";
		LoginBean.uuser=us.getEmployeByEmailAndPassword(login, password);
		if (uuser != null) {
			navigateTo = "/pages/chat/messageries.jsf?face-redirect=true";
			
		} 
		return navigateTo;
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
	public static User getUuser() {
		return uuser;
	}
	public static void setUuser(User uuser) {
		LoginBean.uuser = uuser;
	}
	
}