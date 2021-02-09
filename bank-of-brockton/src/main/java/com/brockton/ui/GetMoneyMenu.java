package com.brockton.ui;

import org.apache.log4j.Logger;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.services.CompleteTransferService;
import com.brockton.services.GiveTransferService;
import com.brockton.services.RemoveTransferService;

public class GetMoneyMenu implements Menu {
	private static Logger log=Logger.getLogger(GetMoneyMenu.class);
	public GiveTransferService giveTransferService;
	public CompleteTransferService completeTransferService;
	public RemoveTransferService removeTransferService;
	
	public GetMoneyMenu() {
		completeTransferService = new CompleteTransferService();
		giveTransferService = new GiveTransferService();
		removeTransferService = new RemoveTransferService();
		
	}
	

	@Override
	public void display() {
		int choice = 0;
		do {
			System.out.println("Pending Transfer Menu");
			System.out.println("======================================");
			System.out.println("1.) Back");
			System.out.println("2.) Accept Transfer");
			System.out.println("Please fill in all neccessary information in Application");
	
			try {
				choice = Integer.parseInt(Menu.sc.nextLine());
			} catch (NumberFormatException e) {
			}
	
			switch (choice) {
			case 1:
				break;
			case 2:
				int accountNumberG = getGivingANInput();
				int accountNumberR = getCustomerANInput();
				
				try {
					
					giveTransferService.giveTransfer(accountNumberG);
					completeTransferService.completeTransfer(accountNumberR);
					removeTransferService.removeTransfer(accountNumberG, accountNumberR);
					
				} catch (DatabaseConnectionException e) {
					
					e.printStackTrace();
				}		
				break;
				
			default:
				System.out.println("Choose Again");
			}
			
		} while (choice !=1);
		

	
		}
	public int getGivingANInput() {
		int accountNumberG;
		while (true) {
			
			System.out.println("Enter Giving Account Number: ");
			accountNumberG = Integer.parseInt(Menu.sc.nextLine());
			
			return accountNumberG;
	
		}	
}
	public int getCustomerANInput() {
		int accountNumberR;
		while (true) {
			
			System.out.println("Enter Reciepient Account Number: ");
			accountNumberR = Integer.parseInt(Menu.sc.nextLine());
			
			return accountNumberR;
	
	}
	
}		
	
}