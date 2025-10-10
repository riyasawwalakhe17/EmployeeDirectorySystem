package com.practise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.Employee;

import com.practise.Utility.HibernateUtility;

public class GetDeleteById {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Employee emp = session.find(Employee.class, 1);
		session.remove(emp);

		System.out.println("Data deleted successfully");
		transaction.commit();
		session.close();
	}
}
