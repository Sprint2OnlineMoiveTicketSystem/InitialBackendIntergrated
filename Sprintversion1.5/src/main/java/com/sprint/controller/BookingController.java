package com.sprint.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.dao.BookingDao;
import com.sprint.dao.SeatDao;
import com.sprint.dao.ShowDao;
import com.sprint.model.Booking;
import com.sprint.model.Seat;
import com.sprint.service.BookingService;

@RestController
@RequestMapping("/Booking")
public class BookingController {

	@Autowired
	BookingService bservice;

	@Autowired
	BookingDao bdao;

	@Autowired
	SeatDao sdao;

	@Autowired
	ShowDao showdao;

	/////////////// Add Booking\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

	@PostMapping(value = "/addBooking")
	public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
		return new ResponseEntity<Booking>(bservice.addBooking(booking), HttpStatus.OK);

	}

	////////////// Cancel Booking \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

	@DeleteMapping(value = "/cancelBooking/{bookingId}")
	public ResponseEntity<String> cancelBooking(@PathVariable("bookingId") Integer bookingId) {
		return new ResponseEntity<String>(bservice.cancelBooking(bookingId), HttpStatus.OK);
	}


	///////////// Get All Booking\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

	@RequestMapping(value = "/getAllBookings", method = RequestMethod.GET)
	public ResponseEntity<List<Booking>> getAllBooking(Booking booking) {
		return new ResponseEntity<>(bservice.getallBooking(booking), HttpStatus.OK);
	}


}
