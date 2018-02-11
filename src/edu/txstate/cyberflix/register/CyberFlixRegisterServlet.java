package edu.txstate.cyberflix.register;

import edu.txstate.cyberflix.data.db.Customer;
import edu.txstate.cyberflix.data.db.CustomerDAO;
import edu.txstate.cyberflix.login.AuthenticationService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

public class CyberFlixRegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (!firstName.isEmpty() && !lastName.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
			AuthenticationService service = new AuthenticationService();
			Customer customer = new Customer(-1, firstName, lastName, email, password);
			service.addCustomer(customer);

			CustomerDAO dao = new CustomerDAO();
			Customer cust = dao.findCustomer(email);

			customer.setId(cust.getId());

			// after user registers, go back to login page
			RequestDispatcher rd = (RequestDispatcher) request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher dispatcher = (RequestDispatcher) request.getRequestDispatcher("registration.jsp");

			// setting error message
			request.setAttribute("errorMessage", "Please fill out all fields!");

			dispatcher.forward(request, response);
		}

	}

}
