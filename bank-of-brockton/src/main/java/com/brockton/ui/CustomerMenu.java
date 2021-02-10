package com.brockton.ui;


import org.apache.log4j.Logger;
import com.brockton.model.Customer;
import com.brockton.services.CustomerService;

public class CustomerMenu implements Menu {
	private static Logger log=Logger.getLogger(CustomerMenu.class);

		public CustomerService customerService;
		
		public CustomerMenu() {
			customerService = new CustomerService();	
	}


	@Override
	public void display() {
		int choice = 0;
		do 	{
			log.trace("Customer MENU");
			log.trace("===============");
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
				String CustomerSelectedUN = getcreateCustomerUNInput();
				String CustomerSelectedPW = getcreateCustomerPWInput();
				Customer newUNandPW = new Customer(CustomerSelectedUN, CustomerSelectedPW);
				customerService.createCustomerUnPw(newUNandPW);
				log.trace("Success you have created a UN and PW");
				 break;
			
			default:
				log.trace("No valid choice entered");
			}
			
		} while (choice !=1);
		
	}

	public String getcreateCustomerUNInput() {
		String userName;
		while (true) {

			log.trace("Enter Username: ");
			userName = Menu.sc.nextLine();

			return userName;
		}

	}

	public String getcreateCustomerPWInput() {
		String passWord;
		while (true) {

			log.trace("Enter Password: ");
			passWord = sc.nextLine();
			return passWord;

		}

	}

}
