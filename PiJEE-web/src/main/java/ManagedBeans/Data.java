package ManagedBeans;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import model.enums.EvaluationType;
import model.enums.Role;


@ManagedBean(name = "data")
@ApplicationScoped
public class Data implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
		public Role[] getRoles() {
			return Role.values();
		}
		
		public EvaluationType[] getEvaluationTypes() {
			return EvaluationType.values();
		}

}