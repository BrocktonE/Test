import java.util.List;

import org.apache.log4j.Logger;


import com.revature.respositories.ManagerDAO;
import com.revature.respositories.ManagerDAOImpl;
import com.revature.services.ManagerService;

public class Driver {
	private static Logger log = Logger.getLogger(Driver.class);
	

	public static void main(String[] args) {
		
		
		

	}
	
	public static ManagerDAO eDao = new ManagerDAOImpl();
	
		List reimbursementList = eDao.findAll();
		
		
		
		
	}


