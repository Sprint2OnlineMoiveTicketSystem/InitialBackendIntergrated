package com.sprint.service;

import com.sprint.model.Seat;

public interface SeatService {
	
	public Seat bookSeat(Seat seat);
	public String cancelSeat(int sid);
	
}
