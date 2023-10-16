package com.loan.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "loans")
@Entity
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String loanId;
	private String customerId;
	private String lenderId;
	private double amount;
	private double remainingAmount;
	private String paymentDate;
	private double interestPerDay;
	private String dueDate;
	private double penaltyPerDay;
	private double cancelled;

	public Loan() {

	}

	public Loan(String loanId, String customerId, String lenderId, double amount, double remainingAmount,
			String paymentDate, double interestPerDay, String dueDate, double penaltyPerDay, double cancelled) {
		super();
		this.loanId = loanId;
		this.customerId = customerId;
		this.lenderId = lenderId;
		this.amount = amount;
		this.remainingAmount = remainingAmount;
		this.paymentDate = paymentDate;
		this.interestPerDay = interestPerDay;
		this.dueDate = dueDate;
		this.penaltyPerDay = penaltyPerDay;
		this.cancelled = cancelled;
	}

	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getLenderId() {
		return lenderId;
	}

	public void setLenderId(String lenderId) {
		this.lenderId = lenderId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getRemainingAmount() {
		return remainingAmount;
	}

	public void setRemainingAmount(double remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getInterestPerDay() {
		return interestPerDay;
	}

	public void setInterestPerDay(double interestPerDay) {
		this.interestPerDay = interestPerDay;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public double getPenaltyPerDay() {
		return penaltyPerDay;
	}

	public void setPenaltyPerDay(double penaltyPerDay) {
		this.penaltyPerDay = penaltyPerDay;
	}

	public double isCancelled() {
		return cancelled;
	}

	public void setCancelled(double cancelled) {
		this.cancelled = cancelled;
	}

}
