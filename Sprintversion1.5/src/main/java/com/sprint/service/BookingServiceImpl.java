package com.sprint.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.dao.BookingDao;
import com.sprint.dao.SeatDao;
import com.sprint.error.EntityAlreadyPresentException;
import com.sprint.model.Booking;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	BookingDao bdao;
	
	@Autowired
	SeatDao sdao;
	
	@Override
	public String cancelBooking(int id) {
		// TODO Auto-generated method stub
		Optional<Booking> booking = bdao.findById(id) ;
		if(!booking.isPresent() || booking == null) {
			return "No booking found for given id!" ;
		}
		bdao.deleteById(id);
		return "Booking Deleted Successfully!";
	}

	@Override
	public List<Booking> getallBooking(Booking booking) {
		// TODO Auto-generated method stub
			List<Booking> bookings = bdao.findAll();
			return bookings;
	}
	//adding a booking
	@Override
	public Booking addBooking(Booking booking) {
		Optional<Booking> findbyId = bdao.findById(booking.getBookingId());
			if(findbyId.isPresent()) {
				throw new EntityAlreadyPresentException("Already present");
			}else
				return bdao.save(booking);
	}
}
