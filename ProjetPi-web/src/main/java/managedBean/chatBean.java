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
import model.Word;
import services.ChatService;

@ManagedBean(name = "chatBean")
@SessionScoped
public class chatBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int chatId;
	@NotNull
	private String contenu;
	private int vue;
	private List<Chat> chats;
	private List<User> users;
	private List<Chat> disc;
	private List<Chat> ch;
	private int idr;
	private int ids;
	private String reponse;
	private String modifier;
	private List<Word> propo;
	private int idconnect; 
	private String nomR ;
	private int receiver ;
	private List<Chat> drop ; 
	


	
	public List<Chat> getDrop() {
		return drop;
	}

	public void setDrop(List<Chat> drop) {
		this.drop = drop;
	}

	public int getReceiver() {
		return receiver;
	}

	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}

	public String getNomR() {
		return nomR;
	}

	public void setNomR(String nomR) {
		this.nomR = nomR;
	}

	public int getIdconnect() {
		return idconnect;
	}

	public void setIdconnect(int idconnect) {
		this.idconnect = idconnect;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

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
		LoginBean lb = new LoginBean();

		chats = ms.getall(lb.getUuser().getUserId(), 0);
	}

	public String add(int idrev) {

		LoginBean lb = new LoginBean();

		Chat m = new Chat();
		m.setContenu(contenu);
		User r =ms.getUser(idrev);
		m.setUser1(r);
		m.setUser2(lb.getUuser());

		String rep = ms.envoyerMessage(m);

		if (rep.contains("refus")) {
			setReponse("refus");
			return "refus";
		} else {
			return "/pages/chat/messageries.xhtml?face-redirect=true";

		}

	}
	
	
	public String addP(int idrev, String cont) {

		LoginBean lb = new LoginBean();

		Chat m = new Chat();
		m.setContenu(cont);
		User r =ms.getUser(idrev);
		m.setUser1(r);
		m.setUser2(lb.getUuser());

		String rep = ms.envoyerMessage(m);

		
			return "/pages/chat/messageries.xhtml?face-redirect=true";

		

	}

	public void update(int id) {
		Chat e = new Chat();
		e.setChatId(id);
		e.setContenu(modifier);
		ms.updateChat(e);

	}

	public void delete(int id) {
		ms.deleteChatId1(id);
		System.out.println("id chat = " + id);

	}

	public void getUsrs() {
		LoginBean lb = new LoginBean();

		users = ms.getUsrs(lb.getUuser().getUserId());
	}

	public void getDis(int id) {
		disc = ms.getDisc(id);
	}

	public String aff(int id, int idc) {
		ms.upVue(idc);
		LoginBean lb = new LoginBean();

		this.disc = ms.getchat(id, lb.getUuser().getUserId());
		propo = ms.getProp(id,lb.getUuser().getUserId());
		nomR=ms.getRecei(id);
		receiver=ms.getidRecei(id);

		return "/pages/chat/temp.xhtml?face-redirect=true";

	}

	public String OneDisc(int id) {
		LoginBean lb = new LoginBean();

		this.disc = ms.getchat(id, lb.getUuser().getUserId());
		propo = ms.getProp(id,lb.getUuser().getUserId());
		nomR=ms.getRecei(id);
		receiver=ms.getidRecei(id);

		return "/pages/chat/temp.xhtml?face-redirect=true";

	}
	public void test() {
		LoginBean lb = new LoginBean();
		disc = ms.getchat(lb.getUuser().getUserId(), ids);
		propo = ms.getProp(ids,lb.getUuser().getUserId());
		nomR=ms.getRecei(ids);
		receiver=ms.getidRecei(ids);

	}

	public void jdida(int id) {
		this.ids = id;
	}

	@PostConstruct
	public void init() {
		LoginBean lb = new LoginBean();
		chats = ms.getall(lb.getUuser().getUserId(), 0);
		users = ms.getUsrs(1);
		this.idconnect=lb.getUuser().getUserId();
		drop=ms.dropList(lb.getUuser().getUserId());


	}

	public List<Word> getPropo() {
		return propo;
	}

	public void setPropo(List<Word> propo) {
		this.propo = propo;
	}
}
