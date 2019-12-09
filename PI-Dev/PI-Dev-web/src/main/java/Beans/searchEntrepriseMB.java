package Beans;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.ejb.ApplicationException;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import models.Entrepris;
import services.entrepriseServiceRemote;

@ManagedBean(name="searchEntrepriseMB")
@ApplicationException
public class searchEntrepriseMB {

	@EJB
	private entrepriseServiceRemote metier ;
	private List<Entrepris> listEntr;
	private List<Entrepris> listEntrdetails;
	private String data;
	private static int idDetail;
	private Entrepris e;
	
	
	
	public Entrepris getE() {
		return e;
	}
	public void setE(Entrepris e) {
		this.e = e;
	}
	public static int getIdDetail() {
		return idDetail;
	}
	public static void setIdDetail(int idDetail) {
		searchEntrepriseMB.idDetail = idDetail;
	}
	public List<Entrepris> getListEntr() {
		this.setListEntr(this.metier.getAll());
		return listEntr;
	}
	public void setListEntr(List<Entrepris> listEntr) {
		this.listEntr = listEntr;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public entrepriseServiceRemote getMetier() {
		return metier;
	}
	public void setMetier(entrepriseServiceRemote metier) {
		this.metier = metier;
	}
	public List<Entrepris> AllEntreprises(){
		this.setListEntr(metier.getAll());
		return this.getListEntr();
	}
	public String search() {
		this.AllEntreprises();
		return "success" ;
	}
	public String goDetails(int idEnt) {
		this.setE(metier.getOne(idEnt));
		return "details";
	}
	public List<Entrepris> getListEntrdetails() {
		return listEntrdetails;
	}
	public void setListEntrdetails(List<Entrepris> listEntrdetails) {
		this.listEntrdetails = listEntrdetails;
	}
	
	
}
