package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import model.User;



@Remote
public interface UserServiceRemote {
 
	public List<User> getAllUsers();
	public List<String> getAllUserNames();
	public Long addUser(User user);
	public void updateUser(User user);
	public User getUserByEmailAndPassword(String email, String password) ;
	public User getUserById(int id);
	public List<User> getUsesDistinctFromLoggedUser(int id);
}