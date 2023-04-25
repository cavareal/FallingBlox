package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;


public class UsineDePieceTest {

    @Test
    public void testGenererPieceAleatoire() {
        // On teste si une pièce aléatoire est générée correctement
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_PIECE);
        for(int i = 0; i <50; i++) {
	        Piece p = UsineDePiece.genererPiece();
	        assertNotNull(p);
	        assertTrue(p instanceof Piece);
        }
    }
    
 
    @Test
    public void testGenererPieceComplete() {
        // On teste si une pièce complète aléatoire est générée correctement
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_COMPLET);
        for(int i = 0; i <50; i++) {
	        Piece p = UsineDePiece.genererPiece();
	        assertNotNull(p);
	        assertTrue(p instanceof Piece);
        }
    }
    
    @Test
    public void testGenererPieceCyclic() {
        // On teste si une pièce cyclique est générée correctement
        UsineDePiece.setMode(UsineDePiece.CYCLIC);
        Piece p = UsineDePiece.genererPiece();
        
        Piece op = new OPiece(new Coordonnees(2,3), Couleur.ROUGE);
        
        assertNotNull(p);
        assertEquals(op, p, "pb d'instance");
    }
    
    @Test
    public void testGenererPieceCyclique() {
        UsineDePiece.setMode(UsineDePiece.CYCLIC);
        Piece piece1 = UsineDePiece.genererPiece();
        Piece piece2 = UsineDePiece.genererPiece();
        assertNotEquals(piece1, piece2);
    }

}
