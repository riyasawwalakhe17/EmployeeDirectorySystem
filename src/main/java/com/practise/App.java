package com.practise;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.practise.Repositories.UserRepository;
import com.practise.Utility.HibernateUtility;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("WELCOME TO EMPLOYEE DIRECTORY SYSTEM");
			System.out.println("Please Select as per Requirement");
			System.out.println("1. Add Employee Data");
			System.out.println("2. Search employee by name");
			System.out.println("3. Updated Salary Details");
			System.out.println("4. Get Deleted Employee Details");

			System.out.println("Please Enter your choice: ");
			int choice = sc.nextInt();

			UserRepository user = new UserRepository();
			switch (choice) {
			case 1:
				System.out.println("Please Enter User ID: ");
				int empid = sc.nextInt();
				user.addData();
				break;
				
			case 2:
				System.out.println("Please Enter Employee name: ");
				String name = sc.next();
				user.searchData();
				break;
				
			case 3:
				user.getUpdatedData();
				break;
			
			case 4:
				user.getDeletedData();
				break;
			}
    	}
    }
}
