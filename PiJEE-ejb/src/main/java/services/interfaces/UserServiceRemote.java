package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import model.Userz;



@Remote
public interface UserServiceRemote {
 
	public List<Userz> getAllUsers();
	public List<String> getAllUserNames();
	public int addUser(Userz user);
	public void updateUser(Userz user);
	public Userz getUserByEmailAndPassword(String email, String password) ;
	public Userz getUserById(int id);
	public List<Userz> getUsesDistinctFromLoggedUser(int id);
}