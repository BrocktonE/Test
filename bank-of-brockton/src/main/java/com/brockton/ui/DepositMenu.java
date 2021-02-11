package com.brockton.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;


import com.brockton.exceptions.AccountNotFoundException;
import com.brockton.exceptions.DatabaseConnectionException;
import com.brockton.model.Withdrawal;
import com.brockton.services.AccountConfirmService;
import com.brockton.services.DepositService;
import com.brockton.util.ConnectionUtil;

public class DepositMenu implements Menu {
	private static Logger log=Logger.getLogger(DepositMenu.class);
	public AccountConfirmService accountConfirmService;
	public DepositService depositService;
	Withdrawal customer = null;
	public DepositMenu(Withdrawal customer) {
		super ();
		this.customer = customer;
		depositService = new DepositService();
		accountConfirmService = new AccountConfirmService();
	}
	@Override
	public void display() {
		int choice = 0;
		do {
			log.trace("Deposit Menu");
			log.trace("===============");
			log.trace("1.) Back");
			log.trace("2.) Make Deposit");
			log.trace("3.) Print UN");
			log.trace("4.) Get UN and PW");
			log.trace("Enter a choice between 1 and 2");

			try {
				choice = Integer.parseInt(Menu.sc.nextLine());
			} catch (NumberFormatException e) {
			}

			switch (choice) {
			case 1:
				break;
			case 2:

				int accountNumber = getCustomerANInput();
				int deposit = getCustomerWDInput();
				try {
					Withdrawal account = accountConfirmService.getUNandPW(accountNumber);
					log.trace(customer);
					log.trace(account);

					if (account.equals(customer)) {
						depositService.makeDeposit(accountNumber, deposit);
						log.trace("Success, your money has been deposited");

					}

					else {
						throw new AccountNotFoundException();
					}

				} catch (AccountNotFoundException e) {
					log.error("Please enter an Account Number that you currently own");
					log.error(e.getMessage());
				} catch (DatabaseConnectionException e) {
					log.error("Connection Failed");
					log.error(e.getMessage());
				}

				break;
			case 3:
				log.error("try again");
			default:
				log.trace("No valid choice entered");

			}
		} while (choice != 1);

	}

	public int getCustomerANInput() {
		int accountNumber;
		while (true) {

			log.trace("Enter Account Number: ");
			accountNumber = Integer.parseInt(Menu.sc.nextLine());

			return accountNumber;

		}

	}

	public int getCustomerWDInput() {
		int deposit;
		while (true) {

			log.trace("Enter your Deposit Ammount:");
			deposit = Integer.parseInt(Menu.sc.nextLine());
			if (deposit < 0) {
				log.trace("Input must be positive");
				deposit = 0;
			} else
			

			return deposit;
		}
	}
}



			
