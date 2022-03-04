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

import org.springframework.lang.NonNull;

import com.example.domains.entities.Actor;
import com.example.domains.entities.Category;
import com.example.domains.entities.Customer;
import com.example.domains.entities.Rental;
import com.example.domains.entities.Inventory;
import com.example.domains.entities.Language;
import com.example.domains.entities.Payment;
import com.example.domains.entities.Staff;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Value;

@Value @Data
public class RentalEditDTO {

	@JsonProperty("id")
	private int rentalId;
	@JsonProperty("cliente")
	@NonNull
	private int customer;
	@JsonProperty("pelicula")
	@NonNull
	private int inventory;
	@NonNull
	private int empleado;//staff
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date rentalDate;
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date returnDate;	
	private List<PaymentEditDTO> payments;
	

	public static RentalEditDTO from(Rental source) {
		return new RentalEditDTO(
				source.getRentalId(),
				source.getCustomer().getCustomerId(),
				source.getInventory().getInventoryId(),
				source.getStaff().getStaffId(),
				source.getRentalDate(),
				source.getReturnDate() == null ? null : source.getReturnDate(),
				source.getPayments().stream().map(pago -> PaymentEditDTO.from(pago)).toList()
				); 
	}
	
	public static Rental from(RentalEditDTO source) {
		return new Rental(
				source.getRentalId(),
				source.getRentalDate(),
				source.getReturnDate() == null ? null : source.getReturnDate(),
				new Customer(source.getCustomer()),
				new Inventory(source.getInventory()),
				new Staff(source.getEmpleado())				
				);
	}
	
	public Rental update(Rental target) {
		target.setRentalDate(rentalDate);
		target.setReturnDate(returnDate);
		target.setCustomer(new Customer(customer));
		target.setInventory(new Inventory(inventory));
		target.setStaff(new Staff(empleado));
		
		
			// Borra los alquileres que sobran
			var delAlquiladas = target.getPayments().stream()
					.filter(item -> payments.stream().noneMatch(pago -> pago.getPaymentId() == item.getPaymentId()))
					.toList();
			delAlquiladas.forEach(item -> target.removePayment(item));
			//Modifico los que han quedado
			target.getPayments().forEach(item -> {
				var nuevoPago = payments.stream().filter(pago -> pago.getPaymentId() == item.getPaymentId()).findFirst().get();
				if (item.getAmount() != nuevoPago.getAmount()) {	
					item.setAmount(nuevoPago.getAmount());
				}
				if (item.getPaymentDate() != nuevoPago.getFecha()) {	
					item.setPaymentDate(nuevoPago.getFecha());
				}
				if(item.getStaff().getStaffId() != nuevoPago.getEmpleado()) {
					item.setStaff(new Staff(nuevoPago.getEmpleado()));
				}
			});
//			// Añade los alquileres que falta
			payments.stream()
				.filter(paymentDTO -> target.getPayments().stream().noneMatch(alquiler -> alquiler.getPaymentId() == paymentDTO.getPaymentId()))
				.forEach(paymentDTO -> target.addPayment(new Payment(
						paymentDTO.getPaymentId(),
						paymentDTO.getAmount(),
						paymentDTO.getFecha(),
						new Staff(paymentDTO.getEmpleado()),
						target)));
			return target;
	}
}
	
	
