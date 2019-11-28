package interfaces;



import java.util.ArrayList;

import java.util.List;


import javax.ejb.Local;

import model.Chat;
import model.User;

@Local
public interface ChatServiceLocal {
	void envoyerMessage(Chat c) ;
	 ArrayList<Chat> getall(int id);
	 User getUser(String login);
		public User getUser(int id);

}
