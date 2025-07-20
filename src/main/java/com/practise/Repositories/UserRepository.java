package com.practise.Repositories;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.Employee;
import com.practise.Utility.HibernateUtility;

public class UserRepository {

	public void addData(Scanner sc) {
		Employee e = new Employee();
		sc.nextLine(); // to consume the leftover newline from previous nextInt()

		System.out.print("Enter id: ");
		int id = sc.nextInt();

		sc.nextLine();
		System.out.print("Enter employee name: ");
		String name = sc.nextLine();

		System.out.print("Enter designation: ");
		String designation = sc.nextLine();

		System.out.print("Enter department: ");
		String department = sc.nextLine();
		
		System.out.print("Enter salary: ");
		double salary = sc.nextDouble();
		

		sc.nextLine(); // again, consume newline

		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		e.setId(id);
		e.setName(name);
		e.setDesignation(designation);
		e.setSalary(salary);
		e.setDepartment(department);
		
		session.persist(e);
		transaction.commit();
		session.close();

		System.out.println("Employee Details Added successfully ");
	}
	
	public void searchData(Scanner sc) {
		
		System.out.println("Enter employee name to search: ");
		sc.nextLine(); // clear the buffer if nextInt() was used before
		String name = sc.nextLine();
		
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		List<Employee> elist = session.createQuery("FROM Employee WHERE name LIKE :name", Employee.class).setParameter("name", name).getResultList();
		System.out.println("List of Employee Details:");
		elist.stream().forEach(k -> System.out.println(k.toString()));

		transaction.commit();
		session.close();
	}
	
	public void updateData(Scanner sc) {
		System.out.println("Enter Id to update salary : ");
		int id = sc.nextInt();

		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Employee e = session.find(Employee.class, id);
		System.out.println("Enter new salary :");
		int update = sc.nextInt();

		e.setSalary(update);

		transaction.commit();
		session.close();
		System.out.println("Salary updated ");
	}
	
	public void deleteData(Scanner sc) {
		System.out.println("Enter the id to delete employee details : ");
		int id = sc.nextInt();

		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Employee e = session.find(Employee.class, id);
		session.remove(e);

		transaction.commit();
		session.close();

		System.out.println("Employee details deleted ");
	}
}
