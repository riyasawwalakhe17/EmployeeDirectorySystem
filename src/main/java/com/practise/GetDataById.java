package com.practise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.Employee;
import com.practise.Utility.HibernateUtility;

public class GetDataById {

public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		int id = 1;
		Employee employee = session.find(Employee.class, 2);
		
		transaction.commit();
		session.close();
		System.out.println("DATA for student with id " + id + " : " + employee.toString());
	}
}
