package interfaces;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import model.Chat;
import model.User;
import model.Word;

@Remote
public interface ChatServiceRemote {
	String envoyerMessage(Chat c) ;
	 ArrayList<Chat> getall(int id , int vue);
	public User getUser(int id);
	 ArrayList<User> getUsrs(int id);
	 public void deleteChatId(int id) ;
	 void updateChat(Chat e);
	 ArrayList<Chat> getDisc(int id);
	 ArrayList<Chat> getchat(int idR, int idS);
	 void upVue(int id);
	 ArrayList<Word> getProp(int ids , int idr);
	 String getRecei ( int idr);
	 int getidRecei ( int idr);
	 ArrayList<Chat> dropList(int id );







}
