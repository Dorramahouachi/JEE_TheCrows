package interfaces;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import model.Chat;
import model.User;

@Remote
public interface ChatServiceRemote {
	void envoyerMessage(Chat c) ;
	 ArrayList<Chat> getall(int id);
	 User getUser(String login);
	public User getUser(int id);


}
