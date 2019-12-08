package managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Candidature;
import model.Critere;
import model.CritereType;
import model.Evaluation;
import service.interf.CritereRemote;

@ManagedBean(name = "critereBean")
@SessionScoped
public class CritereBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	CritereRemote service;

	private int id;
	private String nom;
	private CritereType type;
	private int idEval;
	
	
	private List<Critere> listCriteres;
	private List<Critere> listCriteresByEval;
	
	public void ajouterCritere() {
		Critere c = new Critere();
		c.setCritereName(nom);
		c.setType(type);
		service.AddCritere(c);

	}
	public CritereBean() {
	}

	public CritereRemote getService() {
		return service;
	}

	public void setService(CritereRemote service) {
		this.service = service;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public CritereType getType() {
		return type;
	}

	public void setType(CritereType type) {
		this.type = type;
	}

	public List<Critere> getListCriteres() {
		return service.getAllCriteres();
	}

	public void setListCriteres(List<Critere> listCriteres) {
		this.listCriteres = listCriteres;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<Critere> getListCriteresByEval() {
		return service.getCritereByEval(idEval);
	}
	public void setListCriteresByEval(List<Critere> listCriteresByEval) {
		this.listCriteresByEval = listCriteresByEval;
	}
	public int getIdEval() {
		return idEval;
	}
	public void setIdEval(int idEval) {
		this.idEval = idEval;
	}

	

}
