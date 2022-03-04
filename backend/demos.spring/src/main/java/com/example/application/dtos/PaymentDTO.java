package com.example.application.dtos;

import com.example.domains.entities.Payment;
import com.example.domains.entities.Rental;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Value;

@Value
public class PaymentDTO {

	@JsonProperty("id")
	private int paymentlId;
	@JsonProperty("Cliente")
	private String customer;
	@JsonProperty("total")
	private float amount;

	public static PaymentDTO from(Payment source) {
		return new PaymentDTO(
				source.getPaymentId(),
				source.getCustomer().getFirstName() + " " + source.getCustomer().getLastName(),
				source.getAmount().floatValue()
				);
	}

}
