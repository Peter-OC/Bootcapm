package Ajedrez;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import Bootcamp.Calculadora2;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PosicionTest {
	
	Posicion posi;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		posi = new Posicion(0, 0);
	}

	@Test
	void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	void testPosicionIntInt() {
		var juego = new Juego();

		try {
			juego.Inicializar();
			juego.Juagada("A2A4");
			juego.Juagada("A7A5");
		} catch (JuegoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testPosicionCharChar() {
		fail("Not yet implemented");
	}

	@Test
	void testGetLaFila() {
		fail("Not yet implemented");
	}

	@Test
	void testGetLaColumna() {
		fail("Not yet implemented");
	}

	@Test
	void testEqualsObject() {
		fail("Not yet implemented");
	}

}
