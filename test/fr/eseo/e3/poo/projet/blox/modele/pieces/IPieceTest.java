package fr.eseo.e3.poo.projet.blox.modele.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class IPieceTest {

	@Test
	public void constructorToStringTest() {
		Couleur couleur = Couleur.JAUNE;
		IPiece p = new IPiece(new Coordonnees(1,1), couleur);
		
		String s = "IPiece :\n" + "\t" + "("+1+", "+1+") - "+ couleur  + "\n" 
								+ "\t" + "("+1+", "+2+") - "+ couleur  + "\n" 
    							+ "\t" + "("+1+", "+0 +") - "+ couleur  + "\n" 
    							+ "\t" + "("+1+", "+-1 +") - "+ couleur  + "\n"; 
		assertEquals(s, p.toString(), "pb");
	}
	
	@Test
	public void constructorToStringTest2() {
		Couleur couleur = Couleur.JAUNE;
		IPiece p = new IPiece(new Coordonnees(1,-1), couleur);
		
		String s = "IPiece :\n" + "\t" + "("+1+", "+-1+") - "+ couleur  + "\n" 
								+ "\t" + "("+1+", "+0+") - "+ couleur  + "\n" 
    							+ "\t" + "("+1+", "+-2+") - "+ couleur  + "\n" 
    							+ "\t" + "("+1+", "+-3+") - "+ couleur  + "\n"; 
		assertEquals(s, p.toString(), "string non conforme");
	}
	@Test
	public void getElementsTest() {
		Couleur couleur = Couleur.ROUGE;
		IPiece p = new IPiece(new Coordonnees(1,1), couleur);
		List<Element> list = new ArrayList<>();
		
		list.add(new Element(1, 1));
		list.add(new Element(1, 2));
		list.add(new Element(1, 0));
		list.add(new Element(1, -1));
		
		assertEquals(list, p.getElements(), "listes différentes");
		assertEquals(4, p.getElements().size(),"4 éléments");
	}
	
	@Test 
	public void deplacerDeTest() {
		IPiece ip = new IPiece(new Coordonnees(1,1), Couleur.ROUGE);
		
		List<Element> list = new ArrayList<>();
		list.add(new Element(1, 1));
		list.add(new Element(1, 2));
		list.add(new Element(1, 0));
		list.add(new Element(1, -1));
		
		ip.deplacerDe(1, 0);
		
		List<Element> listFinale = new ArrayList<>();
		listFinale.add(new Element(2, 1));
		listFinale.add(new Element(2, 2));
		listFinale.add(new Element(2, 0));
		listFinale.add(new Element(2, -1));
		
		for(int i = 0; i < list.size(); i++) {
			assertEquals(listFinale.get(i), ip.getElements().get(i), "ne correspond pas");
		}
	}
		
		@Test 
		public void tournerTest() {
			IPiece ip = new IPiece(new Coordonnees(1,1), Couleur.ROUGE);
			
			List<Element> list = new ArrayList<>();
			list.add(new Element(1, 1));
			list.add(new Element(1, 2));
			list.add(new Element(1, 0));
			list.add(new Element(1, -1));
			
			ip.tourner(true);
			
			List<Element> listFinale = new ArrayList<>();
			listFinale.add(new Element(1, 1));
			listFinale.add(new Element(0, 1));
			listFinale.add(new Element(2, 1));
			listFinale.add(new Element(3, 1));
			
			for(int i = 0; i < list.size(); i++) {
				assertEquals(listFinale.get(i), ip.getElements().get(i), "ne correspond pas");
			}
		}
		
}

