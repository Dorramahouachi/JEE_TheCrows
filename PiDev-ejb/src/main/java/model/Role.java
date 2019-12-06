package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Roles database table.
 * 
 */
@Entity
@Table(name="Roles")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RoleId")
	private int roleId;

	@Column(name="Description")
	private Object description;

	@Column(name="RoleName")
	private Object roleName;

	public Role() {
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public Object getDescription() {
		return this.description;
	}

	public void setDescription(Object description) {
		this.description = description;
	}

	public Object getRoleName() {
		return this.roleName;
	}

	public void setRoleName(Object roleName) {
		this.roleName = roleName;
	}

}