package com.brockton.ui;

import org.apache.log4j.Logger;


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
			log.trace("Employee Login");
			log.trace("==============");
			log.trace("1.) Back");
			log.trace("2.) Login");
			
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
				log.trace(employee);
				
				if (employee != null) {
					Menu employeeActionMenu = new EmployeeActionMenu();
					employeeActionMenu.display();
					
				} else {
					log.trace("login credentials not found");
				}
				
			} catch (EmployeeNotFoundException e) {
				log.error(e.getMessage());
			} catch (DatabaseConnectionException e) {
				log.error(e.getStackTrace());
			}
			
			break;
			default:
				log.trace("No valid choice entered");
		}
		
	} while (choice !=1);

}
	public String getcreateEmployeeUNInput() {
		String userName;
		while (true) {
			
			log.trace("Enter userName: ");
			userName = Menu.sc.nextLine();
			
			return userName;						
					
		}
	}

	public String getcreateEmployeePWInput() {
		String passWord;
		while (true) {
			
			log.trace("Enter your Password: ");
			passWord = Menu.sc.nextLine();
			return passWord;
		}
	}
	
}
	
	
	
	
	
	
	
	
	
	