//
//package edu.txstate.cyberflix.data.db;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Logger;
//import java.lang.*;
//import java.util.Random;
//
//import edu.txstate.internet.cyberflix.data.actor.Actor;
//import edu.txstate.internet.cyberflix.data.film.Film;
//import edu.txstate.internet.cyberflix.data.film.FilmCategory;
//import edu.txstate.internet.cyberflix.data.film.Film.FilmRating;
//import edu.txstate.internet.cyberflix.data.helper.FilmFactory;
//
///**
// * @author Two
// *
// */
//public class FilmDAO extends DAO {
//	private final static Logger LOGGER = Logger.getLogger(FilmDAO.class.getName());
//	
//	private static final int    FILM_ID_COLUMN          = 1;
//	private static final int    FILM_TITLE_COLUMN       = 2;
//	private static final int    FILM_DESCRIPTION_COLUMN = 3;
//	private static final int    FILM_LENGTH_COLUMN      = 4;
//	private static final int    FILM_RATING_COLUMN      = 5;
//	private static final int    FILM_RELEASE_YEAR       = 6;
//	
//	private static final String FILM_SELECT_STRING      = "SELECT film.film_id, film.title, film.description," +
//			"film.length, film.rating, film.release_year ";
//	
//	String movPoster []= {"https://photos.filmibeat.com/ph-big/2012/08/oh-my-god_13455282950.jpg", 
//"http://athenaposters.ca/wp-content/uploads/2017/05/RP15092-Beauty-The-Beast-One-Sheet.jpg",
//"http://img.moviepostershop.com/titanic-movie-poster-1997-1020339699.jpg",
//"http://img.moviepostershop.com/the-hangover-movie-poster-2009-1020488737.jpg",
//"https://i.pinimg.com/736x/35/09/96/3509966fbcc98784e47c53854fbadb58--art-movies-alternative-movie-posters.jpg",
//"http://www.wearemoviegeeks.com/wp-content/uploads/the-avengers-movie-poster.jpg",
//"https://2982-presscdn-29-70-pagely.netdna-ssl.com/wp-content/uploads/2015/11/hunger-games-catching-fire-movie-poster.jpg",
//"http://www.fatmovieguy.com/wp-content/uploads/2013/05/Snitch-Movie-Poster.jpg",
//"https://petapixel.com/assets/uploads/2016/08/posterfix-449x700.jpg",
//"http://img.moviepostershop.com/the-magnificent-seven-movie-poster-2016-1020776374.jpg", 
//"https://www.fashiongonerogue.com/wp-content/uploads/2015/04/britt-robertson-tomorrowland-movie-poster.jpg",
//"https://www.aboutamom.com/wp-content/uploads/2013/03/Iron-Man-3-Movie-Poster-Collage.jpg",
//"https://i.pinimg.com/736x/95/42/b6/9542b6b0d74585d9dc8e9100a0466f09--new-movie-posters-poster-film.jpg",
//"http://16391-presscdn-0-53.pagely.netdna-cdn.com/wp-content/uploads/2015/05/moviepostersremake2.jpg",
//"http://i.perezhilton.com/wp-content/uploads/2013/04/chris-hemworth-on-the-first-official-movie-poster-for-thor-the-dark-world__oPt.jpg",
//"http://starwarsblog.starwars.com/wp-content/uploads/2016/10/rogueone_onesheetA.jpg",
//"https://www.movieposter.com/posters/archive/main/98/MPW-49246",
//"https://i.pinimg.com/736x/0a/fa/f0/0afaf0714cf427bd62a5e96818dbece6--sad-movies-watch-movies.jpg",
//"https://i.pinimg.com/736x/93/d4/ab/93d4ab4c3bf7952ebe9e5ec23aa1b4c9--disney-movies-posters-childrens-movies.jpg",
//"https://images-production.global.ssl.fastly.net/uploads/posts/image/70431/the-jungle-book-first-disney-movie-poster.png"};
//	public static void main(String args[]) {
//		System.out.println("Newest Films: \n***************************");
//		FilmDAO fd = new FilmDAO();
//		List<Film> f =  fd.findNewestFilms();
//		
//		for(int i=0; i<f.size(); i++) {
//			System.out.println(f.get(i).getTitle());
//		}
//		System.out.println("\n\n");
//		List<Film> fCat = fd.findFilmsByCategory(FilmCategory.ACTION);
//		System.out.println("Films by category ACTION: \n************************");
//		for(int i=0; i<fCat.size(); i++) {
//			System.out.println(fCat.get(i).getTitle());
//		}
//		System.out.println("\n\n");
//		List<Film> fAl = fd.findFilmsAlphabetically("k");
//		System.out.println("Films Alphabetically by 'K': \n***************************");
//		for(int i=0; i<fAl.size(); i++) {
//			System.out.println(fAl.get(i).getTitle());
//		}
//		System.out.println("\n\n");
//		Film f1 = fd.getFilmDetail(fAl.get(1));
//		System.out.println("Film details for "+f1.getTitle()+": \n*************************");
//		System.out.println("Description: "+f1.getDescription());
//		System.out.println("Release Year: "+f1.getReleaseYear());
//		System.out.println("Genre: "+f1.getCategory());
//		System.out.println("Length: "+f1.getLength());
//		//System.out.println(f1);
//		
//		System.out.println("\n\n");
//		System.out.println("Films by attributes: \n***************************");
//		List<Film> a1 = fd.findFilmsByAttributes("", "", 60, null);
//		for(int i=0; i<a1.size(); i++) {
//			System.out.println(a1.get(i).getTitle());
//		}
//		System.out.println("\n\n");
//		List<Actor> l1 = fd.findActorsInFilm(fAl.get(1));
//		System.out.println("Actors in "+f1.getTitle()+": \n*************************");
//		for(int i=0; i<l1.size(); i++) {
//			System.out.println(l1.get(i).getFirstName()+" "+l1.get(i).getLastName());
//		}
//		
//		System.out.println("\n\n");	
//		System.out.println("Trying to find a customer with the email MARY.SMITH@sakilacustomer.org");
//		CustomerDAO cusDAO = new CustomerDAO(); 
//		//Customer cus = cusDAO.findCustomerByEmail("MARY.SMITH@sakilacustomer.org");
//		//System.out.println("Customer name: "+cus.getFirstName()+" "+ cus.getLastName());
//	}
//	
//	public List<Film> findNewestFilms(){
//		String selectString = "SELECT film_id, title, description, length, rating, release_year FROM Film WHERE release_year=2017";
//		List <Film> films = null;
//		Connection dbConnection = null;
//		try {
//			dbConnection = DAO.getDBConnection();
//			Statement statement 	= dbConnection.createStatement();
//			ResultSet results       = statement.executeQuery(selectString);
//			films = buildResults (results);
//			dbConnection.close();
//		} catch (SQLException e) {
//			System.err.println("FilmDAO.findNewestFilms: " + e.toString());
//			LOGGER.severe(e.toString());
//			closeQuietly(dbConnection);
//		}	
//		return films;
//	}
//	
//
//	
//	public List <Film> findFilmsByAttributes (String title, String description, int length, FilmRating rating) {
//		String selectString = buildString (title, description, length, rating);
//		List <Film> films = null;
//		Connection dbConnection = DAO.getDBConnection();
//		System.out.println(dbConnection);
//		try {
//			dbConnection = DAO.getDBConnection();
//			System.out.println(dbConnection);
//			Statement statement 	= dbConnection.createStatement();
//			ResultSet results       = statement.executeQuery(selectString);
//			films = buildResults (results);
//			System.out.println(films.get(0).getTitle());
//			dbConnection.close();
//		} catch (SQLException e) {
//			System.err.println("FilmDAO.findFilmsByAttributes: " + e.toString());
//			LOGGER.severe(e.toString());
//			closeQuietly(dbConnection);
//		}	
//		return films;
//	}
//
//	
//	public List <Film> findFilmsByCategory(FilmCategory category){
//		final String FILM_SELECT_STRING = "SELECT film.film_id, film.title, film.description, film.length, film.rating, film.release_year ";
//		final String CATEGORY_CLAUSES = " FROM film, film_category WHERE film.film_id = film_category.film_id AND film_category.category_id =";
//		StringBuilder stringBuilder = new StringBuilder(FILM_SELECT_STRING);
//		stringBuilder.append(CATEGORY_CLAUSES);
//		stringBuilder.append(category.ordinal()+1); 
//		String selectString = stringBuilder.toString();
//		
//		List <Film> films = null;
//		Connection dbConnection = null;
//		try {
//			dbConnection = DAO.getDBConnection();
//			Statement statement 	= dbConnection.createStatement();
//			ResultSet results       = statement.executeQuery(selectString);
//			films = buildResults (results);
//			dbConnection.close();
//		} catch (SQLException e) {
//			System.err.println("FilmDAO.findFilmsByCategory: " + e.toString());
//			LOGGER.severe(e.toString());
//			closeQuietly(dbConnection);
//		}	
//		return films;
//	}
//	
//	public List <Film> findFilmsAlphabetically(String firstCharacter){
//		String selectString = "SELECT film_id, title, description, length, rating, release_year  FROM film  WHERE title LIKE '"+firstCharacter+"%';";
//		List <Film> films = null;
//		Connection dbConnection = null;
//		try {
//			dbConnection = DAO.getDBConnection();
//			Statement statement 	= dbConnection.createStatement();
//			ResultSet results       = statement.executeQuery(selectString);
//			films = buildResults (results);
//			dbConnection.close();
//		} catch (SQLException e) {
//			System.err.println("FilmDAO.findFilmsAlphabetically: " + e.toString());
//			LOGGER.severe(e.toString());
//			closeQuietly(dbConnection);
//		}	
//		return films;
//
//	}
//	
//	public Film getFilmDetail (Film film){
//		Connection dbConnection = null;
//		try {
//			dbConnection = DAO.getDBConnection();
//			String selectTableSQL = "SELECT name FROM category where category_id in (SELECT category_id FROM film_category WHERE film_id =" + film.getFilmID() +");";
//			Statement statement 	= dbConnection.createStatement();
//			ResultSet results       = statement.executeQuery(selectTableSQL);
//			if(results.next()) {
//				//System.out.println("Has Next");
//				String cat = results.getString(1);
//				film.setCategory(cat);
//			}
//			//films = buildResults (results);
//			dbConnection.close();
//			
//		} catch (SQLException e) {
//			System.err.println("FilmDAO.findNewestFilms: " + e.toString());
//			LOGGER.severe(e.toString());
//			closeQuietly(dbConnection);
//		}	
//		
//		return film;
//	}
//	
//	public List <Actor> findActorsInFilm (Film film){
//		List <Actor> actors = null;
//		ActorDAO actObj = new ActorDAO();
//		actors = actObj.findActorDetail(film);
//		
//		return actors;
//	}
//
//
//	@Override
//	public void save(Object anObject) throws SQLException {
//		// This will be a no-op because we won't allow changes to films
//	}
//	
//
//	
//	/**
//	 * Build the WHERE clause for this query based on the parameters passed.
//	 * If a string parameter is null or the empty string it won't be used.
//	 * If an integer parameter is zero, it won't be used.
//	 * If rating is null or unrated (UR) it won't be used 
//	 * @param titleSubstring matches a substring in the movie's title
//	 * @param descriptionSubstring matches a substring in the movie's description
//	 * @param lengthMaximum matches any movie of running time lengthMaximum or less
//	 * @param ratingMaximum matches any movie of with specified ratingMaximum or less
//	 * @return String
//	 */
//	private String buildString (String titleSubstring, String descriptionSubstring, int lengthMaximum, FilmRating ratingMaximum) {
//		final String OPENING_QUOTED_WILD_CARD = "'%";
//		final String CLOSING_QUOTED_WILD_CARD = "%'";
//		
//		int numberWhereClauses = 0;
//		StringBuilder stringBuilder = new StringBuilder(FILM_SELECT_STRING);
//		stringBuilder.append(" FROM ").append(getDBName()).append(".film").append(" WHERE ");
//		
//		// create the clause to select any movie that contains titleSubstring in its title
//		if ((titleSubstring != null) && (titleSubstring != "")) {
//			stringBuilder.append("title like ").
//			append(OPENING_QUOTED_WILD_CARD).
//			append(titleSubstring).
//			append(CLOSING_QUOTED_WILD_CARD);
//			numberWhereClauses++;
//		}
//		
//		// create the clause to select any movie that contains descriptionSubstring in its description
//		if ((descriptionSubstring != null) && (descriptionSubstring != "")) {
//			if (numberWhereClauses != 0) {
//				stringBuilder.append(" AND ");
//			}
//			stringBuilder.append("description like ").
//			append(OPENING_QUOTED_WILD_CARD).
//			append(descriptionSubstring).
//			append(CLOSING_QUOTED_WILD_CARD);
//			numberWhereClauses++;
//		}
//		
//		// create the clause to select any movie that has a running time <= lengthMaximum
//		if (lengthMaximum > 0)  {
//			if (numberWhereClauses != 0) {
//				stringBuilder.append(" AND ");
//			}
//			stringBuilder.append("length <= ").append(String.valueOf(lengthMaximum));
//			numberWhereClauses++;
//		}
//		
//		// create the clause to select any movie with a rating <= ratingMaximum
//		// Note: Sakila stores movie ratings as enums that can be queried by their ordinal 
//		// values. Ordinals for MySQL enum fields are assigned in order of declaration, just
//		// as they are in Java; however, MySQL ordinals begin with 1, not 0
//		if ((ratingMaximum != null) && (ratingMaximum != FilmRating.UR)){
//			if (numberWhereClauses != 0) {
//				stringBuilder.append(" AND ");
//			}
//			int databaseRatingOrdinal = ratingMaximum.ordinal() + 1;
//			stringBuilder.append("rating = ").append(databaseRatingOrdinal);
//			numberWhereClauses++;
//		}
//		String selectString = stringBuilder.toString();
//		LOGGER.info(selectString);
//		return selectString;
//	}
//
//	private List<Film> buildResults (ResultSet results) {
//		
//		Random rand = new Random();
//		ArrayList <Film> films  = new ArrayList <Film> ();
//		FilmFactory filmFactory = new FilmFactory ();
//		try {
//			while (results.next()) {
//				int  n = rand.nextInt(20);
//				int    id             =  results.getInt   (FILM_ID_COLUMN );
//				String filmTitle       = results.getString(FILM_TITLE_COLUMN );
//				String filmDescription = results.getString(FILM_DESCRIPTION_COLUMN);
//				int    filmLength      = results.getInt   (FILM_LENGTH_COLUMN);
//				String filmRating      = results.getString(FILM_RATING_COLUMN);
//				String release_year    = results.getString(FILM_RELEASE_YEAR);
//				
//				Film film = filmFactory.makeFilm(id, filmTitle, filmDescription, release_year, filmLength, filmRating, movPoster[n]);
//				films.add(film);
//			}
//		} catch (SQLException e) {
//			LOGGER.severe(e.toString());
//		}
//		return films;
//	}
//}

