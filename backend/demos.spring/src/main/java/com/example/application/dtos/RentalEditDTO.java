package com.example.application.dtos;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;

import com.example.domains.entities.Customer;
import com.example.domains.entities.Rental;
import com.example.domains.entities.Inventory;
import com.example.domains.entities.Payment;
import com.example.domains.entities.Staff;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Value;

@Value @Data
@ApiModel(value = "Alquiler editable", description = "Version editable del alquiler.")

public class RentalEditDTO {
	@NotBlank
	@Length(max = 10)
	@JsonProperty("id")
	@ApiModelProperty(value = "Identificador del alquiler.")
	private int rentalId;
	@JsonProperty("cliente")
	@NonNull
	@Positive
	@ApiModelProperty(value = "Identificador cliente.")
	private int customer;
	@JsonProperty("pelicula")
	@NonNull
	@Positive
	@ApiModelProperty(value = "Identificador del inventario.")
	private int inventory;
	@NonNull
	@Positive
	@ApiModelProperty(value = "Identificador de empleados.")
	private int empleado;//staff
	@ApiModelProperty(value = "Fecha de alquiler")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date rentalDate;
	@ApiModelProperty(value = "Fecha de devolución")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date returnDate;	
	@ApiModelProperty(value = "Lista de identificadores de alquileres.")
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
	
	
