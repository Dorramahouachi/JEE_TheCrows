package model;
import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;





@Entity
public class Skills implements Serializable {

	private static final long serialVersionUID = 1L;
	 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String skillsname;
	
	private String note;
	
	private String descreption;
	
	
	

	public Skills() {

	}

	public Skills(int id, String skillsname, String note, String descreption) {

		this.id = id;
		this.skillsname = skillsname;
		this.note = note;
		this.descreption = descreption;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSkillsname() {
		return skillsname;
	}

	public void setSkillsname(String skillsname) {
		this.skillsname = skillsname;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDescreption() {
		return descreption;
	}

	public void setDescreption(String descreption) {
		this.descreption = descreption;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
