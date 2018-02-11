package edu.txstate.cyberflix.data.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import edu.txstate.internet.cyberflix.data.actor.Actor;
import edu.txstate.internet.cyberflix.data.film.Film;
import edu.txstate.internet.cyberflix.data.helper.ActorFactory;

public class ActorDAO extends DAO {
	private final static Logger LOGGER = Logger.getLogger(FilmDAO.class.getName());

	private static final int ACTOR_ID_COLUMN = 1;
	private static final int FIRST_NAME = 2;
	private static final int LAST_NAME = 3;

	public List<Actor> findActorDetail(Film film) {
		List<Actor> actors = null;
		Connection dbConnection = null;
		try {
			dbConnection = DAO.getDBConnection();
			String selectTableSQL = "select actor_id, first_name, last_name from actor where actor_id in (select actor_id from film_actor where film_id ="
					+ film.getFilmID() + ");";
			Statement statement = dbConnection.createStatement();
			ResultSet results = statement.executeQuery(selectTableSQL);
			actors = buildResults(results);
			dbConnection.close();
		}
		catch (SQLException e) {
			System.err.println("FilmDAO.findFilmsByAttributes: " + e.toString());
			LOGGER.severe(e.toString());
			closeQuietly(dbConnection);
		}
		return actors;
	}

	private List<Actor> buildResults(ResultSet results) {
		ArrayList<Actor> actors = new ArrayList<Actor>();
		ActorFactory ActorFactory = new ActorFactory();
		try {
			while (results.next()) {
				int id = results.getInt(ACTOR_ID_COLUMN);
				String firstName = results.getString(FIRST_NAME);
				String lastName = results.getString(LAST_NAME);
				Actor actor = ActorFactory.makeActor(id, firstName, lastName);
				actors.add(actor);
			}
		}
		catch (SQLException e) {
			LOGGER.severe(e.toString());
		}
		return actors;
	}

	@Override
	public void save(Object anObject) throws SQLException {
		// TODO Auto-generated method stub

	}
}
