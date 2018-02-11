package edu.txstate.cyberflix.data.db;

public class Staff {
	private int id;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String password;

	public Staff(int id, String firstName, String lastName, String emailAddress, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.password = password;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return emailAddress;
	}

	public void setEmail(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "First Name = " + firstName + "\n" + "Last Name = " + lastName + "\n" + "Email Address = " + emailAddress
				+ "\n" + "Password = " + password;
	}

}
