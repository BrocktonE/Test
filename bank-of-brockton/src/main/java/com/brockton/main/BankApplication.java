package com.brockton.main;

import org.apache.log4j.Logger;

import com.brockton.dao.CustomerDAOImpl;
import com.brockton.ui.MainMenu;
import com.brockton.ui.Menu;

public class BankApplication {
	private static Logger log=Logger.getLogger(BankApplication.class);
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Bank of Brockton!");
		System.out.println("====================================");
		
		Menu mainMenu = new MainMenu();
		mainMenu.display();
		
		
		Menu.sc.close();
		System.out.println("Goodbye");

	}

}
