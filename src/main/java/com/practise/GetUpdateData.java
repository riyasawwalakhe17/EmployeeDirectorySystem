package com.practise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.Employee;
import com.practise.Utility.HibernateUtility;

public class GetUpdateData {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Employee emp = session.find(Employee.class, 2);
		emp.setName("Riya Sawwalakhe");
		emp.setDesignation("Fullstack Developer");
		emp.setSalary(211546531);
		emp.setDepartment("IT");
		

		/*
		 * Here We need to get document first and then set it so it will change value in
		 */

		emp.getaCard().setCardNumber("AC65655");
		emp.getaCard().setIssueDate("26-02-2026");
		emp.getaCard().setActive(false);

		System.out.println("Employee Data updated successfully");
		transaction.commit();
		session.close();
	}
}
