package edu.txstate.cyberflix.data.db;

import java.util.Date;

public class RentalRecord {
	private int retailId = 0;
	private Date rentalDate = null;
	private int filmId = 0;
	private int customerId = 0;
	private Date returnDate = null;

	public RentalRecord(int retailId, Date rentalDate, int filmId, int customerId, Date returnDate) {
		this.retailId = retailId;
		this.rentalDate = rentalDate;
		this.filmId = filmId;
		this.customerId = customerId;
		this.returnDate = returnDate;
	}

	public int getRetailId() {
		return retailId;
	}

	public void setRetailId(int retailId) {
		this.retailId = retailId;
	}

	public Date getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

}
