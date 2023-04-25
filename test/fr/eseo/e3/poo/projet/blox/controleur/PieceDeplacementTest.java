package fr.eseo.e3.poo.projet.blox.controleur;

import java.beans.PropertyChangeEvent;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;


public class PieceDeplacementTest {

    private VuePuits vuePuits;
    private Puits puits;
    private PieceDeplacement pieceDeplacement;
    private Piece piece;
    private PropertyChangeEvent evt ;

    @BeforeEach
    public void setUp() {
        vuePuits = new VuePuits(new Puits());
        puits = vuePuits.getPuits();
        puits.setPieceSuivante(UsineDePiece.genererPiece());
		puits.setPieceSuivante(UsineDePiece.genererPiece());
        pieceDeplacement = new PieceDeplacement(vuePuits);
        evt = new PropertyChangeEvent(vuePuits, vuePuits.getPuits().getPieceSuivante().getClass().getSimpleName(),
        		null, vuePuits.getPuits().getPieceSuivante());
        vuePuits.propertyChange(evt);
    }
    
    @Test
    public void testMouseMoved() {
        // Case where the newNumC > numColonne

    }
    /*
    @Test
    void testNewNumCSUPnumColonne() {
        int oldX = (int) Math.floor(evt.getX()/vuePuits.getTaille());
        pieceDeplacement.newNumCSUPnumColonne();
        assertEquals(oldX + 1, piece.getX());
    }
    
    @Test
    void testNewNumINFnumColonne() {
        int oldX = piece.getX();
        pieceDeplacement.newNumINFnumColonne();
        assertEquals(oldX - 1, piece.getX());
    }*/
}
