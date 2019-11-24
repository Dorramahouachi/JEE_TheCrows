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

	private Object actualPost;

	private Object address;

	private Object bio;

	private Timestamp birthDate;

	@Column(name="Country")
	private Object country;

	@Column(name="Discriminator")
	private Object discriminator;

	private Object experience;

	private Object lastname;

	private Object login;

	@Column(name="Mail")
	private Object mail;

	private Object name;

	private Object password;

	private long phoneContact;

	private Object picture;

	@Column(name="Skills")
	private Object skills;

	//bi-directional many-to-one association to Candidature
	@OneToMany(mappedBy="user")
	private List<Candidature> candidatures;

	//bi-directional many-to-one association to Chat
	@OneToMany(mappedBy="user1")
	private List<Chat> chats1;

	//bi-directional many-to-one association to Chat
	@OneToMany(mappedBy="user2")
	private List<Chat> chats2;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="user")
	private List<Comment> comments;

	//bi-directional many-to-one association to Contact
	@OneToMany(mappedBy="user")
	private List<Contact> contacts;

	//bi-directional many-to-one association to Entrepris
	@OneToMany(mappedBy="user")
	private List<Entrepris> entreprises;

	//bi-directional many-to-one association to Post
	@OneToMany(mappedBy="user")
	private List<Post> posts;

	//bi-directional many-to-one association to ReactComment
	@OneToMany(mappedBy="user")
	private List<ReactComment> reactComments;

	//bi-directional many-to-one association to ReactPost
	@OneToMany(mappedBy="user")
	private List<ReactPost> reactPosts;

	//bi-directional many-to-many association to Offer
	@ManyToMany
	@JoinTable(
		name="Candidatures"
		, joinColumns={
			@JoinColumn(name="candidatureId")
			}
		, inverseJoinColumns={
			@JoinColumn(name="candidatureId")
			}
		)
	private List<Offer> offers;

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

	public Object getActualPost() {
		return this.actualPost;
	}

	public void setActualPost(Object actualPost) {
		this.actualPost = actualPost;
	}

	public Object getAddress() {
		return this.address;
	}

	public void setAddress(Object address) {
		this.address = address;
	}

	public Object getBio() {
		return this.bio;
	}

	public void setBio(Object bio) {
		this.bio = bio;
	}

	public Timestamp getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
	}

	public Object getCountry() {
		return this.country;
	}

	public void setCountry(Object country) {
		this.country = country;
	}

	public Object getDiscriminator() {
		return this.discriminator;
	}

	public void setDiscriminator(Object discriminator) {
		this.discriminator = discriminator;
	}

	public Object getExperience() {
		return this.experience;
	}

	public void setExperience(Object experience) {
		this.experience = experience;
	}

	public Object getLastname() {
		return this.lastname;
	}

	public void setLastname(Object lastname) {
		this.lastname = lastname;
	}

	public Object getLogin() {
		return this.login;
	}

	public void setLogin(Object login) {
		this.login = login;
	}

	public Object getMail() {
		return this.mail;
	}

	public void setMail(Object mail) {
		this.mail = mail;
	}

	public Object getName() {
		return this.name;
	}

	public void setName(Object name) {
		this.name = name;
	}

	public Object getPassword() {
		return this.password;
	}

	public void setPassword(Object password) {
		this.password = password;
	}

	public long getPhoneContact() {
		return this.phoneContact;
	}

	public void setPhoneContact(long phoneContact) {
		this.phoneContact = phoneContact;
	}

	public Object getPicture() {
		return this.picture;
	}

	public void setPicture(Object picture) {
		this.picture = picture;
	}

	public Object getSkills() {
		return this.skills;
	}

	public void setSkills(Object skills) {
		this.skills = skills;
	}

	public List<Candidature> getCandidatures() {
		return this.candidatures;
	}

	public void setCandidatures(List<Candidature> candidatures) {
		this.candidatures = candidatures;
	}

	public Candidature addCandidature(Candidature candidature) {
		getCandidatures().add(candidature);
		candidature.setUser(this);

		return candidature;
	}

	public Candidature removeCandidature(Candidature candidature) {
		getCandidatures().remove(candidature);
		candidature.setUser(null);

		return candidature;
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

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setUser(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setUser(null);

		return comment;
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

	public List<ReactComment> getReactComments() {
		return this.reactComments;
	}

	public void setReactComments(List<ReactComment> reactComments) {
		this.reactComments = reactComments;
	}

	public ReactComment addReactComment(ReactComment reactComment) {
		getReactComments().add(reactComment);
		reactComment.setUser(this);

		return reactComment;
	}

	public ReactComment removeReactComment(ReactComment reactComment) {
		getReactComments().remove(reactComment);
		reactComment.setUser(null);

		return reactComment;
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

	public List<Offer> getOffers() {
		return this.offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
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

}