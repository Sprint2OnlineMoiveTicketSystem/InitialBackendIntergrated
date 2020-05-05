package com.sprint.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "booking")
public class Booking implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bookingId;
	private int movieId;
	private int showId;
	private int screenId;
	private LocalDate bookingDate;
	private double totalCost;
	private int noofseats;
	
	@OneToOne(mappedBy = "booking",targetEntity = Show.class, cascade = CascadeType.ALL)
	@JsonManagedReference
	private Show showref;
	

	/**
	 * @return the bookingId
	 */
	public int getBookingId() {
		return bookingId;
	}

	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	/**
	 * @return the movieId
	 */
	public int getMovieId() {
		return movieId;
	}

	/**
	 * @param movieId the movieId to set
	 */
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	/**
	 * @return the showId
	 */
	public int getShowId() {
		return showId;
	}

	/**
	 * @param showId the showId to set
	 */
	public void setShowId(int showId) {
		this.showId = showId;
	}

	/**
	 * @return the screenId
	 */
	public int getScreenId() {
		return screenId;
	}

	/**
	 * @param screenId the screenId to set
	 */
	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	/**
	 * @return the bookingDate
	 */
	public LocalDate getBookingDate() {
		return bookingDate;
	}

	/**
	 * @param bookingDate the bookingDate to set
	 */
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	/**
	 * @return the totalCost
	 */
	public double getTotalCost() {
		return totalCost;
	}

	/**
	 * @param totalCost the totalCost to set
	 */
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	/**
	 * @return the noofseats
	 */
	public int getNoofseats() {
		return noofseats;
	}

	/**
	 * @param noofseats the noofseats to set
	 */
	public void setNoofseats(int noofseats) {
		this.noofseats = noofseats;
	}

	/**
	 * @return the showref
	 */
	public Show getShowref() {
		return showref;
	}

	/**
	 * @param showref the showref to set
	 */
	public void setShowref(Show showref) {
		this.showref = showref;
	}

	public Booking() {
		super();
	}

	/**
	 * @param movieId
	 * @param showId
	 * @param screenId
	 * @param bookingDate
	 * @param totalCost
	 * @param noofseats
	 * @param showref
	 */
	public Booking(int movieId, int showId, int screenId, LocalDate bookingDate, double totalCost, int noofseats,
			Show showref) {
		super();
		this.movieId = movieId;
		this.showId = showId;
		this.screenId = screenId;
		this.bookingDate = bookingDate;
		this.totalCost = totalCost;
		this.noofseats = noofseats;
		this.showref = showref;
	}


	
	
}
