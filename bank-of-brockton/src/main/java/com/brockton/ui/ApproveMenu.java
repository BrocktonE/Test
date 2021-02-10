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
		log.trace("Application Approval Menu");
		log.trace("=============");
		log.trace("1. Back");
		log.trace("2.) Approve/Reject Account");
		log.trace("Enter a choice between 1 and 2");
		
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
			log.trace("No valid Choice Enter");
		}
	} while (choice !=1);

	
}
	public int getAccountIDInput() {
		int id;
		while (true) {
			log.trace("Enter the application ID you would like to approve/reject: ");
			id = Integer.parseInt(Menu.sc.nextLine());
			
			return id;
		}
	}
	
	public String getApprovalInput() {
	String approve;
	while (true) {
		
		log.trace("Enter Y to approve, N to reject");
		approve = sc.nextLine();
		
		return approve;
	}	 
	}
	
	
	
	
	
	
	
}