package edu.txstate.cyberflix.data.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.lang.*;
import java.util.Random;
import edu.txstate.internet.cyberflix.data.actor.Actor;
import edu.txstate.internet.cyberflix.data.film.Film;
import edu.txstate.internet.cyberflix.data.film.FilmCategory;
import edu.txstate.internet.cyberflix.data.film.Film.FilmRating;
import edu.txstate.internet.cyberflix.data.helper.FilmFactory;

/**
 * @author Two
 *
 */
public class FilmDAO extends DAO {
	private final static Logger LOGGER = Logger.getLogger(FilmDAO.class.getName());

	private static final int FILM_ID_COLUMN = 1;
	private static final int FILM_TITLE_COLUMN = 2;
	private static final int FILM_DESCRIPTION_COLUMN = 3;
	private static final int FILM_LENGTH_COLUMN = 4;
	private static final int FILM_RATING_COLUMN = 5;
	private static final int FILM_RELEASE_YEAR = 6;

	private static final String FILM_SELECT_STRING = "SELECT film.film_id, film.title, film.description,"
			+ "film.length, film.rating, film.release_year ";

	String movPoster[] = { "https://photos.filmibeat.com/ph-big/2012/08/oh-my-god_13455282950.jpg",
			"http://athenaposters.ca/wp-content/uploads/2017/05/RP15092-Beauty-The-Beast-One-Sheet.jpg",
			"http://img.moviepostershop.com/titanic-movie-poster-1997-1020339699.jpg",
			"http://img.moviepostershop.com/the-hangover-movie-poster-2009-1020488737.jpg",
			"https://i.pinimg.com/736x/35/09/96/3509966fbcc98784e47c53854fbadb58--art-movies-alternative-movie-posters.jpg",
			"http://www.wearemoviegeeks.com/wp-content/uploads/the-avengers-movie-poster.jpg",
			"https://2982-presscdn-29-70-pagely.netdna-ssl.com/wp-content/uploads/2015/11/hunger-games-catching-fire-movie-poster.jpg",
			"http://www.fatmovieguy.com/wp-content/uploads/2013/05/Snitch-Movie-Poster.jpg",
			"https://petapixel.com/assets/uploads/2016/08/posterfix-449x700.jpg",
			"http://img.moviepostershop.com/the-magnificent-seven-movie-poster-2016-1020776374.jpg",
			"https://www.fashiongonerogue.com/wp-content/uploads/2015/04/britt-robertson-tomorrowland-movie-poster.jpg",
			"https://www.aboutamom.com/wp-content/uploads/2013/03/Iron-Man-3-Movie-Poster-Collage.jpg",
			"https://i.pinimg.com/736x/95/42/b6/9542b6b0d74585d9dc8e9100a0466f09--new-movie-posters-poster-film.jpg",
			"http://16391-presscdn-0-53.pagely.netdna-cdn.com/wp-content/uploads/2015/05/moviepostersremake2.jpg",
			"http://i.perezhilton.com/wp-content/uploads/2013/04/chris-hemworth-on-the-first-official-movie-poster-for-thor-the-dark-world__oPt.jpg",
			"http://starwarsblog.starwars.com/wp-content/uploads/2016/10/rogueone_onesheetA.jpg",
			"https://www.movieposter.com/posters/archive/main/98/MPW-49246",
			"https://i.pinimg.com/736x/0a/fa/f0/0afaf0714cf427bd62a5e96818dbece6--sad-movies-watch-movies.jpg",
			"https://i.pinimg.com/736x/93/d4/ab/93d4ab4c3bf7952ebe9e5ec23aa1b4c9--disney-movies-posters-childrens-movies.jpg",
			"https://images-production.global.ssl.fastly.net/uploads/posts/image/70431/the-jungle-book-first-disney-movie-poster.png" };

