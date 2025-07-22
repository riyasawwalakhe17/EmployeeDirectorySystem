package com.practise.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "accesscard_details")
public class AccessCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    private String cardNumber;
    
    private String issueDate;
    
    private boolean active;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "AccessCard [id=" + id + ", cardNumber=" + cardNumber + ", issueDate=" + issueDate + ", active=" + active
				+ "]";
	}
    
    
    
}
