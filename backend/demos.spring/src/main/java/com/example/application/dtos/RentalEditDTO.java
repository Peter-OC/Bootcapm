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
	@JsonProperty("Cliente")
	private int customer;
	@JsonProperty("pelicula")
	private int inventory;
	private int empleado;//staff
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date rentalDate;
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date returnDate;	
	private List<Integer> payments;
	

	public static RentalEditDTO from(Rental source) {
		return new RentalEditDTO(
				source.getRentalId(),
				source.getCustomer().getCustomerId(),
				source.getInventory().getInventoryId(),
				source.getStaff().getStaffId(),
				source.getRentalDate(),
				source.getReturnDate(),
				null
				); 
	}
	
	public static Rental from(RentalEditDTO source) {
		return new Rental(
				source.getRentalId(),
				source.getRentalDate(),
				source.getReturnDate(),
				null,
				new Customer(source.getCustomer()),
				new Inventory(source.getInventory()),
				new Staff(source.getEmpleado())				
				);
	}
	
	public Rental update(Rental target) {
		target.setRentalDate(rentalDate);
		target.setReturnDate(returnDate);
		target.setPayments(null);
		if(target.getCustomer().getCustomerId() != customer)
			target.setCustomer(new Customer(customer));
		if(target.getInventory().getInventoryId() != inventory)
			target.setInventory(new Inventory(inventory));
		if(target.getStaff().getStaffId() != empleado)
			target.setStaff(new Staff(empleado));
		
		
	//ENTITY(1,3,5)
	//DTO(1,7)
			// Borra los actores que sobran
			var delAlquiladas = target.getPayments().stream()
					.filter(item -> !payments.contains(item.getPaymentId()))
					.toList();
			delAlquiladas.forEach(item -> target.removePayment(item));
//			// Añade los actores que falta
			payments.stream()
				.filter(idPaymentDTO -> !target.getPayments().stream().anyMatch(filmActor -> filmActor.getPaymentId() == idPaymentDTO))
				.forEach(idPaymentDTO -> target.addPayment(new Payment(idPaymentDTO)));

//	// Borra las categorias que sobran
//			var delCategorias = target.getFilmCategories().stream()
//					.filter(item -> !categorias.contains(item.getCategory().getCategoryId()))
//					.toList();
//			delCategorias.forEach(item -> target.removeFilmCategory(item));
////			// Añade las categorias que falta
//			categorias.stream()
//				.filter(idCategoriaDTO -> target.getFilmCategories().stream().noneMatch(filmCategory -> filmCategory.getCategory().getCategoryId() == idCategoriaDTO))
//				.forEach(idCategoriaDTO -> target.addFilmCategory(new Category(idCategoriaDTO)));
			return target;
	}
}
	
	
