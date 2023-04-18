package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TasTest {
	
	@Test
	public void testConstructorError() {
		Puits puits = new Puits();
		assertThrows(IllegalArgumentException.class, () -> {
			new Tas(puits,1000, 5);
        });
	}
	
	@Test
	public void testConstructor2() {
		Puits puits = new Puits(15,25);
		Tas tas = new Tas(puits,50);
		
		
	}
}
