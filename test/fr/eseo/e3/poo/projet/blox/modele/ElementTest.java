package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ElementTest {

	@Test
	public void constructorTest1() {
		Element e = new Element(1,1, Couleur.ROUGE );
		
		assertEquals("(1, 1) - ROUGE", e.toString(), "Mauvais constructeur");
	}
	
	
	@Test
	public void constructorTest2() {
		Element e = new Element(new Coordonnees(1,1), Couleur.VIOLET );
		
		assertEquals("(1, 1) - VIOLET", e.toString(), "Mauvais constructeur");
	}
	
	@Test 
	public void constructorTest3(){
		Element e = new Element(new Coordonnees(1,1));
		
		assertEquals("(1, 1) - ROUGE", e.toString(), "Mauvais constructeur");
	}
	
	@Test
	public void constructorTest4() {
		Element e = new Element(-3,1);
		
		assertEquals("(-3, 1) - ROUGE", e.toString(), "Mauvais constructeur");
	}
	
	@Test 
	public void constructorTest5(){
		Element e = new Element(new Coordonnees(1,1));
		
		assertEquals(new Coordonnees(1,1), e.getCoordonnees(), "Mauvais constructeur");
	}
	
	@Test
	public void deplacerDeTest() {
		Element e = new Element(new Coordonnees(1,1));
	
		e.deplacerDe(4, 5);
		Coordonnees c = new Coordonnees(5,6);
		assertEquals(c, e.getCoordonnees(),"ko");
	}
	

}