	public static void main(String args[]) {
		System.out.println("Newest Films: \n***************************");
		FilmDAO fd = new FilmDAO();
		List<Film> f = fd.findNewestFilms();

		for (int i = 0; i < f.size(); i++) {
			System.out.println(f.get(i).getTitle());
		}
		System.out.println("\n\n");
		List<Film> fCat = fd.findFilmsByCategory(FilmCategory.ACTION);
		System.out.println("Films by category ACTION: \n************************");
		for (int i = 0; i < fCat.size(); i++) {
			System.out.println(fCat.get(i).getTitle());
		}
		System.out.println("\n\n");
		List<Film> fAl = fd.findFilmsAlphabetically("k");
		System.out.println("Films Alphabetically by 'K': \n***************************");
		for (int i = 0; i < fAl.size(); i++) {
			System.out.println(fAl.get(i).getTitle());
		}
		System.out.println("\n\n");
		Film f1 = fd.getFilmDetail(fAl.get(1));
		System.out.println("Film details for " + f1.getTitle() + ": \n*************************");
		System.out.println("Description: " + f1.getDescription());
		System.out.println("Release Year: " + f1.getReleaseYear());
		System.out.println("Genre: " + f1.getCategory());
		System.out.println("Length: " + f1.getLength());
		// System.out.println(f1);

		System.out.println("\n\n");
		System.out.println("Films by attributes: \n***************************");
		List<Film> a1 = fd.findFilmsByAttributes("", "", 60, null);
		for (int i = 0; i < a1.size(); i++) {
			System.out.println(a1.get(i).getTitle());
		}
		System.out.println("\n\n");
		List<Actor> l1 = fd.findActorsInFilm(fAl.get(1));
		System.out.println("Actors in " + f1.getTitle() + ": \n*************************");
		for (int i = 0; i < l1.size(); i++) {
			System.out.println(l1.get(i).getFirstName() + " " + l1.get(i).getLastName());
		}

		System.out.println("\n\n");
		System.out.println("Trying to find a customer with the email MARY.SMITH@sakilacustomer.org");
		CustomerDAO cusDAO = new CustomerDAO();
		// Customer cus =
		// cusDAO.findCustomerByEmail("MARY.SMITH@sakilacustomer.org");
		// System.out.println("Customer name: "+cus.getFirstName()+" "+
		// cus.getLastName());
	}

