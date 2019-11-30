package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dorra")
public class dorra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="dorraID")
	private int dorraId;

}
