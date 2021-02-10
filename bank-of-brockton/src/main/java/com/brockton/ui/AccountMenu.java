package com.brockton.ui;

import org.apache.log4j.Logger;


import com.brockton.model.Withdrawal;


public class AccountMenu implements Menu {
	private static Logger log=Logger.getLogger(AccountMenu.class);
	
	
	Withdrawal customer = null;
	public AccountMenu(Withdrawal customer) {
		super();
		this.customer = customer;
		
	}
	@Override
	public void display() {
		int choice = 0;
		
	//	System.out.println(customer);
		do {
			log.trace("Account Menu");
			log.trace("=============");
			log.trace("1.) Back");
			log.trace("2.) Apply for a new Account");
			log.trace("3.) Check Balance");
			log.trace("4.) Make a Withdrawal");
			log.trace("5.) Make a Deposit");
			log.trace("6.) Make a Transfer");
			log.trace("7.) Accept a Transfer");
			log.trace("8.) Check UN and PW");
			
			try {
				choice = Integer.parseInt(Menu.sc.nextLine());
			} catch (NumberFormatException e) {
			}
			
			switch (choice) {
			case 1:
				break;
			case 2:
				Menu applicationMenu = new ApplicationMenu();
				applicationMenu.display();
				break;
			case 3:
				
				Menu checkBalanceMenu = new CheckBalanceMenu(customer);
				checkBalanceMenu.display();
				break;
			case 4:
				Menu withdrawalMenu = new WithdrawalMenu(customer);
				withdrawalMenu.display();
				break;
			case 5:
				Menu depositMenu = new DepositMenu(customer);
				depositMenu.display();
				break;
			case 6:
				Menu transferMenu = new TransferMenu();
				transferMenu.display();
				break;
			case 7:
				Menu getMoneyMenu = new GetMoneyMenu(customer);
				getMoneyMenu.display();
			case 8:
				Menu checkUNandPWMenu = new CheckUNandPWMenu();
				checkUNandPWMenu.display();
			break;
			case 9:
//				Menu getPendingTransferMenu 
			default:
				log.trace("Choose Again");
				break;				
			}
					
		} while (choice !=1);
		
	}


}

		

