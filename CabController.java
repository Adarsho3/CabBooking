package com.app.cabbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.cabbooking.exception.ResourceNotfoundException;
import com.app.cabbooking.models.Cab;
import com.app.cabbooking.repository.CarRepository;

@RestController
@RequestMapping("/bookcab.com")
public class CabController {
	@Autowired
	private CarRepository CR;
	
	@GetMapping(value="/cabinfo")
	public List<Cab>AllBookingDetails(){
		return CR.findAll();
	}
	@PostMapping(value="/bookingportal")
	public Cab NewBooking(@RequestBody Cab C) {
		return CR.save(C);
	}
	//API for UPDATING Booking Details
	@PutMapping(value="/updateBooking")
	public Cab UpdateCabDetails(@PathVariable(value="id") Long cabId, @RequestBody Cab c) {
		Cab setCab = CR.findById(cabId).orElseThrow(()-> new ResourceNotfoundException(cabId, "id","Cab"));
		setCab.setPickup_point(c.getPickup_point());
		setCab.setDroping_pont(c.getDroping_pont());
		setCab.setCurrent_place(c.getCurrent_place());
		Cab updateCab= CR.save(setCab);
		return updateCab;
	}
	
	@DeleteMapping(value="/deletebooking")
	public ResponseEntity<?> DeleteDetails(@PathVariable(value="id") Long cabId){
		Cab cb = CR.findById(cabId).orElseThrow(()->new ResourceNotfoundException(cabId,"id","cab"));
		CR.delete(cb);
		return ResponseEntity.ok().build();
	}

}

