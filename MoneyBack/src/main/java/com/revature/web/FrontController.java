package com.revature.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.revature.models.Employee;
import com.revature.services.EmployeeService;
import com.revature.util.RequestHelper;


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(FrontController.class);

    public FrontController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		//we will rewrite the URL's
		final String URI = request.getRequestURI().replace("/MoneyBack/", "");

		
		
		switch(URI) {
		case "login":
			RequestHelper.processLogin(request, response);
			break;
		case "login2":
			RequestHelper.processLogin2(request,response);
			break;
		case "logout":
			RequestHelper.processLogout(request, response);
			break;
		case "employees":
			RequestHelper.processEmployees(request,response);
		case "error":
			RequestHelper.processError(request, response);
			break;
		
		}
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	
    }
	
}







