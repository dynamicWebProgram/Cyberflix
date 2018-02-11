package edu.txstate.cyberflix.data.db;

//import edu.txstate.internet.cyberflix.data.customer.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import edu.txstate.cyberflix.data.db.DAO;
import edu.txstate.cyberflix.login.AuthenticationStaffService;
import java.util.logging.Logger;

public class StaffDAO extends DAO {
	private final static Logger LOGGER = Logger.getLogger(StaffDAO.class.getName());
	private static final String CUSTOMER_SELECT_STRING = "SELECT staff_id, first_name, last_name, email, password FROM staff ";

	private static final int CUSTOMER_ID_COLUMN = 1;
	private static final int CUSTOMER_FIRST_NAME_COLUMN = 2;
	private static final int CUSTOMER_LAST_NAMECOLUMN = 3;
	private static final int CUSTOMER_EMAIL_COLUMN = 4;
	private static final int CUSTOMER_PASSWORD_COLUMN = 5;

	public Staff validateStaff(String emailAddress, String password) {
		StringBuilder stringBuilder = new StringBuilder(CUSTOMER_SELECT_STRING);
		stringBuilder.append(" WHERE email = \'");
		stringBuilder.append(emailAddress);
		stringBuilder.append("\'");

		String selectString = stringBuilder.toString();
		// Prints database info
		// LOGGER.info(selectString);
		Staff staff = null;
		Connection dbConnection = null;
		try {
			dbConnection = DAO.getDBConnection();
			Statement statement = dbConnection.createStatement();
			ResultSet results = statement.executeQuery(selectString);
			staff = buildResults(results);
			dbConnection.close();
		}
		catch (SQLException e) {
			System.err.println("StaffDAO.findCustomer: " + e.toString());
			LOGGER.severe(e.toString());
			closeQuietly(dbConnection);
		}
		return staff;
	}

	private Staff buildResults(ResultSet results) {
		Staff staff = null;
		try {
			if (results.next()) {
				int id = results.getInt(CUSTOMER_ID_COLUMN);
				String firstName = results.getString(CUSTOMER_FIRST_NAME_COLUMN);
				String lastName = results.getString(CUSTOMER_LAST_NAMECOLUMN);
				String email = results.getString(CUSTOMER_EMAIL_COLUMN);
				String password = results.getString(CUSTOMER_PASSWORD_COLUMN);
				staff = new Staff(id, firstName, lastName, email, password);
			}
		}
		catch (SQLException e) {
			LOGGER.severe(e.toString());
		}
		return staff;
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

	@Override
	public void save(Object anObject) throws SQLException {
		// TODO Auto-generated method stub

	}

}
