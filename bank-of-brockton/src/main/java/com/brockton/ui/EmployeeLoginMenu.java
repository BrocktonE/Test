package com.brockton.ui;

import org.apache.log4j.Logger;

import com.brockton.dao.CustomerDAOImpl;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.exceptions.EmployeeNotFoundException;
import com.brockton.model.Employee;
import com.brockton.services.EmployeeLoginService;

public class EmployeeLoginMenu implements Menu {
	private static Logger log=Logger.getLogger(EmployeeLoginMenu.class);

	public EmployeeLoginService employeeLoginService;
	
	public EmployeeLoginMenu () {
		
		employeeLoginService = new EmployeeLoginService();
	}

	@Override
	public void display() {
		int choice = 0;
		
		do {
			System.out.println("Employee Login");
			System.out.println("==============");
			System.out.println("1.) Back");
			System.out.println("2.) Login");
			
		try {
			choice = Integer.parseInt(Menu.sc.nextLine());
		} catch (NumberFormatException e) {
		}
		
		switch (choice) {
		case 1:
			break;
		case 2:
			String userName = getcreateEmployeeUNInput();
			String passWord = getcreateEmployeePWInput();
			try {
				Employee employee = employeeLoginService.lookforUNPW(userName, passWord);
				System.out.println(employee);
				
				if (employee != null) {
					Menu employeeActionMenu = new EmployeeActionMenu();
					employeeActionMenu.display();
					
				} else {
					System.out.println("login credentials not found");
				}
				
			} catch (EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (DatabaseConnectionException e) {
				e.printStackTrace();
			}
			
			break;
			default:
				System.out.println("No valid choice entered");
		}
		
	} while (choice !=1);

}
	public String getcreateEmployeeUNInput() {
		String userName;
		while (true) {
			
			System.out.println("Enter userName: ");
			userName = Menu.sc.nextLine();
			
			return userName;						
					
		}
	}

	public String getcreateEmployeePWInput() {
		String passWord;
		while (true) {
			
			System.out.println("Enter your Password: ");
			passWord = sc.nextLine();
			return passWord;
		}
	}
	
}
	
	
	
	
	
	
	
	
	
	