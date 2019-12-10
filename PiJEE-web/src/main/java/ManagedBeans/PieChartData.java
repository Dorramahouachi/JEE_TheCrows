package ManagedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Evaluation;
import model.Userz;
import services.impl.EvaluationService;
import services.impl.UserService;

@ManagedBean(name="PieChartData")
@ApplicationScoped
public class PieChartData implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@EJB
	EvaluationService evaluationService;
	@EJB
	UserService users;
	private List<Evaluation> evaluations;

	private static List<KeyValue> pieDataList;
	 private static List<Userz> userlist;

	public  List<KeyValue> getPieDataList() {
		pieDataList = new ArrayList<PieChartData.KeyValue>();
		evaluations =  evaluationService.getAllEvaluations();
		userlist = users.getAllUsers();
		//	System.out.println("hhhihi"+ userlist);
			for(Userz e : userlist) {
//				String fullName = e.getReceiver().getFirstname() + " " + e.getReceiver().getLastname();
				pieDataList.add(new KeyValue(e.getFirstname(), e.getPhoneNumber()));
				
			}
		
		return pieDataList;
	}
	
	
	public List<Evaluation> getEvaluations() {
		return evaluationService.getAllEvaluations();
	}


	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}


	public static class KeyValue {
		String key;
		String value;
		public KeyValue(String key, String value) {
			super();
			this.key = key;
			this.value = value;
		}
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
	}
}