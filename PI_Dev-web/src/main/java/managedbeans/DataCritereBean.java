package managedbeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import model.CritereType;

@ManagedBean(name = "dataCritere")
@ApplicationScoped
public class DataCritereBean {

	public DataCritereBean() {
		// TODO Auto-generated constructor stub
	}

	public CritereType[] getTypes() {
		return CritereType.values();
		}
}