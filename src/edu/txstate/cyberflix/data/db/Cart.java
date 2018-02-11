package edu.txstate.cyberflix.data.db;

import java.util.List;
import java.util.ArrayList;
import edu.txstate.internet.cyberflix.data.film.Film;
import java.io.IOException;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
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

public class Cart {

	private Film film;
	private String title;
	private List<Film> cartFilms;

	public Cart() {
		cartFilms = new ArrayList<Film>();
	}

	// public String getTitle(){
	// return title;
	// }

	public void addToCart(String title) {
		FilmDAO fd = new FilmDAO();
		List<Film> film1 = fd.findFilmsByAttributes(title, "", -1, null);
		Film thisFilm = fd.getFilmDetail(film1.get(0));
		cartFilms.add(thisFilm);
	}

	public List<Film> getCart() {
		return cartFilms;
	}

}
