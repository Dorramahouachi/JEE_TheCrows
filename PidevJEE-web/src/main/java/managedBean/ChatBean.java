package managedBean;
import java.io.Serializable;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import model.Chat;
import services.ChatService;



@ManagedBean(name = "ChatBean")
@SessionScoped
public class ChatBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String contenu;
	private int vue; 
	private List<Chat> chats;
	
	public List<Chat> getChats() {
		return chats;
	}


	public ChatBean() {
		super();
	}


	public void setChats(List<Chat> chats) {
		this.chats = chats;
	}


	@EJB
	ChatService chatService;
	@ManagedProperty(value="#{ChattBean}")
	private ChatBean chatBean;
	
	public ChatBean getChatBean() {
		return chatBean;
	}


	public void setChatBean(ChatBean chatBean) {
		this.chatBean = chatBean;
	}


	public String add()
	{Chat m = new Chat();
	m.setContenu(contenu);
	
	m.setUser1(chatService.getUser(1));
	m.setUser2(chatService.getUser(2));

	chatService.envoyerMessage(m);

	return "/pages/chat/messageries.jsf?face-redirect=true";
	}

	public ChatBean( List<Chat> chats, ChatService chatService) {
		super();
		this.chats = chats;
		this.chatService = chatService;
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



	

	public ChatService getChatService() {
		return chatService;
	}

	public void setChatService(ChatService chatService) {
		this.chatService = chatService;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	@PostConstruct
	public void init() {chats=chatService.getall(1);}
}
