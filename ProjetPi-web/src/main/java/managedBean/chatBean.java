package managedBean;

import java.io.Serializable;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.NotNull;

import model.Chat;
import model.User;
import services.ChatService;

@ManagedBean(name = "chatBean")
@SessionScoped
public class chatBean implements Serializable {
	private int chatId ; 
	@NotNull
	private String contenu;
	private int vue;
	private List<Chat> chats;
	private List<User> users;
	private List<Chat> disc ;
	private List<Chat> ch ;
	private int idr ;
	private int ids ; 
	private String reponse ;
	

	public String getReponse() {
		return reponse;
	}
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	@EJB
	ChatService ms;
	
	
	public int getIdr() {
		return idr;
	}
	public void setIdr(int idr) {
		this.idr = idr;
	}
	public int getIds() {
		return ids;
	}
	public void setIds(int ids) {
		this.ids = ids;
	}
	
	
	public List<Chat> getCh() {
		return ch;
	}
	public void setCh(List<Chat> ch) {
		this.ch = ch;
	}
	public List<Chat> getDisc() {
		return disc;
	}
	public void setDisc(List<Chat> disc) {
		this.disc = disc;
	}
	public int getChatId() {
		return chatId;
	}
	public void setChatId(int chatId) {
		this.chatId = chatId;
	}
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
		chats=ms.getall(1,0);
	}

	
	public String add() {
		
			LoginBean lb= new LoginBean();

			Chat m = new Chat();
			m.setContenu(contenu);

			m.setUser1(ms.getUser(1));
			m.setUser2(lb.getUuser());

		String rep=	ms.envoyerMessage(m);

		if(rep.contains("refus"))
		{
			setReponse("refus");
			return "refus";
		}
		else {
			return "/pages/chat/messageries.xhtml?face-redirect=true";

		}
	
	}
	public void update()
	{Chat e= new Chat();
	e.setContenu(contenu);
		ms.updateChat(e);
		
	}
	
	public void delete (int id )
	{ 
		ms.deleteChatId1(id);
		System.out.println("id chat = "+id);

		}
	
		public void getUsrs()
		{
			users=ms.getUsrs(1);
		}
		
		
		public void getDis(int id )
		{
			disc=ms.getDisc(id);
		}
		
		
		public String aff(int id )
		{
			LoginBean lb= new LoginBean();
			setIdr(id);
			setIds(ids);
			disc=ms.getchat(id,lb.getUuser().getUserId());
			
			return "/pages/chat/chat.xhtml?face-redirect=true";

		}
	@PostConstruct
	public void init() {
		LoginBean lb= new LoginBean();
		chats=ms.getall(lb.getUuser().getUserId(),0); users=ms.getUsrs(1); disc=ms.getchat(2,lb.getUuser().getUserId());}
}