	public List<Film> findNewestFilms() {
		String selectString = "SELECT film_id, title, description, length, rating, release_year FROM Film WHERE release_year=2017";
		List<Film> films = null;
		Connection dbConnection = null;
		try {
			dbConnection = DAO.getDBConnection();
			System.out.println(dbConnection);
			Statement statement = dbConnection.createStatement();
			ResultSet results = statement.executeQuery(selectString);
			films = buildResults(results);
			dbConnection.close();
		}
		catch (SQLException e) {
			System.err.println("FilmDAO.findNewestFilms: " + e.toString());
			LOGGER.severe(e.toString());
			closeQuietly(dbConnection);
		}
		return films;
	}

	public List<Film> findFilmsByAttributes(String title, String description, int length, FilmRating rating) {
		String selectString = buildString(title, description, length, rating);
		List<Film> films = null;
		Connection dbConnection = DAO.getDBConnection();
		System.out.println(dbConnection);
		try {
			dbConnection = DAO.getDBConnection();
			System.out.println(dbConnection);
			Statement statement = dbConnection.createStatement();
			ResultSet results = statement.executeQuery(selectString);
			films = buildResults(results);
			dbConnection.close();
		}
		catch (SQLException e) {
			System.err.println("FilmDAO.findFilmsByAttributes: " + e.toString());
			LOGGER.severe(e.toString());
			closeQuietly(dbConnection);
		}
		return films;
	}

