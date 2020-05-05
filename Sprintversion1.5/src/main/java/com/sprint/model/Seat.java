package com.sprint.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="seat")
public class Seat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int seatId;
	private BookingState seatStatus = BookingState.AVAILABLE ;
	private final double seatPrice=200;
	final private int seat_capacity = 50;   
	@ManyToOne
	@JsonBackReference
	private Booking booking;
	
	public Seat() {

	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public BookingState getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(BookingState seatStatus) {
		this.seatStatus = seatStatus;
	}

	public double getSeatPrice() {
		return seatPrice;
	}


	/**
	 * @return the seat_capacity
	 */
	public int getSeat_capacity() {
		return seat_capacity;
	}

	/**
	 * @return the booking
	 */
	public Booking getBooking() {
		return booking;
	}

	/**
	 * @param booking the booking to set
	 */
	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	/**
	 * @param seatStatus
	 * @param booking
	 */
	public Seat(BookingState seatStatus, Booking booking) {
		super();
		this.seatStatus = seatStatus;
		this.booking = booking;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", seatStatus=" + seatStatus + ", seatPrice=" + seatPrice + ", seat_capacity="
				+ seat_capacity + ", booking=" + booking + "]";
	}
	
	

}
