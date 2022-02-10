package Tareas;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MainCalculadora {

	public static void main(String[] args) {

		ficheros();
	}

	public static void decode(String expresion) {
		if (expresion == null || "".equals(expresion) || !Character.isDigit(expresion.charAt(0)))
			throw new java.lang.IllegalArgumentException("No es una expresi�n valida");
		String operando = "";
		for (int i = 0; i < expresion.length(); i++) {
			char ch = expresion.charAt(i);
			if (Character.isDigit(ch)) {
				operando += ch;
			} else if (ch == ',') {
				if (operando.indexOf(ch) == -1) {
					operando += ch;
				} else {
					// throw new Exception("Ya existe separador decimal.");
				}
			} else if ("+-*/%=".indexOf(ch) >= 0) {
				if (operando.endsWith(",")) {
					operando += "0";
				}
				System.out.println(operando + " " + ch);
				if (ch == '=') {
					break;
				}
				operando = "";
			} else if (ch != ' ') {
//				throw new Exception("Carácter no valido.");
			}
		}
	}

	public static double calcula(String expresion) throws CalculadoraException, Exception {
		if (expresion == null || "".equals(expresion) || !Character.isDigit(expresion.charAt(0)))
			throw new java.lang.IllegalArgumentException("No es una expresi�n valida");
		String operando = "";
		Calculadora calculadora = new Calculadora();
		for (int i = 0; i < expresion.length(); i++) {
			char ch = expresion.charAt(i);
			if (Character.isDigit(ch)) {
				operando += ch;
			} else if (ch == ',') {
				if (operando.indexOf(ch) == -1) {
					operando += ch;
				} else {
					// throw new Exception("Ya existe separador decimal.");
				}
			} else if ("+-*/%=".indexOf(ch) >= 0) {
				if (operando.endsWith(",")) {
					operando += "0";
				}
				calculadora.calcula(operando, ch);
				System.out.println(operando + "\t" + ch + "\t" + calculadora.getAcumulado());
				if (ch == '=') {
					break;
				}
				operando = "";
			} else if (ch != ' ') {
//				throw new Exception("Car�cter no valido.");
			}
		}
		System.out.println(calculadora.getAcumulado());
		return calculadora.getAcumulado();
	}

	public static List<Calculadora.Operacion> decodeToList(String expresion) {
		if (expresion == null || "".equals(expresion) || !Character.isDigit(expresion.charAt(0)))
			throw new java.lang.IllegalArgumentException("No es una expresi�n valida");
		List<Calculadora.Operacion> resulatado = new ArrayList<>();
		String operando = "";
		for (int i = 0; i < expresion.length(); i++) {
			char ch = expresion.charAt(i);
			if (Character.isDigit(ch)) {
				operando += ch;
			} else if (ch == ',') {
				if (operando.indexOf(ch) == -1) {
					operando += ch;
				} else {
					// throw new Exception("Ya existe separador decimal.");
				}
			} else if ("+-*/%=".indexOf(ch) >= 0) {
				if (operando.endsWith(",")) {
					operando += "0";
				}
				resulatado.add(new Calculadora.Operacion(operando, ch));
				if (ch == '=') {
					break;
				}
				operando = "";
			} else if (ch != ' ') {
//				throw new Exception("Car�cter no valido.");
			}
		}
		return resulatado;

	}

	public static void calculaList(String expresion) throws CalculadoraException, Exception {
		try {
			var operaciones = decodeToList(expresion);
			for (Calculadora.Operacion operacion : operaciones) {
				System.out.println(operacion.getOperando() + " " + operacion.getOperador());
			}
			System.out.println((new Calculadora()).calcula(operaciones));
		} catch (CalculadoraException e) {
			e.printStackTrace();
		}
	}

	public static void ficheros() {
		String fileIn = "C:\\Users\\polmosca\\Desktop\\entrada.txt";
		String fileOut = "C:\\Users\\polmosca\\Desktop\\Salida.txt";
		try {
			Path entada = Paths.get(fileIn), salida = Paths.get(fileOut);
			if(Files.exists(salida))
				Files.delete(salida);
			Files.createFile(salida);

			List<String> lines;
			lines = Files.readAllLines(entada, StandardCharsets.UTF_8);
			for (String line : lines) {
				try {
					System.out.println("Entrada: " + line);
					System.out.println("Salida:");
					var operaciones = decodeToList(line);
					for (Calculadora.Operacion operacion : operaciones) {
						System.out.print("\t" + operacion.getOperando() + "\n" + (operacion.getOperador() == '=' ? "--------------------------\n" : operacion.getOperador()));
						Files.writeString(salida, operacion.getOperando() + "\n" + (operacion.getOperador() == '=' ? "--------------------------\n" : operacion.getOperador()), StandardOpenOption.APPEND);
					}
					System.out.println("\t" + (new Calculadora()).calcula(operaciones));
					Files.writeString(salida, (new Calculadora()).calcula(operaciones) + "\n\n", StandardOpenOption.APPEND);
				} catch (CalculadoraException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}