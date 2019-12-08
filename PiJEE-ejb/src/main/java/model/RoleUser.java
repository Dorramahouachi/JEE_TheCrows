//package model;
//
//import java.io.Serializable;
//import javax.persistence.*;
//
//
///**
// * The persistent class for the RoleUsers database table.
// * 
// */
//@Entity
//@Table(name="RoleUsers")
//@NamedQuery(name="RoleUser.findAll", query="SELECT r FROM RoleUser r")
//public class RoleUser implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	@EmbeddedId
//	private RoleUserPK id;
//
//	public RoleUser() {
//	}
//
//	public RoleUserPK getId() {
//		return this.id;
//	}
//
//	public void setId(RoleUserPK id) {
//		this.id = id;
//	}
//
//}