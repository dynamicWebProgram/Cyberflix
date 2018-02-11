package edu.txstate.cyberflix.data.db;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
	private static List<Customer> customerArray = new ArrayList<Customer>();
	private static List<String> idArray = new ArrayList<String>();
	private static CustomerManager instance = null;

	CustomerManager() {
		customerArray = new ArrayList<Customer>();
		idArray = new ArrayList<String>();
	}

	public static CustomerManager getInstance() {
		if (instance == null) {
			instance = new CustomerManager();
		}
		return instance;
	}

	static int ind = 0;

	public static Customer getCustomer(String sesID) {

		if (idArray.size() == 0) {
			System.out.println("idArray is 0");

		}
		else {
			System.out.println(sesID);
			boolean found = false;
			for (int i = 0; i < idArray.size(); i++) {
				System.out.println("in for loop: " + sesID);
				if (idArray.get(i) == sesID) {
					System.out.println("found customer");
					found = true;
					return customerArray.get(i);
				}
			}
			if (!found) {
				ind = 0;
			}
		}
		System.out.println(customerArray.size() + " " + idArray.size());
		return customerArray.get(ind);
	}

	public static void addCustomer(String sesID, Customer customer) {
		System.out.println(customer.getFirstName());
		customerArray.add(customer);
		System.out.println(customerArray.size());
		idArray.add(sesID);
		System.out.println(idArray.size());
		// return (customerArray.size()-1);
	}

}
