package com.brockton.ui;

import org.apache.log4j.Logger;


import com.brockton.model.Employee;
import com.brockton.services.EmployeeService;

public class EmployeeMenu implements Menu {
	private static Logger log=Logger.getLogger(EmployeeMenu.class);
	
	public EmployeeService employeeService;
	
	public EmployeeMenu() {
		employeeService = new EmployeeService();
	}



	@Override
	public void display() {
		int choice = 0;
		do {
			log.trace("Employee Menu");
			log.trace("=============");
			log.trace("1.) Back");
			log.trace("2.) Create UN and PW");
			log.trace("Choose 1 or 2");
			
			try {
				choice = Integer.parseInt(Menu.sc.nextLine());
			} catch (NumberFormatException e) {
			}
			
			switch (choice) {
			case 1:
				break;
			case 2:
				String EmployeeSelectedUN = getcreateEmployeeUNInput();
				String EmployeeSelectedPW = getcreateEmployeePWInput();
				Employee newUNandPW = new Employee(EmployeeSelectedUN, EmployeeSelectedPW);
				employeeService.createEmployeeUnPw(newUNandPW);
				break;
			
			default:
				log.trace("No valid choice entered");	
			}
			
		} while (choice !=1);
		
	}
	
	public String getcreateEmployeeUNInput() {
		String userName;
		while (true) {
			
			log.trace("Enter Username: ");
			userName = Menu.sc.nextLine();
			
			return userName;
		}
		
	}
	
	public String getcreateEmployeePWInput() {
		String passWord;
		while (true) {
			
			log.trace("Enter Password: ");
			passWord = sc.nextLine();
			return passWord;
		}
	}

}
