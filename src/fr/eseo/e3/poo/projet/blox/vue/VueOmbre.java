package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class VueOmbre extends VuePiece {
	
	private Puits puits; 
	private int taille;
	
	public VueOmbre(Piece piece, Puits puits, int taille) {
		super(piece, taille);
	    this.puits = puits;
	    this.taille= taille;
	}

	public void afficherOmbre(Graphics2D g2D) {
		List<Element> elements = getPiece().getElements();
	    Color couleur = shadow(elements.get(0).getCouleur().getCouleurPourAffichage());
	    g2D.setColor(couleur);
	    
	    // Trouver la position la plus basse pour chaque colonne de la pièce
	    int[] positionsPlusBasses = new int[getPiece().getLargeur()];


	    for (int i = 0; i < positionsPlusBasses.length; i++) {
	        positionsPlusBasses[i] = puits.getProfondeur();
	    }
	    for (Element element : elements) {
	        int x = element.getCoordonnees().getAbscisse();
	        int y = element.getCoordonnees().getOrdonnee();
	        if (y < positionsPlusBasses[x - getPiece().getPosition().getAbscisse()]) {
	            positionsPlusBasses[x - getPiece().getPosition().getAbscisse()] = y;
	        }
	    }
	    
	    // Dessiner la pièce avec une teinte plus claire à la position la plus basse de chaque colonne
	    for (int i = 0; i < positionsPlusBasses.length; i++) {
	        int x = getPiece().getPosition().getAbscisse() + i;
	        int y = positionsPlusBasses[i];
	        g2D.fill3DRect(x * taille, y * taille, taille, taille, true);
	    }
	}
	    
}
