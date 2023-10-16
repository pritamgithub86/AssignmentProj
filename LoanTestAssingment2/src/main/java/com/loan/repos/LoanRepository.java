package com.loan.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loan.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer> {

}
