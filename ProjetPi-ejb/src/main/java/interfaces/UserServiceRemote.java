package interfaces;

import javax.ejb.Remote;
import javax.persistence.TypedQuery;

import model.User;

@Remote

public interface UserServiceRemote {
	public User getEmployeByEmailAndPassword(String login , String password );
}
