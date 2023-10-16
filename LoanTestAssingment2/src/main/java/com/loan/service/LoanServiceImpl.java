package com.loan.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.entity.Loan;
import com.loan.repos.LoanRepository;

@Service
public class LoanServiceImpl implements LoanService {
	@Autowired
	private LoanRepository loanRepository;
	 private List<Loan> loans;

	    public LoanServiceImpl() {
	        this.loans = new ArrayList<>();
	    }

	    @Override
	    public List<Loan> getAllLoans() {
	        return loans;
	    }

	    @Override
	    public Loan addLoan(Loan loan) throws Exception {
	        if (loan.getDueDate().compareTo(loan.getPaymentDate()) < 0) {
	            throw new Exception("Payment date can't be greater than the due date.");
	        }
	        loans.add(loan);
	        return loan;
	    }

	    @Override
	    public Loan getLoanByLoanId(String loanId) {
	        for (Loan loan : loans) {
	            if (loan.getLoanId().equals(loanId)) {
	                return loan;
	            }
	        }
	        return null;
	    }

	    @Override
	    public List<Loan> getLoansByCustomerId(String customerId) {
	        List<Loan> result = new ArrayList<>();
	        for (Loan loan : loans) {
	            if (loan.getCustomerId().equals(customerId)) {
	                result.add(loan);
	            }
	        }
	        return result;
	    }

	    @Override
	    public List<Loan> getLoansByLenderId(String lenderId) {
	        List<Loan> result = new ArrayList<>();
	        for (Loan loan : loans) {
	            if (loan.getLenderId().equals(lenderId)) {
	                result.add(loan);
	            }
	        }
	        return result;
	    }
	    
	    @Override
	    public Map<String, Double> getAggregateByLender(String lenderId) {
	        double totalRemainingAmount = 0;
	        double totalInterest = 0;
	        double totalPenalty = 0;

	        for (Loan loan : loans) {
	            if (loan.getLenderId().equals(lenderId)) {
	                totalRemainingAmount += loan.getRemainingAmount();
	                totalInterest += (loan.getInterestPerDay() * loan.getAmount() * (loan.getDueDate().compareTo(loan.getPaymentDate())));
	                totalPenalty += (loan.getPenaltyPerDay() * loan.getAmount() * (loan.getDueDate().compareTo(loan.getPaymentDate())));
	            }
	        }

	        Map<String, Double> result = new HashMap<>();
	        result.put("TotalRemainingAmount", totalRemainingAmount);
	        result.put("TotalInterest", totalInterest);
	        result.put("TotalPenalty", totalPenalty);

	        return result;
	    }

	    @Override
	    public Map<String, Double> getAggregateByCustomerId(String customerId) {
	        double totalRemainingAmount = 0;
	        double totalInterest = 0;
	        double totalPenalty = 0;

	        for (Loan loan : loans) {
	            if (loan.getCustomerId().equals(customerId)) {
	                totalRemainingAmount += loan.getRemainingAmount();
	                totalInterest += (loan.getInterestPerDay() * loan.getAmount() * (loan.getDueDate().compareTo(loan.getPaymentDate())));
	                totalPenalty += (loan.getPenaltyPerDay() * loan.getAmount() * (loan.getDueDate().compareTo(loan.getPaymentDate())));
	            }
	        }

	        Map<String, Double> result = new HashMap<>();
	        result.put("TotalRemainingAmount", totalRemainingAmount);
	        result.put("TotalInterest", totalInterest);
	        result.put("TotalPenalty", totalPenalty);

	        return result;
	    }

	    @Override
	    public Map<Double, Double> getAggregateByInterest(double interest) {
	        double totalRemainingAmount = 0;
	        double totalInterest = 0;
	        double totalPenalty = 0;

	        for (Loan loan : loans) {
	            if (loan.getInterestPerDay() == interest) {
	                totalRemainingAmount += loan.getRemainingAmount();
	                totalInterest += (loan.getInterestPerDay() * loan.getAmount() * (loan.getDueDate().compareTo(loan.getPaymentDate())));
	                totalPenalty += (loan.getPenaltyPerDay() * loan.getAmount() * (loan.getDueDate().compareTo(loan.getPaymentDate())));
	            }
	        }

	        Map<Double, Double> result = new HashMap<>();
	        result.put(totalRemainingAmount, totalInterest);
	        result.put(totalRemainingAmount, totalPenalty);

	        return result;
	    }
}
