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
	@Column(name="ReactCommentId")
	private int reactCommentId;

	@Column(name="TypeReact")
	private Object typeReact;

	//bi-directional many-to-one association to Comment
	@ManyToOne
	@JoinColumn(name="CommentId")
	private Comment comment;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserId")
	private User user;

	public ReactComment() {
	}

	public int getReactCommentId() {
		return this.reactCommentId;
	}

	public void setReactCommentId(int reactCommentId) {
		this.reactCommentId = reactCommentId;
	}

	public Object getTypeReact() {
		return this.typeReact;
	}

	public void setTypeReact(Object typeReact) {
		this.typeReact = typeReact;
	}

	public Comment getComment() {
		return this.comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}