	public List<Film> findFilmsByCategory(FilmCategory category) {
		final String FILM_SELECT_STRING = "SELECT film.film_id, film.title, film.description, film.length, film.rating, film.release_year ";
		final String CATEGORY_CLAUSES = " FROM film, film_category WHERE film.film_id = film_category.film_id AND film_category.category_id =";
		StringBuilder stringBuilder = new StringBuilder(FILM_SELECT_STRING);
		stringBuilder.append(CATEGORY_CLAUSES);
		stringBuilder.append(category.ordinal() + 1);
		String selectString = stringBuilder.toString();

		List<Film> films = null;
		Connection dbConnection = null;
		try {
			dbConnection = DAO.getDBConnection();
			Statement statement = dbConnection.createStatement();
			ResultSet results = statement.executeQuery(selectString);
			films = buildResults(results);
			dbConnection.close();
		}
		catch (SQLException e) {
			System.err.println("FilmDAO.findFilmsByCategory: " + e.toString());
			LOGGER.severe(e.toString());
			closeQuietly(dbConnection);
		}
		return films;
	}

	public List<Film> findFilmsAlphabetically(String firstCharacter) {
		String selectString = "SELECT film_id, title, description, length, rating, release_year  FROM film  WHERE title LIKE '"
				+ firstCharacter + "%';";
		List<Film> films = null;
		Connection dbConnection = null;
		try {
			dbConnection = DAO.getDBConnection();
			Statement statement = dbConnection.createStatement();
			ResultSet results = statement.executeQuery(selectString);
			films = buildResults(results);
			dbConnection.close();
		}
		catch (SQLException e) {
			System.err.println("FilmDAO.findFilmsAlphabetically: " + e.toString());
			LOGGER.severe(e.toString());
			closeQuietly(dbConnection);
		}
		return films;

	}

