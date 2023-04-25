package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

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
	
    @Test
    public void testSupprimerElement() {
    	Puits puits = new Puits(10, 15);
        Tas tas = new Tas(puits);
        tas.supprimerElement(1, 2);
        Assertions.assertNull(tas.getElements()[2][1]);
    }
	
    @Test
    public void testAjouterElements() {
    	Puits puits = new Puits(10, 15);
        Tas tas = new Tas(puits);
        Piece piece = new OPiece(new Coordonnees(5,5),Couleur.ROUGE);
        List<Element> liste = new ArrayList<>(piece.getElements());
        tas.ajouterElements(piece);
        for (Element el : liste) {
            int x = el.getCoordonnees().getAbscisse();
            int y = el.getCoordonnees().getOrdonnee();
            assertEquals(el, tas.getElements()[y][x]);
        }
    }
    
    
}
