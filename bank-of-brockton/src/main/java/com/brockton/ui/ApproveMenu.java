package com.brockton.ui;

import org.apache.log4j.Logger;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.services.ApproveService;

public class ApproveMenu implements Menu {
	private static Logger log=Logger.getLogger(ApproveMenu.class);
	
	public ApproveService approveService;
	
	ApproveMenu() {
		
		approveService =new ApproveService();
	}
	
	
	
	
	
	

	@Override
	public void display() {
	int choice = 0;
	
	do {
		System.out.println("Application Approval Menu");
		System.out.println("=============");
		System.out.println("1. Back");
		System.out.println("2.) Approve/Reject Account");
		System.out.println("Enter a choice between 1 and 2");
		
		try {
			choice = Integer.parseInt(Menu.sc.nextLine());
		} catch (NumberFormatException e) {
		}
		
		switch (choice) {
		case 1:
			break;
		case 2:
			int id = getAccountIDInput();
			String approve = getApprovalInput();
			try {
				approveService.approveAccount(id, approve);
			} catch (DatabaseConnectionException e) {
				
				e.printStackTrace();
			}
			
			break;
		default:
			System.out.println("No valid Choice Enter");
		}
	} while (choice !=1);

	
}
	public int getAccountIDInput() {
		int id;
		while (true) {
			System.out.println("Enter the application ID you would like to approve/reject: ");
			id = Integer.parseInt(Menu.sc.nextLine());
			
			return id;
		}
	}
	
	public String getApprovalInput() {
	String approve;
	while (true) {
		
		System.out.println("Enter Y to approve, N to reject");
		approve = sc.nextLine();
		
		return approve;
	}	 
	}
	
	
	
	
	
	
	
}