package com.loan.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loan.entity.Loan;
import com.loan.service.LoanServiceImpl;

@RestController
public class LoanController {
	@Autowired
	private LoanServiceImpl loanService;
	
	@GetMapping("/hello")
	public String hello() {
		System.out.println("hello methods is called ");
		return "hello get() called";
	}
	

    public LoanController(LoanServiceImpl loanService) {
        this.loanService = loanService;
    }

    @GetMapping("/loans")
    public List<Loan> getAllLoans() {
        return loanService.getAllLoans();
    }

    @PostMapping("/add")
    public Loan addLoan(@RequestBody Loan loan) throws Exception {
        return loanService.addLoan(loan);
    }

    @GetMapping("/{loanId}")
    public Loan getLoanByLoanId(@PathVariable String loanId) {
        return loanService.getLoanByLoanId(loanId);
    }

    @GetMapping("/customer/{customerId}")
    public List<Loan> getLoansByCustomerId(@PathVariable String customerId) {
        return loanService.getLoansByCustomerId(customerId);
    }

    @GetMapping("/lender/{lenderId}")
    public List<Loan> getLoansByLenderId(@PathVariable String lenderId) {
        return loanService.getLoansByLenderId(lenderId);
    }
    
    @GetMapping("/aggregate/lender/{lenderId}")
    public Map<String, Double> getAggregateByLender(@PathVariable String lenderId) {
        return loanService.getAggregateByLender(lenderId);
    }

    @GetMapping("/aggregate/customer/{customerId}")
    public Map<String, Double> getAggregateByCustomerId(@PathVariable String customerId) {
        return loanService.getAggregateByCustomerId(customerId);
    }

    @GetMapping("/aggregate/interest/{interest}")
    public Map<Double, Double> getAggregateByInterest(@PathVariable double interest) {
        return loanService.getAggregateByInterest(interest);
    }

}
