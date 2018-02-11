package edu.txstate.cs3320;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.txstate.cyberflix.data.db.FilmDAO;
import edu.txstate.internet.cyberflix.data.film.Film;
import edu.txstate.internet.cyberflix.data.film.FilmCategory;

/**
 * Servlet implementation class CyberFlixCategoryServlet
 */
@WebServlet("/CyberFlixCategoryServlet")
public class CyberFlixCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CyberFlixCategoryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String cat = request.getParameter("film_category");
		String alpha = request.getParameter("film_alphabet");
		FilmDAO filmDao = new FilmDAO();
		List<Film> foundFilms;
		if (cat != null) {
			foundFilms = filmDao.findFilmsByCategory(FilmCategory.valueOf(cat));
		}
		else if (alpha != null) {
			foundFilms = filmDao.findFilmsAlphabetically(alpha);
		}
		else {
			foundFilms = null;
		}
		for (int i = 0; i < foundFilms.size(); i++) { // ******************************************
			System.out.println(foundFilms.get(i));
		}

		System.out.println("ArrSize: " + foundFilms.size());
		System.out.println("Title: " + foundFilms.get(1).getTitle());
		// if(cat != null) {
		if ((foundFilms != null) && (!foundFilms.isEmpty())) {
			// request.setAttribute("detailServlet",
			// "http://localhost:8080/CyberFlix0/CyberFlixMovieDetailServlet");
			request.setAttribute("films", foundFilms);
			request.getRequestDispatcher("search.jsp").forward(request, response);
		}
		// }
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
