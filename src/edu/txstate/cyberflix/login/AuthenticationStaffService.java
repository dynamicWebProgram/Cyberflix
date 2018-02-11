package edu.txstate.cyberflix.login;

import edu.txstate.cyberflix.data.db.Staff;
import edu.txstate.cyberflix.data.db.StaffDAO;

public class AuthenticationStaffService {

	public Staff validateStaff(String email, String password) {

		StaffDAO dao = new StaffDAO();

		return dao.validateStaff(email, password);

	}

}
