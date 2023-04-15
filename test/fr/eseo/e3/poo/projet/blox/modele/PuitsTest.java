package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;

public class PuitsTest {

	@Test
	public void constructorTest() {
		Puits p = new Puits();

		assertEquals(5, p.getLargeur(), "largeur par défaut attendue");
		assertEquals(15,p.getProfondeur(), "profondeur par défaut attenue");
	}
	
	@Test
	public void constructor2Test() {
		Puits p = new Puits(10,20);
		
		assertEquals(10, p.getLargeur(), "largeur 10 attendue");
		assertEquals(20,p.getProfondeur(), "profondeur 20 attenue");
	}
	
	@Test
	public void constructor3Test() {
		Puits p = new Puits(10,20);
		
		assertEquals(10, p.getLargeur(), "largeur 10 attendue");
		assertThrows(IllegalArgumentException.class,() -> {
            p.setProfondeur(10);} , "l'exception n'est pas levée");
	}
	
	@Test
    void testSetProfondeur() {
        Puits puits = new Puits(10, 20);
        
        // Vérifie que l'exception est bien lancée avec une profondeur trop petite
        assertThrows(IllegalArgumentException.class, () -> {
            puits.setProfondeur(10);
        });
        
        // Vérifie que l'exception est bien lancée avec une profondeur trop grande
        assertThrows(IllegalArgumentException.class, () -> {
            puits.setProfondeur(30);
        });
        
        // Vérifie que la profondeur est correctement fixée dans les limites autorisées
        puits.setProfondeur(20);
        assertEquals(20, puits.getProfondeur());
    }
	
	@Test
	public void testSetLargeur() {
Puits puits = new Puits(10, 20);
        
        // Vérifie que l'exception est bien lancée avec une largeur trop petite
        assertThrows(IllegalArgumentException.class, () -> {
            puits.setLargeur(3);
        });
        
        // Vérifie que l'exception est bien lancée avec une largeur trop grande
        assertThrows(IllegalArgumentException.class, () -> {
            puits.setLargeur(20);
        });
        
        // Vérifie que la largeur est correctement fixée dans les limites autorisées
        puits.setLargeur(15);
        assertEquals(15, puits.getLargeur());
	}
    
    @Test
    public void testSetPieceSuivante() {
    	Puits puits = new Puits(10, 20);
    	
    	OPiece op = new OPiece(new Coordonnees(10,5), Couleur.JAUNE);
    	
    	puits.setPieceSuivante(op);
    	assertEquals(op, puits.getPieceSuivante());
    	
    	IPiece ip = new IPiece(new Coordonnees(4,2), Couleur.VERT);
    	puits.setPieceSuivante(ip);
    	assertEquals(op, puits.getPieceActuelle());
    	assertEquals(ip, puits.getPieceSuivante());
    	assertEquals(new Coordonnees(4,2), ip.getPosition(),"les positions ne correspondent pas");
    	assertEquals(new Coordonnees(5,-4), op.getPosition(),"les positions ne correspondent pas");
    }
    
    @Test
    public void testToString() {
    	Puits puits = new Puits(10, 20);
    	
    	String str ="Puits : Dimension 10 x 20\n"
    			+ "Piece Actuelle : <aucune>\n"
    			+ "Piece Suivante : IPiece :\n"
    			+ "\t" + "(7, 8) - ROUGE\n"
    			+ "\t" + "(7, 9) - ROUGE\n"
    			+ "\t" + "(7, 7) - ROUGE\n"
    			+ "\t" + "(7, 6) - ROUGE\n";
    	
    	IPiece ip = new IPiece(new Coordonnees(7,8), Couleur.ROUGE);
    	puits.setPieceSuivante(ip);
    	assertEquals(str, puits.toString(), "mauvaise string");
    }

    @Test
    public void testToString2() {
    	Puits puits = new Puits(10, 20);
    	
    	String str ="Puits : Dimension 10 x 20\n"
    			+ "Piece Actuelle : IPiece :\n"
    			+ "\t" + "(5, -4) - ROUGE\n"
    			+ "\t" + "(5, -3) - ROUGE\n"
    			+ "\t" + "(5, -5) - ROUGE\n"
    			+ "\t" + "(5, -6) - ROUGE\n"
    			+ "Piece Suivante : IPiece :\n"
    			+ "\t" + "(5, -4) - ROUGE\n"
    			+ "\t" + "(5, -3) - ROUGE\n"
    			+ "\t" + "(5, -5) - ROUGE\n"
    			+ "\t" + "(5, -6) - ROUGE\n";
    	
    	IPiece ip = new IPiece(new Coordonnees(10,8), Couleur.ROUGE);
    	puits.setPieceSuivante(ip);
    	puits.setPieceSuivante(ip);
    	assertEquals(str, puits.toString(), "mauvaise string");
    }
    

}
