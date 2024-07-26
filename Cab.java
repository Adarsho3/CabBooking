
package com.app.cabbooking.models;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value={"cabbooking_time","cabupdate_time"},allowGetters=true)
public class Cab {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Booking_id;

	private String vechcle_name;
	private String vechle_number;
	private String passenger_name;
	private String pickup_point;
	private String droping_pont;
	private String current_place;
	
	@Column(name = "cabbooking_time", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date booking_time;
	
	@Column(name = "cabupdate_time", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updating_time;
	
	public int getBooking_id() {
		return Booking_id;
	}
	public void setBooking_id(int booking_id) {
		Booking_id = booking_id;
	}
	public String getVechcle_name() {
		return vechcle_name;
	}
	public void setVechcle_name(String vechcle_name) {
		this.vechcle_name = vechcle_name;
	}
	public String getVechle_number() {
		return vechle_number;
	}
	public void setVechle_number(String vechle_number) {
		this.vechle_number = vechle_number;
	}
	public String getPassenger_name() {
		return passenger_name;
	}
	public void setPassenger_name(String passenger_name) {
		this.passenger_name = passenger_name;
	}
	public String getPickup_point() {
		return pickup_point;
	}
	public void setPickup_point(String pickup_point) {
		this.pickup_point = pickup_point;
	}
	public String getDroping_pont() {
		return droping_pont;
	}
	public void setDroping_pont(String droping_pont) {
		this.droping_pont = droping_pont;
	}
	public String getCurrent_place() {
		return current_place;
	}
	public void setCurrent_place(String current_place) {
		this.current_place = current_place;
	}
	public Date getBooking_time() {
		return booking_time;
	}
	public void setBooking_time(Date booking_time) {
		this.booking_time = booking_time;
	}
	public Date getUpdating_time() {
		return updating_time;
	}
	public void setUpdating_time(Date updating_time) {
		this.updating_time = updating_time;
	}
	
	
}
