package JuegoDeCartas2;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BarajaFrancesa56 { 
	
	List<Naipe> naipes = new ArrayList<Naipe> ();
	 
	int[] valores = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
	String palos[] = { "corazones", "diamantes", "treboles", "picas" };

	public void nuevaBaraja() {
      
	       for(var palo : Naipe.Palos.values()) //values es la forma de devolver la posición con el enum
	           for(var valor : Naipe.Valores.values())
	           	naipes.add(new Naipe(valor,palo));
	      	       	       
	}
	
	public void barajar() {
		
		Collections.shuffle(naipes);
		
//		baraja.forEach(item-> System.out.println(item.toString()));
	}	
	
	public Naipe getCarta() {
		
		int cartaActual = 0;
	     Naipe n = null;
	     if (cartaActual >= naipes.size()) {
	        System.out.println("No hay mas cartas");
	     }else {
//	        n = naipes[cartaActual ++];	       
	  }	 
	     return n;
	}
	
	public Naipe[] repartirNaipes(int numNaipes) {
//
		if (numNaipes > naipes.size()) {
			System.out.println("Lo siento, el máximo de cartas de la baraja es 56");
		} else {

			if (naipesRestantes() < numNaipes) {
				System.out.println("No quedan tantas cartas en la baraja");
			} else {
				Naipe[] darNaipes = new Naipe[numNaipes];
//
//				for (int i = 0; i < darNaipes.length; i++) {
//					darNaipes[i] = nuevoNaipe();
//				}
//
				return darNaipes;
			}
		}
//
		return null;
//
	}
	
	public int naipesRestantes() {
		return 0;
//		return Naipe() - getCarta();
	}
//	
//	public void naipesEnMazo() {
//
//		if (naipesRestantes() == 0) {
//			System.out.println("No quedan cartas en el mazo");
//		} else {
//			for (int i = posNuevoNaipe; i < naipes.length; i++) {
//				System.out.println(naipes[i]);
//
//			}
//		}
//	}

}
