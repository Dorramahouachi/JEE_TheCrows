package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Posts database table.
 * 
 */
@Entity
@Table(name="Posts")
@NamedQuery(name="Post.findAll", query="SELECT p FROM Post p")
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PostId")
	private int postId;

	@Column(name="Contenu")
	private String contenu;

	@Column(name="DatePost")
	private Date datePost;

	private int vue;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserId")
	private Userz user;

	//bi-directional many-to-one association to ReactPost
	@OneToMany(mappedBy="post")
	private List<ReactPost> reactPosts;

	public Post() {
	}

	public int getPostId() {
		return this.postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getContenu() {
		return this.contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Date getDatePost() {
		return this.datePost;
	}

	public void setDatePost(Date datePost) {
		this.datePost = datePost;
	}

	public int getVue() {
		return this.vue;
	}

	public void setVue(int vue) {
		this.vue = vue;
	}

	public Userz getUser() {
		return this.user;
	}

	public void setUser(Userz user) {
		this.user = user;
	}

	public List<ReactPost> getReactPosts() {
		return this.reactPosts;
	}

	public void setReactPosts(List<ReactPost> reactPosts) {
		this.reactPosts = reactPosts;
	}

	public ReactPost addReactPost(ReactPost reactPost) {
		getReactPosts().add(reactPost);
		reactPost.setPost(this);

		return reactPost;
	}

	public ReactPost removeReactPost(ReactPost reactPost) {
		getReactPosts().remove(reactPost);
		reactPost.setPost(null);

		return reactPost;
	}

}