package managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Chat;
import services.ChatService;

@ManagedBean(name = "DiscussionBean")
@SessionScoped
public class DiscussionBean implements Serializable{
	private int idR;
	private int idS;
	List<Chat> chats ;
	@EJB
	ChatService ms;
	public int getIdR() {
		return idR;
	}
	public void setIdR(int idR) {
		this.idR = idR;
	}
	public int getIdS() {
		return idS;
	}
	public void setIdS(int idS) {
		this.idS = idS;
	}
	public List<Chat> getChats() {
		return chats;
	}
	public void setChats(List<Chat> chats) {
		this.chats = chats;
	}
public String test ( int id2)
{
		LoginBean lb= new LoginBean();

	chats= ms.getchat(lb.getUuser().getUserId(), id2);
setIdS(id2);

return "/pages/chat/chat.xhtml?face-redirect=true";}
@PostConstruct
public void init() {
	LoginBean lb= new LoginBean();
	chats= ms.getchat(lb.getUuser().getUserId(), getIdS());
	}

}
