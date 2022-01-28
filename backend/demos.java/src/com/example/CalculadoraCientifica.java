package com.example;

public class CalculadoraCientifica extends Calculadora{
	
	public CalculadoraCientifica() {
		this(0);
	}
	public CalculadoraCientifica(int i) {
		super(i);
	}
	public double dividir(double a, double b) {
		return a / b;
	}
	
//  @Override
	public int suma(int a, int b) {
		return a - b;
	}
	
	private int contador = 0;
	
	private void inicializa(int contador) {
		this.contador = contador;
		//otro.registra(this)
	}

}
