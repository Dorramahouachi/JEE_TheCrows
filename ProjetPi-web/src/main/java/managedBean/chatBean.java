package managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Chat;
import model.User;
import services.ChatService;

@ManagedBean(name = "chatBean")
@SessionScoped
public class chatBean implements Serializable {
	private String contenu;
	private int vue;
	private List<Chat> chats;
	private List<User> users;

	@EJB
	ChatService ms;
	
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public int getVue() {
		return vue;
	}
	public void setVue(int vue) {
		this.vue = vue;
	}
	public List<Chat> getChats() {
		return chats;
	}
	public void setChats(List<Chat> chats) {
		this.chats = chats;
	}
	
	public chatBean(List<Chat> chats, List<User> users, ChatService ms) {
		super();
		this.chats = chats;
		this.users = users;
		this.ms = ms;
	}
	public chatBean() {
		super();
	}
	public void getall() {
		chats=ms.getall(1);
	}

	
	public String add() {
		Chat m = new Chat();
		m.setContenu(contenu);

		m.setUser1(ms.getUser(1));
		m.setUser2(ms.getUser(2));

		ms.envoyerMessage(m);

		return "/pages/chat/messageries.xhtml?face-redirect=true";
	}

	
		public void getUsrs()
		{
			users=ms.getUsrs(1);
		}
	@PostConstruct
	public void init() {chats=ms.getall(2); users=ms.getUsrs(1);}
}
