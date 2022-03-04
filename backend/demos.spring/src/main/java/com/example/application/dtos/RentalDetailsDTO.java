package com.example.application.dtos;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import com.example.domains.entities.Customer;
import com.example.domains.entities.Inventory;
import com.example.domains.entities.Payment;
import com.example.domains.entities.Rental;
import com.example.domains.entities.Staff;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Value;

@Value
public class RentalDetailsDTO {

	@JsonProperty("id")
	private int rentalId;
	@JsonProperty("Cliente")
	private String customer;
	@JsonProperty("titulo")
	private String title;
	private String empleado;//staff
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date rentalDate;
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date returnDate;	
	private List<PaymentDetailsDTO> payments;
	

	public static RentalDetailsDTO from(Rental source) {
		return new RentalDetailsDTO(
				source.getRentalId(),
				source.getCustomer().getFirstName() + " " + source.getCustomer().getLastName(),
				source.getInventory().getFilm().getTitle(),
				source.getStaff().getFirstName() + " " + source.getStaff().getLastName(),
				source.getRentalDate(),
				source.getReturnDate(),
				source.getPayments().stream().map(pago -> PaymentDetailsDTO.from(pago)).toList()
				);
	}
	
}
	
	
