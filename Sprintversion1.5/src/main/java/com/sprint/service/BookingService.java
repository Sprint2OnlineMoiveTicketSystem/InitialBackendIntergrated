package com.sprint.service;

import java.util.List;

import com.sprint.model.Booking;
import com.sprint.model.Seat;

public interface BookingService {

	public String cancelBooking(int id);
	public List<Booking> getallBooking(Booking booking);
	public Booking addBooking(Booking booking);
}
