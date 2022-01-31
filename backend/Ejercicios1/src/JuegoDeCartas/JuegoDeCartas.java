package JuegoDeCartas;

public class JuegoDeCartas {

	public static void main(String[] args) {
		
//		//Crear nueva baraja
        Baraja b = new Baraja();
//        
//        //Mostramos las cartas disponibles
//        System.out.println("Hay "+b.naipesRestantes()+" cartas disponibles");
//      
//       //Saco 5 cartas
//        b.repartirNaipes(5);
//        
//        //Mostramos las cartas disponibles 
//        System.out.println("Hay "+b.naipesRestantes()+" cartas disponibles");
//       
//        System.out.println("Cartas sacadas de momento");
//        
        b.naipesEnMazo();
       
        b.barajar();
       
      
	}

}
