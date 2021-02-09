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
			System.out.println("Employee Menu");
			System.out.println("=============");
			System.out.println("1.) Back");
			System.out.println("2.) Create UN and PW");
			System.out.println("Choose 1 or 2");
			
			try {
				choice = Integer.parseInt(Menu.sc.nextLine());
			} catch (NumberFormatException e) {
			}
			
			switch (choice) {
			case 1:
				break;
			case 2:
				String EmployeeSelectedUN = getcreateEmployeeUNInput();
				String EmployeeSelectedPW = getcreateEmployeeUNInput();
				Employee newUNandPW = new Employee(EmployeeSelectedUN, EmployeeSelectedPW);
				employeeService.createEmployeeUnPw(newUNandPW);
				break;
			
			default:
				System.out.println("No valid choice entered");	
			}
			
		} while (choice !=1);
		
	}
	
	public String getcreateEmployeeUNInput() {
		String userName;
		while (true) {
			
			System.out.println("Enter Username: ");
			userName = sc.nextLine();
			return userName;
		}
	}
	
	public String getcreateEmployeePWInput() {
		String passWord;
		while (true) {
			
			System.out.println("Enter PassWord: ");
			passWord = sc.nextLine();
			return passWord;
		}
	}

}
