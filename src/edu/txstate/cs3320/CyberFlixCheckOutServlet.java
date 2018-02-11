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
import edu.txstate.cyberflix.data.db.Cart;
import edu.txstate.cyberflix.data.db.CartManager;
import edu.txstate.cyberflix.data.db.Customer;
import edu.txstate.cyberflix.data.db.CustomerManager;
import edu.txstate.cyberflix.data.db.RentalDAO;
import edu.txstate.cyberflix.data.db.RentalRecord;
import edu.txstate.internet.cyberflix.data.film.Film;

/**
 * Servlet implementation class CyberFlixCheckOutServlet
 */
@WebServlet("/CyberFlixCheckOutServlet")
public class CyberFlixCheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CyberFlixCheckOutServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("CheckOutServlet");
		HttpSession session = request.getSession();
		CartManager thisCM = CartManager.getInstance();
		// CustomerManager thisCustManag = CustomerManager.getInstance();
		Cart thisCart = thisCM.getCart(session.getId());
		Customer thisCustomer = CustomerManager.getCustomer(session.getId());

		List<Film> films = thisCart.getCart();
		for (int i = 0; i < films.size(); i++) {
			RentalRecord ro = new RentalRecord(0, null, films.get(i).getFilmID(), thisCustomer.getId(), null);
			RentalDAO rd = new RentalDAO();
			rd.save(ro);
		}

		request.setAttribute("films", films);
		request.getRequestDispatcher("checkOut.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
