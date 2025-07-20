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
			System.out.println("1. Add new employee");
			System.out.println("2. Search employee by name");
			System.out.println("3. Update salary");
			System.out.println("4. Delete employee by ID");

			System.out.println("Please Enter your choice: ");
			int choice = sc.nextInt();

			UserRepository user = new UserRepository();
			switch (choice) {
			case 1:
				user.addData(sc);
				break;

			case 2:
				user.searchData(sc);
				break;

			case 3:
				user.updateData(sc);
				break;

			case 4:
				user.deleteData(sc);
				break;
			}

		}
    }
}
