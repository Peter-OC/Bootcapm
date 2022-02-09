package Ajedrez;

public class Movimiento {
	
	Posicion posInicial;
	Posicion posFinal;
	
	
	public Movimiento(Posicion posInicial, Posicion posFinal) throws JuegoException{
		
		if (posInicial.equals(posFinal)) {
			throw new JuegoException("La pieza no se ha movido");
		}

		this.posInicial = posInicial;
		this.posFinal = posFinal;
	}

	public Posicion getPosInicial() {
		return posInicial;
	}

	public void setPosInicial(Posicion posInicial) {
		this.posInicial = posInicial;
	}

	public Posicion getPosFinal() {
		return posFinal;
	}

	public void setPosFinal(Posicion posFinal) {
		this.posFinal = posFinal;
	}
	
	public static boolean EsVertical() {
		return false;
		
	}
	
	public static boolean EsHorizontal() {
		return false;
		
	}
	
	public static boolean EsDiagonal() {
		return false;
		
	}
	
	public static int SaltoVertical() {
		return (Integer) null;
		
	}
	
	public static int SaltoHorizontal() {
		return (Integer) null;
		
	}
	
	public static int DeltaFila() {
		return (Integer) null;
		
	}
	
	public static int DeltaColumna() {
		return (Integer) null;
		
	}
	
}
