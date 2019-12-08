package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Word database table.
 * 
 */
@Entity
@NamedQuery(name="Word.findAll", query="SELECT w FROM Word w")
public class Word implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int wordId;

	private String type;

	private String word;

	public Word() {
	}

	public int getWordId() {
		return this.wordId;
	}

	public void setWordId(int wordId) {
		this.wordId = wordId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getWord() {
		return this.word;
	}

	public void setWord(String word) {
		this.word = word;
	}

}