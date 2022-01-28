package com.example;

import java.awt.LinearGradientPaint;

public class Factura {
	public static enum Estado{ PENDIENTE, PAGADA, CANCELADA }
	
	public class Linea {
		private String conceptoString;
		private int cantidad;
		private double precio;
		
		public Linea(String concepto, int cantidad, double precio) {
			super();
			this.conceptoString = concepto;
			setCantidad(cantidad);
			this.precio = precio;
		}

		public String getConcepto() {
			return conceptoString;
		}

		public void setConcepto(String conceptoString) {
			this.conceptoString = conceptoString;
		}

		public int getCantidad() {
			return cantidad;
		}

		public void setCantidad(int cantidad) {
			if(this.cantidad == cantidad) return;
			if(this.cantidad < 1) throw new IllegalArgumentException("La cantidad debe ser mayor que 0. ");
			this.cantidad = cantidad;
		}

		public double getPrecio() {
			return precio;
		}

		public void setPrecio(double precio) {
			this.precio = precio;
		}
		
		public double getTotal() {
			return cantidad * precio;
		}
		
		public double getNumeroFactura() {
			return numero;
		}
		
		
	}
	private int numero;
	private String direccion;
	private Estado estado;
	private Linea[] lineas;

	public Factura(int numero) {
		super();
		this.numero = numero;
	}
	
	public double getNumero() {
		return numero;
	}
	
	public void addLinea(Linea linea) {
		
	}
	
	public void addLinea(String concepto, int cantidad, double precio) {
		addLinea(new Linea(concepto, cantidad, precio));
	}

}
