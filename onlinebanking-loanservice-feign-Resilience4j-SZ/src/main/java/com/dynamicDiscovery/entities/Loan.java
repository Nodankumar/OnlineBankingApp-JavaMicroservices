package com.dynamicDiscovery.entities;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Loan {
    
    private Long loan_id;

	private boolean accepted;
    private String loanType;
    
	
    private User user;
    
    public Loan() {
    	
    }
    
    public boolean isAccepted() {
        return accepted;
    }
    
    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public Long getLoan_id() {
		return loan_id;
	}


	public void setLoan_id(Long loan_id) {
		this.loan_id = loan_id;
	}


	public Loan(Long loan_id, boolean accepted, String loanType, User user) {
		super();
		this.loan_id = loan_id;
		this.accepted = accepted;
		this.loanType = loanType;
		this.user = user;
	}

}
