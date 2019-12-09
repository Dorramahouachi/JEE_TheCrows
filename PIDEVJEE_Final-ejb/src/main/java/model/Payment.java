package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;


/**
 * The persistent class for the Payments database table.
 * 
 */
@Entity
@Table(name="Payments")
@NamedQuery(name="Payment.findAll", query="SELECT p FROM Payment p")
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PaymentId")
	private int paymentId;

	@Column(name="Amount")
	private double amount;

	@Column(name="DatePayment")
	private Date datePayment;

	public Payment() {
	}

	public int getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDatePayment() {
		return this.datePayment;
	}

	public void setDatePayment(Date datePayment) {
		this.datePayment = datePayment;
	}

}