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
			System.out.println("Account Menu");
			System.out.println("=============");
			System.out.println("1.) Back");
			System.out.println("2.) Apply for a new Account");
			System.out.println("3.) Check Balance");
			System.out.println("4.) Make a Withdrawal");
			System.out.println("5.) Make a Deposit");
			System.out.println("6.) Make a Transfer");
			System.out.println("7.) Accept a Transfer");
			System.out.println("8.) Check UN and PW");
			
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
				Menu getMoneyMenu = new GetMoneyMenu();
				getMoneyMenu.display();
			case 8:
				Menu checkUNandPWMenu = new CheckUNandPWMenu();
				checkUNandPWMenu.display();;
			break;
			default:
				System.out.println("Choose Again");
				break;				
			}
					
		} while (choice !=1);
		
	}


}

		

