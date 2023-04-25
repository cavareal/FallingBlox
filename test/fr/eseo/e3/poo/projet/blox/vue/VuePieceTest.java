package fr.eseo.e3.poo.projet.blox.vue;

import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class VuePieceTest {
	
	@Test
	public void testTeinte() {
		Color color = Color.BLUE;
		Couleur couleur = Couleur.BLEU;
		Piece piece = new OPiece(new Coordonnees(1,1), couleur);
		VuePiece vuePiece = new VuePiece(piece, 10);
		Color teinte = vuePiece.teinte(color);
		assertEquals(new Color(76, 76, 255), teinte);
	}

}
