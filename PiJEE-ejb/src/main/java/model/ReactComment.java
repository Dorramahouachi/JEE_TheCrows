package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ReactComments database table.
 * 
 */
@Entity
@Table(name="ReactComments")
@NamedQuery(name="ReactComment.findAll", query="SELECT r FROM ReactComment r")
public class ReactComment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ReactCommentId")
	private int reactCommentId;

	@Column(name="TypeReact")
	private String typeReact;

	//bi-directional many-to-one association to Comment
	@ManyToOne
	@JoinColumn(name="CommentId")
	private Comment comment;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserId")
	private Userz user;

	public ReactComment() {
	}

	public int getReactCommentId() {
		return this.reactCommentId;
	}

	public void setReactCommentId(int reactCommentId) {
		this.reactCommentId = reactCommentId;
	}

	public String getTypeReact() {
		return this.typeReact;
	}

	public void setTypeReact(String typeReact) {
		this.typeReact = typeReact;
	}

	public Comment getComment() {
		return this.comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public Userz getUser() {
		return this.user;
	}

	public void setUser(Userz user) {
		this.user = user;
	}

}