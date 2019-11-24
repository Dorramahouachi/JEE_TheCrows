package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Comments database table.
 * 
 */
@Entity
@Table(name="Comments")
@NamedQuery(name="Comment.findAll", query="SELECT c FROM Comment c")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CommentId")
	private int commentId;

	@Column(name="Contenu")
	private Object contenu;

	@Column(name="DateComment")
	private Timestamp dateComment;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserId")
	private User user;

	//bi-directional many-to-one association to ReactComment
	@OneToMany(mappedBy="comment")
	private List<ReactComment> reactComments;

	public Comment() {
	}

	public int getCommentId() {
		return this.commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public Object getContenu() {
		return this.contenu;
	}

	public void setContenu(Object contenu) {
		this.contenu = contenu;
	}

	public Timestamp getDateComment() {
		return this.dateComment;
	}

	public void setDateComment(Timestamp dateComment) {
		this.dateComment = dateComment;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ReactComment> getReactComments() {
		return this.reactComments;
	}

	public void setReactComments(List<ReactComment> reactComments) {
		this.reactComments = reactComments;
	}

	public ReactComment addReactComment(ReactComment reactComment) {
		getReactComments().add(reactComment);
		reactComment.setComment(this);

		return reactComment;
	}

	public ReactComment removeReactComment(ReactComment reactComment) {
		getReactComments().remove(reactComment);
		reactComment.setComment(null);

		return reactComment;
	}

}