package Capgemini;

import java.util.Random;

/**
 * Juego de adivinar numeros
 * @author Javier
 * @version 1.0
 */
public class JuegoDelNumero implements Juego<String> {
	private int numeroBuscado;
    private int intentos;
    private boolean encontrado;
    private String resultado;

    public JuegoDelNumero() {
		inicializar();
	}
    
    /**
     * Inicializa el juego
     */
	@Override
	public void inicializar() {
     numeroBuscado = (new Random()).nextInt(100) + 1;
     intentos = 0;
     encontrado = false;
     resultado = "Pendiente de empezar";
	}
	
	@Override
	public void jugada(String movimiento) throws JuegoException {
		try {
			jugada(Integer.parseInt(movimiento));
		} catch (NumberFormatException e) {
			throw new JuegoException("No es un n�mero.", e);
		}
	}

	public void jugada(int numeroIntroducido) throws JuegoException {
		if(getFinalizado()) {
			throw new JuegoException("El juego a finalizado");
		}
        intentos += 1;
        if (numeroBuscado == numeroIntroducido) {
            encontrado = true;
            resultado = "Bieeen!!! Acertaste.";
        } else if (intentos >= 10) {
        	resultado = "Upsss! Se acabaron los intentos, el n�mero era el " + numeroBuscado;
        } else if (numeroBuscado > numeroIntroducido) {
        	resultado = "Mi n�mero es mayor.";
        } else {
        	resultado = "Mi n�mero es menor.";
        }
	}

	/**
	 * Cadena con el mensaje de la ultima jugada
	 */
	@Override
	public String getResultado() {
		return resultado;
	}

	@Override
	public boolean getFinalizado() {
		return intentos >= 10 || encontrado;
	}

	@Override
	public int getJugada() {
		return intentos;
	}

}