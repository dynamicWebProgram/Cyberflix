package edu.txstate.cyberflix.data.db;

public class StaffDriver {

	public static void main(String[] args) {
		String email = "Mike.Hillyer@sakilastaff.com"; // Email from database
		String password = "pass#123";
		System.out.println("Trying to find a customer with the email " + email);

		StaffDAO staffDAO = new StaffDAO();
		Staff staff = staffDAO.validateStaff(email, password);
		if (staff == null)
			System.out.println("No customer with the email " + email + " found");
		else
			System.out.println(staff.toString());
	}

}
