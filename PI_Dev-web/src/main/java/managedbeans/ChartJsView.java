package managedbeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.primefaces.model.chart.PieChartModel;

import model.CritereType;
import service.interf.EvaluationRemote;

@ManagedBean
public class ChartJsView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PieChartModel model;

	@EJB
	EvaluationRemote evalServ;
	/*
	 * @ManagedProperty(value="#{evaluationBean}") private EvaluationBean evalBean;
	 */

	@PostConstruct
	public void init() {
		System.out.println("test7 "+ EvaluationBean.idEvalChart);
		Long n1 = evalServ.Chart(EvaluationBean.idEvalChart, CritereType.mauvais);
		Long n2 = evalServ.Chart(EvaluationBean.idEvalChart, CritereType.moyen);
		Long n3 = evalServ.Chart(EvaluationBean.idEvalChart, CritereType.bien);
		Long n4 = evalServ.Chart(EvaluationBean.idEvalChart, CritereType.parfait);
		Long nt=n1+n2+n3+n4;
		
		model = new PieChartModel();
		model.set("Mauvais", n1*100/nt);// jobs in thousands
		model.set("Moyen", n2*100/nt);
		model.set("Bien", n3*100/nt);
		model.set("Parfait", n4*100/nt);

		// followings are some optional customizations:
		// set title
		model.setTitle("Types des critères");
		// set legend position to 'e' (east), other values are 'w', 's' and 'n'
		model.setLegendPosition("e");
		// enable tooltips
		model.setShowDatatip(true);
		// show labels inside pie chart
		model.setShowDataLabels(true);
		// show label text as 'value' (numeric) , others are 'label', 'percent'
		// (default). Only one can be used.
		model.setDataFormat("value");
		// format: %d for 'value', %s for 'label', %d%% for 'percent'
		model.setDataLabelFormatString("%d%%");
		// pie sector colors
		model.setSeriesColors("aaf,afa,faa,ffa,aff,faf,ddd");
	}

	public PieChartModel getModel() {
		return model;
	}

	public EvaluationRemote getEvalServ() {
		return evalServ;
	}

	public void setEvalServ(EvaluationRemote evalServ) {
		this.evalServ = evalServ;
	}

	public ChartJsView() {
	}

}
