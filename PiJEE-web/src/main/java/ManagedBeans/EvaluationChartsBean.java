package ManagedBeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import model.Evaluation;
import ManagedBeans.PieChartData.KeyValue;

@ManagedBean(name="evaluationCharts")
@RequestScoped
public class EvaluationChartsBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String pieChartData;
	private List<KeyValue> pieDataList;
	
	@ManagedProperty(value= "#{PieChartData}")
	private PieChartData charts;

	
	public String getPieChartData() {
		if (pieChartData == null || pieChartData.trim().length() <= 0) {
			populateData();
		}
		return pieChartData;
	}
	
	private void populateData() {
		StringBuilder stringBuilder = new StringBuilder();
		for (KeyValue pieData : getPieDataList()) {
			stringBuilder.append("[");
			stringBuilder.append("'");
			stringBuilder.append(pieData.getKey());
			stringBuilder.append("'");
			stringBuilder.append(",");
			stringBuilder.append(pieData.getValue());
			stringBuilder.append("]");
			stringBuilder.append(",");
		}
		pieChartData = stringBuilder.toString().substring(0, stringBuilder.toString().length());
	}
	public List<KeyValue> getPieDataList() {
		System.out.println("aaaaaaaaaayaaaaaaaaaaaaaaaaaaaa" + charts.getPieDataList());
		return  charts.getPieDataList();
	}
	public void setPieDataList(List<KeyValue> pieDataList) {
		this.pieDataList = pieDataList;
	}
	public void setPieChartData(String pieChartData) {
		this.pieChartData = pieChartData;
	}

	public PieChartData getCharts() {
		return charts;
	}

	public void setCharts(PieChartData charts) {
		this.charts = charts;
	}
	
	
}
