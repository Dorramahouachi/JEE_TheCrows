package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Users database table.
 * 
 */
@Entity
@Table(name="Users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="UserId")
	private int userId;

	private String bio;

	private Timestamp birthDate;

	@Column(name="CreateDate")
	private Timestamp createDate;

	@Column(name="Discriminator")
	private String discriminator;

	@Column(name="Email")
	private String email;

	@Column(name="FirstName")
	private String firstName;

	@Column(name="IsActive")
	private boolean isActive;

	private String lastname;

	private String password;

	private long phoneContact;

	@Column(name="Username")
	private String username;

	//bi-directional many-to-one association to Chat
	@OneToMany(mappedBy="user1")
	private List<Chat> chats1;

	//bi-directional many-to-one association to Chat
	@OneToMany(mappedBy="user2")
	private List<Chat> chats2;

	//bi-directional many-to-one association to Contact
	@OneToMany(mappedBy="user")
	private List<Contact> contacts;

	//bi-directional many-to-one association to Entrepris
	@OneToMany(mappedBy="user")
	private List<Entrepris> entreprises;

	//bi-directional many-to-one association to Post
	@OneToMany(mappedBy="user")
	private List<Post> posts;

	//bi-directional many-to-one association to ReactPost
	@OneToMany(mappedBy="user")
	private List<ReactPost> reactPosts;

	//bi-directional many-to-one association to Subscribe
	@OneToMany(mappedBy="user")
	private List<Subscribe> subscribes;

	public User() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getBio() {
		return this.bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Timestamp getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getDiscriminator() {
		return this.discriminator;
	}

	public void setDiscriminator(String discriminator) {
		this.discriminator = discriminator;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhoneContact() {
		return this.phoneContact;
	}

	public void setPhoneContact(long phoneContact) {
		this.phoneContact = phoneContact;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Chat> getChats1() {
		return this.chats1;
	}

	public void setChats1(List<Chat> chats1) {
		this.chats1 = chats1;
	}

	public Chat addChats1(Chat chats1) {
		getChats1().add(chats1);
		chats1.setUser1(this);

		return chats1;
	}

	public Chat removeChats1(Chat chats1) {
		getChats1().remove(chats1);
		chats1.setUser1(null);

		return chats1;
	}

	public List<Chat> getChats2() {
		return this.chats2;
	}

	public void setChats2(List<Chat> chats2) {
		this.chats2 = chats2;
	}

	public Chat addChats2(Chat chats2) {
		getChats2().add(chats2);
		chats2.setUser2(this);

		return chats2;
	}

	public Chat removeChats2(Chat chats2) {
		getChats2().remove(chats2);
		chats2.setUser2(null);

		return chats2;
	}

	public List<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public Contact addContact(Contact contact) {
		getContacts().add(contact);
		contact.setUser(this);

		return contact;
	}

	public Contact removeContact(Contact contact) {
		getContacts().remove(contact);
		contact.setUser(null);

		return contact;
	}

	public List<Entrepris> getEntreprises() {
		return this.entreprises;
	}

	public void setEntreprises(List<Entrepris> entreprises) {
		this.entreprises = entreprises;
	}

	public Entrepris addEntrepris(Entrepris entrepris) {
		getEntreprises().add(entrepris);
		entrepris.setUser(this);

		return entrepris;
	}

	public Entrepris removeEntrepris(Entrepris entrepris) {
		getEntreprises().remove(entrepris);
		entrepris.setUser(null);

		return entrepris;
	}

	public List<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Post addPost(Post post) {
		getPosts().add(post);
		post.setUser(this);

		return post;
	}

	public Post removePost(Post post) {
		getPosts().remove(post);
		post.setUser(null);

		return post;
	}

	public List<ReactPost> getReactPosts() {
		return this.reactPosts;
	}

	public void setReactPosts(List<ReactPost> reactPosts) {
		this.reactPosts = reactPosts;
	}

	public ReactPost addReactPost(ReactPost reactPost) {
		getReactPosts().add(reactPost);
		reactPost.setUser(this);

		return reactPost;
	}

	public ReactPost removeReactPost(ReactPost reactPost) {
		getReactPosts().remove(reactPost);
		reactPost.setUser(null);

		return reactPost;
	}

	public List<Subscribe> getSubscribes() {
		return this.subscribes;
	}

	public void setSubscribes(List<Subscribe> subscribes) {
		this.subscribes = subscribes;
	}

	public Subscribe addSubscribe(Subscribe subscribe) {
		getSubscribes().add(subscribe);
		subscribe.setUser(this);

		return subscribe;
	}

	public Subscribe removeSubscribe(Subscribe subscribe) {
		getSubscribes().remove(subscribe);
		subscribe.setUser(null);

		return subscribe;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastname=" + lastname + ", username="
				+ username + "]";
	}
	
	
	

}