package models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ReactPosts database table.
 * 
 */
@Entity
@Table(name="ReactPosts")
@NamedQuery(name="ReactPost.findAll", query="SELECT r FROM ReactPost r")
public class ReactPost implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ReactPostId")
	private int reactPostId;

	@Column(name="TypeReact")
	private String typeReact;

	//bi-directional many-to-one association to Post
	@ManyToOne
	@JoinColumn(name="PostId")
	private Post post;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserId")
	private User user;

	public ReactPost() {
	}

	public int getReactPostId() {
		return this.reactPostId;
	}

	public void setReactPostId(int reactPostId) {
		this.reactPostId = reactPostId;
	}

	public String getTypeReact() {
		return this.typeReact;
	}

	public void setTypeReact(String typeReact) {
		this.typeReact = typeReact;
	}

	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}