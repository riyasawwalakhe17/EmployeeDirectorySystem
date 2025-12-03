package com.practise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.AccessCard;
import com.practise.Entity.Employee;
import com.practise.Utility.HibernateUtility;

public class SavingData {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		AccessCard acard = new AccessCard();
		acard.setCardNumber("AC5865454");
		acard.setIssueDate("25-04-2025");
		acard.setActive(true);

		Employee emp = new Employee();
		emp.setName("Shivani wange");
		emp.setDesignation("backend developer");
		emp.setSalary(80000000);
		emp.setDepartment("IT");
		emp.setaCard(acard);

		System.out.println("Employee Data saved successfully");
		session.persist(emp);
		transaction.commit();
		session.close();

	}
}
