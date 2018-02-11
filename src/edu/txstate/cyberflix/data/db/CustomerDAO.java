package edu.txstate.cyberflix.data.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import edu.txstate.internet.cyberflix.data.actor.Actor;
import edu.txstate.cyberflix.data.db.Customer;
import edu.txstate.internet.cyberflix.data.film.Film;
import edu.txstate.internet.cyberflix.data.helper.FilmFactory;

public class CustomerDAO extends DAO {
	private final static Logger LOGGER = Logger.getLogger(CustomerDAO.class.getName());
	private static final String CUSTOMER_SELECT_STRING = "SELECT customer_id, first_name, last_name, email, password FROM CUSTOMER ";

	private static final int CUSTOMER_ID_COLUMN = 1;
	private static final int CUSTOMER_FIRST_NAME_COLUMN = 2;
	private static final int CUSTOMER_LAST_NAMECOLUMN = 3;
	private static final int CUSTOMER_EMAIL_COLUMN = 4;
	private static final int CUSTOMER_PASSWORD_COLUMN = 5;

	public void addCustomer(Customer customer) {
		try {
			String fName = customer.getFirstName();
			String lName = customer.getLastName();
			String email = customer.getEmailAddress();
			String password = customer.getPassword();

			String sql = "INSERT INTO customer ( first_name, last_name, email, password) VALUES(" + fName + "', '" + lName
					+ "', '" + email + "', '" + password + "')";
			Connection conn = DAO.getDBConnection();
			Statement statement = conn.createStatement();
			statement.executeUpdate(sql);
			statement.close();
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Customer findCustomer(String emailAddress) {
		StringBuilder stringBuilder = new StringBuilder(CUSTOMER_SELECT_STRING);
		stringBuilder.append(" WHERE email = \'");
		stringBuilder.append(emailAddress);
		stringBuilder.append("\'");

		String selectString = stringBuilder.toString();
		LOGGER.info(selectString);
		Customer customer = null;
		Connection dbConnection = null;
		try {
			dbConnection = DAO.getDBConnection();
			Statement statement = dbConnection.createStatement();
			ResultSet results = statement.executeQuery(selectString);
			customer = buildResults(results);
			dbConnection.close();
		}
		catch (SQLException e) {
			System.err.println("CustomerDAO.findCustomer: " + e.toString());
			LOGGER.severe(e.toString());
			closeQuietly(dbConnection);
		}
		return customer;
	}

	public void save(Object object) {
		if ((object instanceof Customer) == false)
			return;
		Customer customer = (Customer) object;
		String insertString1 = "INSERT INTO CUSTOMER (customer_id,store_id, first_name,last_name, email, address_id, "
				+ "password, active,create_date,last_update) ";
		String insertString2 = " VALUES (null, 1, ?, ?, ?, ?, ?, 1, now(), null)";

		StringBuilder stringBuilder = new StringBuilder(insertString1).append(insertString2);
		String customerInsertString = stringBuilder.toString();
		LOGGER.info(customerInsertString);
		Connection dbConnection = null;
		try {
			dbConnection = DAO.getDBConnection();
			PreparedStatement insertStatement = dbConnection.prepareStatement(customerInsertString);
			insertStatement.setString(CUSTOMER_ID_COLUMN, customer.getFirstName());
			insertStatement.setString(CUSTOMER_FIRST_NAME_COLUMN, customer.getLastName());
			insertStatement.setString(CUSTOMER_LAST_NAMECOLUMN, customer.getEmailAddress());
			insertStatement.setInt(CUSTOMER_EMAIL_COLUMN, randomAddress());
			insertStatement.setString(CUSTOMER_PASSWORD_COLUMN, customer.getPassword());
			int results = insertStatement.executeUpdate();
			LOGGER.info(String.valueOf(results));
			dbConnection.close();
		}
		catch (SQLException e) {
			System.err.println("CustomerDAO.insertCustomer: " + e.toString());
			LOGGER.severe(e.toString());
			closeQuietly(dbConnection);
		}

	}

	private Customer buildResults(ResultSet results) {
		Customer customer = null;
		try {
			if (results.next()) {
				int id = results.getInt(CUSTOMER_ID_COLUMN);
				String firstName = results.getString(CUSTOMER_FIRST_NAME_COLUMN);
				String lastName = results.getString(CUSTOMER_LAST_NAMECOLUMN);
				String email = results.getString(CUSTOMER_EMAIL_COLUMN);
				String password = results.getString(CUSTOMER_PASSWORD_COLUMN);
				customer = new Customer(id, firstName, lastName, email, password);
			}
		}
		catch (SQLException e) {
			LOGGER.severe(e.toString());
		}
		return customer;
	}

	private String quoteString(String thing) {
		StringBuilder stringBuilder = new StringBuilder("'").append(thing).append("'");
		return stringBuilder.toString();
	}

	private int randomAddress() {
		// There are 603 addresses in the Sakila database, pick one
		// to assign to this customer
		int randomAddressId = (int) (Math.random() * 603);
		return randomAddressId;
	}

}