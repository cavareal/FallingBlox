package fr.eseo.e3.poo.projet.blox.modele.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class OPieceTest {

	@Test
	public void constructorToStringTest() {
		Couleur couleur = Couleur.JAUNE;
		OPiece p = new OPiece(new Coordonnees(1,1), couleur);
		
		String s = "OPiece :\n" + "\t" + "("+1+", "+1+") - "+ couleur  + "\n" 
								+ "\t" + "("+2+", "+1+") - "+ couleur  + "\n" 
    							+ "\t" + "("+1+", "+0+") - "+ couleur  + "\n" 
    							+ "\t" + "("+2+", "+0+") - "+ couleur  + "\n"; 
		assertEquals(s, p.toString(), "pb");
	}
	
	@Test
	public void constructorToStringTest2() {
		Couleur couleur = Couleur.JAUNE;
		OPiece p = new OPiece(new Coordonnees(1,-1), couleur);
		
		String s = "OPiece :\n" + "\t" + "("+1+", "+-1+") - "+ couleur  + "\n" 
								+ "\t" + "("+2+", "+-1+") - "+ couleur  + "\n" 
    							+ "\t" + "("+1+", "+-2+") - "+ couleur  + "\n" 
    							+ "\t" + "("+2+", "+-2+") - "+ couleur  + "\n"; 
		assertEquals(s, p.toString(), "string non conforme");
	}
	@Test
	public void getElementsTest() {
		Couleur couleur = Couleur.ROUGE;
		OPiece p = new OPiece(new Coordonnees(1,1), couleur);
		List<Element> list = new ArrayList<>();
		
		list.add(new Element(1, 1));
		list.add(new Element(2, 1));
		list.add(new Element(1, 0));
		list.add(new Element(2, 0));
		
		assertEquals(list, p.getElements(), "listes différentes");
		assertEquals(4, p.getElements().size(),"4 éléments");
	}
	
	
	@Test
	public void tournerTest() {
		Couleur couleur = Couleur.ROUGE;
		OPiece p = new OPiece(new Coordonnees(1,1), couleur);
		List<Element> list = new ArrayList<>();
		
		list.add(new Element(1, 1));
		list.add(new Element(2, 1));
		list.add(new Element(1, 0));
		list.add(new Element(2, 0));
		
		for(int i = 0; i < list.size(); i++) {
			assertEquals(list.get(i), p.getElements().get(i), "ne correspond pas");
		}
	}
	
	
	
	
}