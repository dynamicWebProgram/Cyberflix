package edu.txstate.cs3320;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import edu.txstate.cyberflix.data.db.Customer;
import edu.txstate.cyberflix.data.db.CustomerManager;
import edu.txstate.cyberflix.login.AuthenticationService;

/**
 * Servlet implementation class CyberFlixLogServlet
 */
@WebServlet("/CyberFlixLogServlet")
public class CyberFlixLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CyberFlixLogServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		// getting the input from user
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// simple validation
		if ((email != null && !email.isEmpty()) && (password != null && !password.isEmpty())) {

			// defining the object for AuthenticationService
			AuthenticationService service = new AuthenticationService();

			// validating the user input
			Customer customer = service.validateCustomer(email);

			// dispatching the result based on the outcome
			if (customer != null) {

				HttpSession session = request.getSession();

				CustomerManager.addCustomer(session.getId(), customer);
				RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");

				// setting user details object in session based on the valid outcome

				session.setAttribute("customer", customer);

				dispatcher.forward(request, response);

			}
			else {

				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");

				// setting error message
				request.setAttribute("errorMessage", "you have given an invalid email or password :( ");

				dispatcher.forward(request, response);

			}

		}
		else {

			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");

			// setting error message
			request.setAttribute("errorMessage", "Email: *" + email + "* Password: *" + password + "*");

			dispatcher.forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
