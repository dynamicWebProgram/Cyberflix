package edu.txstate.cs3320;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import edu.txstate.internet.cyberflix.data.film.*;
import edu.txstate.internet.cyberflix.data.helper.FilmFactory;
import edu.txstate.cyberflix.data.db.FilmDAO;
import edu.txstate.internet.cyberflix.data.DataSource;
import edu.txstate.internet.cyberflix.utils.*;

/**
 * Servlet implementation class CyberFlixServlet
 */
@WebServlet("/CyberFlixServlet")
public class CyberFlixServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CyberFlixServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		ServletUtils.setAbsolutePath(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		response.setContentType("text/html");
		String t = (String) request.getAttribute("text");
		String title = request.getParameter("film_title");
		String description = request.getParameter("film_description");
		String rating = request.getParameter("film_rating");
		int length = Integer.parseInt(request.getParameter("film_length"));
		System.out.println("this is attribute: " + t); // #############################################
		DataSource ds = new DataSource();
		// ds.init();
		// List <Film> foundFilms = ds.findFilmByTitle(title);
		System.out.println("film Rating1: " + rating);
		Film.FilmRating filmRating;
		if (rating != null) {
			filmRating = FilmFactory.convert(rating);
		}
		else {
			filmRating = null;
		}
		System.out.println("film Rating: " + filmRating);
		FilmDAO filmDao = new FilmDAO();
		List<Film> foundFilms = filmDao.findFilmsByAttributes(title, description, length, filmRating);
		// for(int i=0; i<foundFilms.size(); i++) {
		// //******************************************
		// System.out.println(foundFilms.get(i));}
		//
		// System.out.println("ArrSize: " + foundFilms.size());
		// System.out.println("Title: "+foundFilms.get(0).getTitle());
		if (title != null) {
			if ((foundFilms != null) && (!foundFilms.isEmpty())) {
				// request.setAttribute("detailServlet",
				// "http://localhost:8080/CyberFlix0/CyberFlixMovieDetailServlet");
				request.setAttribute("films", foundFilms);
				request.getRequestDispatcher("search.jsp").forward(request, response);
			}
		}
	}

	//
	// if(foundFilms != null) {
	// for(int i=0; i< foundFilms.size(); i++) {
	// Film film = foundFilms.get(i);
	// File file = new File("fFile"+i+".html");
	// PrintWriter wr = new PrintWriter(file);
	// wr.print(HTMLTags.H1_START+film.getTitle()+"<i>("+film.getReleaseYear()+")</i>"
	// +HTMLTags.H1_END);
	// wr.print(HTMLTags.PARAGRAPH_START+"Running Time: "+ film.getLength()
	// + HTMLTags.LINE_BREAK +"Rating: "
	// + film.getRating()+HTMLTags.LINE_BREAK+
	// film.getDescription()+HTMLTags.PARAGRAPH_END);
	// wr.close();
	//
	// String t1 = "<b>" + film.getTitle() + "</b>";
	// response.getWriter().append(HTMLTags.createHTMLLinkToBookmark
	// ( "file:\\\\\\" + file.getAbsolutePath(), "", t1)
	// +" "+"<i>("+film.getReleaseYear()+")</i>"
	// +" "+film.getDescription()+"<br>");
	// }
	//
	// }else {
	// response.getWriter().append("Film not found");
	// }
	// }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
