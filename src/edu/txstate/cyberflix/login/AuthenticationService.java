package edu.txstate.cyberflix.login;

import edu.txstate.cyberflix.data.db.Customer;
import edu.txstate.cyberflix.data.db.CustomerDAO;

public class AuthenticationService {

	public Customer validateCustomer(String email) {

		// defining the dao object
		CustomerDAO dao = new CustomerDAO();

		// calling the validate user method
		return dao.findCustomer(email);
	}

	public void addCustomer(Customer customer) {
		CustomerDAO dao = new CustomerDAO();
		dao.save(customer);
	}
}