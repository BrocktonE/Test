package com.brockton.ui;

import org.apache.log4j.Logger;

import com.brockton.exceptions.AccountNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.AccountNumber;
import com.brockton.model.Withdrawal;
import com.brockton.services.AccountConfirmService;
import com.brockton.services.CompleteTransferService;
import com.brockton.services.GetPendingTransferService;
import com.brockton.services.GiveTransferService;


public class GetMoneyMenu implements Menu {
	private static Logger log=Logger.getLogger(GetMoneyMenu.class);
	public GiveTransferService giveTransferService;
	public CompleteTransferService completeTransferService;
	public GetPendingTransferService getPendingTransferService;
	public AccountConfirmService accountConfirmService;
	Withdrawal customer = null;
	
	public GetMoneyMenu(Withdrawal customer) {
		super();
		this.customer = customer;
		getPendingTransferService = new GetPendingTransferService();
		completeTransferService = new CompleteTransferService();
		giveTransferService = new GiveTransferService();
	//	removeTransferService = new RemoveTransferService();
		accountConfirmService = new AccountConfirmService();
		
		
		
	}
	

	@Override
	public void display() {
		int choice = 0;
		do {
			log.trace("Pending Transfer Menu");
			log.trace("======================================");
			log.trace("1.) Back");
			log.trace("2.) Accept Transfer");
			log.trace("3.) Choose Again");
			log.trace("Please fill in all neccessary information in Application");

			try {
				choice = Integer.parseInt(Menu.sc.nextLine());
			} catch (NumberFormatException e) {
			}

			switch (choice) {
			case 1:
				break;
			case 2:
				
				int accountNumberR = getCustomerANInput();
				int accountNumberG = 0;
				try {
					accountNumberG = getPendingTransferService.getPendingTransfer(accountNumberR);
				} catch (AccountNotFoundException | DatabaseConnectionException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {
					Withdrawal account = accountConfirmService.getUNandPW(accountNumberR);
					
					
					 if (account.equals(customer)) {
						
						 
						giveTransferService.giveTransfer(accountNumberG, accountNumberR);
						
						
					 }
					
					else {
						throw new AccountNotFoundException();
					}

				} catch (DatabaseConnectionException | AccountNotFoundException e) {
					log.error("Please enter and Account Number that you currently own");
					log.error(e.getMessage());

				}

				break;
			case 3:
				log.trace("try again");
			default:
				log.trace("Choose Again");
			}

		} while (choice != 1);

	}

	public int getGivingANInput() {
		int accountNumberG;
		while (true) {

			log.trace("Enter Giving Account Number: ");
			accountNumberG = Integer.parseInt(Menu.sc.nextLine());

			return accountNumberG;

		}
	}

	public int getCustomerANInput() {
		int accountNumberR;
		while (true) {

			log.trace("Enter Reciepient Account Number: ");
			accountNumberR = Integer.parseInt(Menu.sc.nextLine());
			

			return accountNumberR;

		}

	}

}