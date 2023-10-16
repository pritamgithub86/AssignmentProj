package com.loan.service;

import java.util.List;
import java.util.Map;

import com.loan.entity.Loan;

public interface LoanService {

	List<Loan> getAllLoans();

	Loan addLoan(Loan loan) throws Exception;

	Loan getLoanByLoanId(String loanId);

	List<Loan> getLoansByCustomerId(String customerId);

	List<Loan> getLoansByLenderId(String lenderId);

	Map<String, Double> getAggregateByLender(String lenderId);

	Map<String, Double> getAggregateByCustomerId(String customerId);

	Map<Double, Double> getAggregateByInterest(double interest);

}
