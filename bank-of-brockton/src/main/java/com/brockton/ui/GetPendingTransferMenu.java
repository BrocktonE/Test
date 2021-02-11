package com.brockton.ui;
import org.apache.log4j.Logger;
import com.brockton.exceptions.AccountNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.AccountNumber;
import com.brockton.model.Withdrawal;
import com.brockton.services.GetPendingTransferService;

public class GetPendingTransferMenu implements Menu {
	private static Logger log=Logger.getLogger(GetPendingTransferMenu.class);	
	public GetPendingTransferService getPendingTransferService;
	
	public GetPendingTransferMenu() {
		super();
		getPendingTransferService = new GetPendingTransferService();
		
	}
	

	@Override
	public void display() {
		int choice = 0;
		do {
			log.trace("Player Menu");
			log.trace("============");
			log.trace("1.) Back");
			log.trace("2.) Check Balance");
			log.trace("Enter a choice between 1 and 2");
		
			try {
				choice = Integer.parseInt(Menu.sc.nextLine());
			} catch (NumberFormatException e) {
			}
			
			switch (choice) {
			case 1:
				break;
			case 2:
				int accountNumber = getBalanceInput();
		
					
					
				try {
					int accountNumberG  = getPendingTransferService.getPendingTransfer(accountNumber);
					log.trace(accountNumberG);
					
					
				} catch (AccountNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (DatabaseConnectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
						
	
	
				
				break;
			default:
				log.trace("No valid choice entered, try again");
				
			}
		
	} while (choice != 1);
		
		
}

	public int getBalanceInput() {
		int accountNumber;
		
		while (true) {
			try {
				log.trace("Enter an account number you would like the balance for: ");
				accountNumber = Integer.parseInt(Menu.sc.nextLine());
			} catch (NumberFormatException e) {
				log.trace("Account number not found, try again");
				continue;
			}
			break;
			
			
		}
		return accountNumber;
	}
	
}