	public Film getFilmDetail(Film film) {
		Connection dbConnection = null;
		try {
			dbConnection = DAO.getDBConnection();
			String selectTableSQL = "SELECT name FROM category where category_id in (SELECT category_id FROM film_category WHERE film_id ="
					+ film.getFilmID() + ");";
			Statement statement = dbConnection.createStatement();
			ResultSet results = statement.executeQuery(selectTableSQL);
			if (results.next()) {
				// System.out.println("Has Next");
				String cat = results.getString(1);
				film.setCategory(cat);
			}
			// films = buildResults (results);
			dbConnection.close();

		}
		catch (SQLException e) {
			System.err.println("FilmDAO.findNewestFilms: " + e.toString());
			LOGGER.severe(e.toString());
			closeQuietly(dbConnection);
		}

		return film;
	}

	public List<Actor> findActorsInFilm(Film film) {
		List<Actor> actors = null;
		ActorDAO actObj = new ActorDAO();
		actors = actObj.findActorDetail(film);

		return actors;
	}

	@Override
	public void save(Object anObject) throws SQLException {
		// This will be a no-op because we won't allow changes to films
	}

	/**
	 * Build the WHERE clause for this query based on the parameters passed. If a
	 * string parameter is null or the empty string it won't be used. If an
	 * integer parameter is zero, it won't be used. If rating is null or unrated
	 * (UR) it won't be used
	 * 
	 * @param titleSubstring
	 *          matches a substring in the movie's title
	 * @param descriptionSubstring
	 *          matches a substring in the movie's description
	 * @param lengthMaximum
	 *          matches any movie of running time lengthMaximum or less
	 * @param ratingMaximum
	 *          matches any movie of with specified ratingMaximum or less
	 * @return String
	 */
	private String buildString(String titleSubstring, String descriptionSubstring, int lengthMaximum,
			FilmRating ratingMaximum) {
		final String OPENING_QUOTED_WILD_CARD = "'%";
		final String CLOSING_QUOTED_WILD_CARD = "%'";

		int numberWhereClauses = 0;
		StringBuilder stringBuilder = new StringBuilder(FILM_SELECT_STRING);
		stringBuilder.append(" FROM ").append(getDBName()).append(".film").append(" WHERE ");

		// create the clause to select any movie that contains titleSubstring in its
		// title
		if ((titleSubstring != null) && (titleSubstring != "")) {
			stringBuilder.append("title like ").append(OPENING_QUOTED_WILD_CARD).append(titleSubstring)
					.append(CLOSING_QUOTED_WILD_CARD);
			numberWhereClauses++;
		}

		// create the clause to select any movie that contains descriptionSubstring
		// in its description
		if ((descriptionSubstring != null) && (descriptionSubstring != "")) {
			if (numberWhereClauses != 0) {
				stringBuilder.append(" AND ");
			}
			stringBuilder.append("description like ").append(OPENING_QUOTED_WILD_CARD).append(descriptionSubstring)
					.append(CLOSING_QUOTED_WILD_CARD);
			numberWhereClauses++;
		}

		// create the clause to select any movie that has a running time <=
		// lengthMaximum
		if (lengthMaximum > 0) {
			if (numberWhereClauses != 0) {
				stringBuilder.append(" AND ");
			}
			stringBuilder.append("length <= ").append(String.valueOf(lengthMaximum));
			numberWhereClauses++;
		}

		// create the clause to select any movie with a rating <= ratingMaximum
		// Note: Sakila stores movie ratings as enums that can be queried by their
		// ordinal
		// values. Ordinals for MySQL enum fields are assigned in order of
		// declaration, just
		// as they are in Java; however, MySQL ordinals begin with 1, not 0
		if ((ratingMaximum != null) && (ratingMaximum != FilmRating.UR)) {
			if (numberWhereClauses != 0) {
				stringBuilder.append(" AND ");
			}
			int databaseRatingOrdinal = ratingMaximum.ordinal() + 1;
			stringBuilder.append("rating = ").append(databaseRatingOrdinal);
			numberWhereClauses++;
		}
		String selectString = stringBuilder.toString();
		LOGGER.info(selectString);
		return selectString;
	}

	private List<Film> buildResults(ResultSet results) {

		Random rand = new Random();
		ArrayList<Film> films = new ArrayList<Film>();
		FilmFactory filmFactory = new FilmFactory();
		try {
			while (results.next()) {
				int n = rand.nextInt(20);
				int id = results.getInt(FILM_ID_COLUMN);
				String filmTitle = results.getString(FILM_TITLE_COLUMN);
				String filmDescription = results.getString(FILM_DESCRIPTION_COLUMN);
				int filmLength = results.getInt(FILM_LENGTH_COLUMN);
				String filmRating = results.getString(FILM_RATING_COLUMN);
				String release_year = results.getString(FILM_RELEASE_YEAR);

				Film film = filmFactory.makeFilm(id, filmTitle, filmDescription, release_year, filmLength, filmRating,
						movPoster[n]);
				films.add(film);
			}
		}
		catch (SQLException e) {
			LOGGER.severe(e.toString());
		}
		return films;
	}
}
