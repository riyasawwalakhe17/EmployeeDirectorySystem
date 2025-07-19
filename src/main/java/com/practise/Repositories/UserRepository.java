package com.practise.Repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.Employee;

import com.practise.Utility.HibernateUtility;

public class UserRepository {

	public void addData() {
		
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Employee e = new Employee();
		e.setId(7);
		e.setName("Prajkta Chawre");
		e.setDesignation("Customer Service Representative ");
		e.setSalary(500000);
		e.setDepartment("BPO Department");
		
		session.persist(e);
		transaction.commit();
		session.close();
	}
	
	public void searchData() {
		
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		List<Employee> elist = session.createQuery("FROM Employee WHERE name LIKE :name", Employee.class).setParameter("name", "%Riya%").getResultList();
		System.out.println("List of Employee Details:");
		elist.stream().forEach(k -> System.out.println(k.toString()));

		transaction.commit();
		session.close();
	}
	
	public void getUpdatedData() {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("Updated Salary Details:");
		Employee e = session.find(Employee.class, 2);
		e.setSalary(1000000);
		

		transaction.commit();
		session.close();
	}
	
	public void getDeletedData() {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("Deleted Employee Details:");
		Employee e = session.find(Employee.class, 7);
		session.remove(e);

		transaction.commit();

		session.close();
	}
}
