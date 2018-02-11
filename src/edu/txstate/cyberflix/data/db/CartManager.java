package edu.txstate.cyberflix.data.db;

import java.util.ArrayList;
import java.util.List;
import edu.txstate.internet.cyberflix.data.film.FilmCatalog;

public class CartManager {

	private List<Cart> cartArray;
	private List<String> idArray;
	private static CartManager instance = null;

	CartManager() {
		cartArray = new ArrayList<Cart>();
		idArray = new ArrayList<String>();
	}

	public static CartManager getInstance() {
		if (instance == null) {
			instance = new CartManager();
		}
		return instance;
	}

	int ind = -1;

	public Cart getCart(String sesID) {

		if (idArray.size() == 0) {
			ind = addCart(sesID);
		}
		else {
			boolean found = false;
			for (int i = 0; i < idArray.size(); i++) {
				if (idArray.get(i) == sesID) {
					found = true;
					return cartArray.get(i);
				}
			}
			if (!found) {
				ind = addCart(sesID);
			}
		}
		return cartArray.get(ind);
	}

	private int addCart(String sesID) {
		Cart freshCart = new Cart();
		cartArray.add(freshCart);
		idArray.add(sesID);
		return (cartArray.size() - 1);
	}

}
