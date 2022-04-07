package Bootcamp.JuegoDelNumero;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class JuegoDelNumeroTest {
	
	JuegoDelNumero jdn; //Se necesita una instancia de la clase

	@BeforeEach
	void setUp() throws Exception {
		jdn = new JuegoDelNumero();
		jdn.numeroBuscado = 50; // Indicamos un valor prebisible
	}
	
	@Test
	void test_Constructor() {
		assertNotNull(new JuegoDelNumero()); //Assert para que el constructor no sea null
	}

//	@Test
//	void testJuegoDelNumero() {
//		fail("Not yet implemented");
//	}

	@Test
	void testInicializar() {
		jdn.numeroBuscado = -1; //Metemos un valor que no sea valido para comprobar si hay error
		jdn.inicializar();//llamos al metodo de la clase
		
		//Empezamos con UnaryOperator bateriaOperator Deprecated asserts
		assertAll("Inicializar", //Comprobar que ha inicializado bien
				() -> assertEquals("Pendiente de empezar", jdn.getResultado()),
				() -> assertEquals(0, jdn.getJugada()),
				() -> assertTrue(0 < jdn.numeroBuscado && jdn.numeroBuscado <= 100, "rango entre 1 y 100")//para ver que todo inizializa bien
				); 
	}
	//Añadimos la clase jugadas
	@Nested // Aviso al JUnit que es un atributo de instancia para poder llegar al Juego
	class jugadas {
		
		@Test
		void test_es_mayor() throws JuegoException {
			jdn.jugada(51);//si el número es 50 le asigno un valor límite para ver si es menor el resultado
			assertAll("Jugada",
				() -> assertEquals("Mi número es menor.", jdn.getResultado()),
				() -> assertEquals(1, jdn.getJugada()));			
		}
		
		@Test
		void test_es_menor() throws JuegoException {
			jdn.jugada(49);//si el número es 50 le asigno un valor límite para ver si es mayor el resultado
			assertAll("Jugada",
				() -> assertEquals("Mi número es mayor.", jdn.getResultado()),
				() -> assertEquals(1, jdn.getJugada()));			
		}
		
		@Test
		void test_es_igual() throws JuegoException {
			jdn.jugada(50);//si el número es 50 le asigno un valor igual al resultado
			assertAll("Jugada",
				() -> assertEquals("Bieeen!!! Acertaste.", jdn.getResultado()),
				() -> assertEquals(1, jdn.getJugada()));			
		}
		
		@Test
		void test_es_finalizar() throws JuegoException {
			jdn.jugada(10);
			jdn.jugada(10);
			jdn.jugada(10);
			jdn.jugada(10);
			jdn.jugada(10);
			jdn.jugada(10);
			jdn.jugada(10);
			jdn.jugada(10);
			jdn.jugada(10);
			jdn.jugada(10);
			assertAll("Jugada",
					() -> assertEquals(true, jdn.getFinalizado()),
					() -> assertEquals("Upsss! Se acabaron los intentos, el número era el 50", jdn.getResultado()),
					() -> assertEquals(10, jdn.getJugada()));			
		}
		 
		// Es la exceptions pasamos un intento con el valor exacto para que entre en finalizado
		// assertTrue para poner finalizar en true
		// assertThrows con la clase exception para lanzer la exception y lanzamos otro intento pera
		// que salte la exception
		
		@Test()
		void test_es_exception() throws JuegoException {
			jdn.jugada(50);
			assertTrue(jdn.getFinalizado());
			assertThrows(JuegoException.class,
					() -> jdn.jugada(50)); // la línea 98 y 99 es un lamda que resume el try catch de la exception
		}
		
	}

}
