package com.revature.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Approve;
import com.revature.models.AuthorId;
import com.revature.models.Employee;
import com.revature.models.LoginTemplate;
import com.revature.models.Reimburse;
import com.revature.models.ReimburseR;
import com.revature.models.Request;
import com.revature.services.EmployeeService;
import com.revature.services.ManagerService;

public class RequestHelper {

	private static Logger log = Logger.getLogger(RequestHelper.class);
	private static ObjectMapper om = new ObjectMapper();

	public static void processLogin(HttpServletRequest req, HttpServletResponse res) throws IOException {

		// Turn what we recive as the request into a string
		BufferedReader reader = req.getReader();
		StringBuilder s = new StringBuilder();

		String line = reader.readLine();
		while (line != null) {
			s.append(line);
			line = reader.readLine();
		}
		String body = s.toString();
		log.info(body);

		LoginTemplate loginAttempt = om.readValue(body, LoginTemplate.class);

		String username = loginAttempt.getUsername();
		String password = loginAttempt.getPassword();
		
		

		log.info("User attempted to login with username: " + username);

		Employee e = EmployeeService.confirmLogin(username, password);

		if (e.getUserRole() != 2) {
			HttpSession session = req.getSession();
			session.setAttribute("username", username);

			// attching the print writer to our response
			PrintWriter pw = res.getWriter();
			res.setContentType("application/json");

			pw.println(om.writeValueAsString(e));

			log.info("Employee " + username + " has successfully logged in");

		} else {
			res.setStatus(204);
		}

	}

	public static void processLogout(HttpServletRequest req, HttpServletResponse res) throws IOException {

		HttpSession session = req.getSession(false); // capturing session, but if there Isnt one, I dont create a new
														// one
		log.info("Processing logout");

		if (session != null) {

			String username = (String) session.getAttribute("username");
			log.info(username + " has logged out.");

			session.invalidate();
		}

		res.setStatus(200);

	}

	// This methods purpose is to return all Employees from the DB in JSON form
	public static void processEmployees(HttpServletRequest req, HttpServletResponse res) throws IOException {

		// 1. Set content type to app/json because we will be sending json data back to
		// the client
		// stuck alongside the response

//		log.info(EmployeeService.findAll());  this function logs to the console IN JAVA
		res.setContentType("application/json");

		// 2. Get a list of all Employees

		List<Employee> allEmps = EmployeeService.findAll();

		// 3. Turn the list of Java Objs in to a JSON string
		String json = om.writeValueAsString(allEmps);

		// 4. Use getWriter() from the response object to return the json string
		PrintWriter pw = res.getWriter();
		pw.println(json);

	}

	public static void processError(HttpServletRequest req, HttpServletResponse res) throws IOException {
		try {
			req.getRequestDispatcher("error.html").forward(req, res);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
		
		public static void processLogin2(HttpServletRequest req, HttpServletResponse res) throws IOException {

			// Turn what we recive as the request into a string
			BufferedReader reader = req.getReader();
			StringBuilder s = new StringBuilder();

			String line = reader.readLine();
			while (line != null) {
				s.append(line);
				line = reader.readLine();
			}
			String body = s.toString();
			log.info(body);

			LoginTemplate loginAttempt = om.readValue(body, LoginTemplate.class);

			String username = loginAttempt.getUsername();
			String password = loginAttempt.getPassword();

			log.info("User attempted to login with username: " + username);

			Employee e = EmployeeService.confirmLogin(username, password);

			if (e.getUserRole() !=1) {
				HttpSession session = req.getSession();
				session.setAttribute("username", username);

				// attching the print writer to our response
				PrintWriter pw = res.getWriter();
				res.setContentType("application/json");

				pw.println(om.writeValueAsString(e));

				log.info("Employee " + username + " has successfully logged in");

			} else {
				res.setStatus(204);
			}

	}
		
		public static void processRequest(HttpServletRequest req, HttpServletResponse res) throws IOException {

			BufferedReader reader = req.getReader();
			StringBuilder s = new StringBuilder();

			String line = reader.readLine();
			while (line != null) {
				s.append(line);
				line = reader.readLine();
			}
			String body = s.toString();
			log.info(body);

			Request request = om.readValue(body, Request.class);

			int amount = request.getAmount();
			String description = request.getDescription();
			int author = request.getAuthor();
			int type = request.getType();
			
			log.info(request);
			

			try {
				EmployeeService.createRequest(request);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


}	
		
		public static void processApproveRequest(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
			BufferedReader reader = req.getReader();
			StringBuilder s = new StringBuilder();

			String line = reader.readLine();
			while (line != null) {
				s.append(line);
				line = reader.readLine();
			}
			String body = s.toString();
			log.info(body);

			Approve approve = om.readValue(body, Approve.class);

			int id = approve.getId();
			int status = approve.getStatus();
			int requestId = approve.getRequestId();
			
			log.info(approve);
			

			try {
				ManagerService.approve(approve);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		
		
}	
		
		public static void processReimbursementList(HttpServletRequest req, HttpServletResponse res) throws IOException {
			res.setContentType("application/json");
			
			List<Reimburse> reimbursementList = ManagerService.findAll();
			
			String json = om.writeValueAsString(reimbursementList);
			
	
			
			
			PrintWriter pw = res.getWriter();
			pw.println(json);
			
			
		}
		
		
		public static void processReimbursementListR(HttpServletRequest req, HttpServletResponse res) throws IOException {
			res.setContentType("application/json");
			
			List<ReimburseR> reimbursementListR = ManagerService.findAllR();
			
			String json = om.writeValueAsString(reimbursementListR);
			
	
			
			
			PrintWriter pw = res.getWriter();
			pw.println(json);
			
			
		}
		
		
		
		public static void processViewInfo(HttpServletRequest req, HttpServletResponse res) throws IOException {
			log.info("hello inside view info");
			
			BufferedReader reader = req.getReader();
			StringBuilder s = new StringBuilder();

			String line = reader.readLine();
			while (line != null) {
				s.append(line);
				line = reader.readLine();
			}
			String body = s.toString();
			log.info(body);

			AuthorId nid = om.readValue(body, AuthorId.class);
			log.info(nid);
				 int authorId = nid.getAid();
						
		log.info(authorId);
			
			
			
			
		//	int authorId = 2;
			
			List<ReimburseR> reimbursementList = EmployeeService.findAllR(authorId);
			
			String json = om.writeValueAsString(reimbursementList);
			
	
			
			
			PrintWriter pw = res.getWriter();
			pw.println(json);
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}		
		
