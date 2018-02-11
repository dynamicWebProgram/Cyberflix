package edu.txstate.cs3320;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import edu.txstate.cyberflix.data.db.Customer;
import edu.txstate.cyberflix.data.db.CustomerManager;
import edu.txstate.cyberflix.data.db.RentalDAO;
import edu.txstate.cyberflix.data.db.RentalRecord;

/**
 * Servlet implementation class CyberFlixCustomerDetailServlet
 */
@WebServlet("/CyberFlixCustomerDetailServlet")
public class CyberFlixCustomerDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CyberFlixCustomerDetailServlet() {
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

		// String email = request.getParameter("email_address");
		// Customer curr = CustomerDAO.findCustomer(email);

		// RentalDAO rd = new RentalDAO();
		// List<RentalRecord> rentals = RentalDAO.findRentalByCustomer(curr);
		HttpSession session = request.getSession();

		// CustomerManager thisCustManag = CustomerManager.getInstance();
		Customer thisCustomer = CustomerManager.getCustomer(session.getId());
		List<RentalRecord> rr = new ArrayList<RentalRecord>();

		RentalDAO rd = new RentalDAO();
		rr = rd.findRentalByCustomer(thisCustomer);

		request.setAttribute("rentals", rr);
		request.setAttribute("customer", thisCustomer);
		request.getRequestDispatcher("viewCustomer.jsp").forward(request, response);
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
