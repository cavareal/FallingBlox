package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CoordonneesTest {

	@Test
	public void constructeurTest() {
		Coordonnees coor = new Coordonnees(1,6);
		
		assertEquals(1, coor.getAbscisse(), "Abscisse 1 attendu");
		assertEquals(6, coor.getOrdonnee(), "ordonnee 6 attendu");
	}
	
	@Test
	public void toStringTest() {
		Coordonnees coor = new Coordonnees(1,6);
		
		assertEquals("(1, 6)", coor.toString(), "(1, 6) attendu");
	}
	
	

}
