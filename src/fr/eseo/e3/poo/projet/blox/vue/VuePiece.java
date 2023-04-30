package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class VuePiece {
	
	public static final double  MULTIPLIER_TEINTE = 0.3;
	
	private final int taille;
	private final Piece piece;
	
	public VuePiece(Piece piece, int taille) {
		this.piece = piece;
		this.taille = taille;
	}
	
	public Piece getPiece() {
		return this.piece;
	}
	
	public Color teinte(Color couleur) {
		int r = couleur.getRed();
		int g = couleur.getGreen();
		int b = couleur.getBlue();
		int alpha = couleur.getAlpha(); // opacity
		/* From 2D group:
		* 1. black.brighter() should return grey
		* 2. applying brighter to blue will always return blue, brighter
		* 3. non pure color (non zero rgb) will eventually return white
		*/
		if ( r == 0 && g == 0 && b == 0) {
		return new Color(r, g, b, alpha);
		}
		r = (int) (r + (255 - r) * MULTIPLIER_TEINTE);
        g = (int) (g + (255 - g) * MULTIPLIER_TEINTE);
        b = (int) (b + (255 - b) * MULTIPLIER_TEINTE);
		return new Color(r,g,b);
	}
	
	public Color shadow(Color couleur) {
		int r = couleur.getRed();
		int g = couleur.getGreen();
		int b = couleur.getBlue();
		
		return new Color(r,g,b, 128); 
		// alpha compris entre 0 et 255 avec 0 très transparent et 255 complètement opaque (ici opacité divisé par 2)
	
	}
	
	public void afficherPiece(Graphics2D g2D) {
		List<Element> elements = piece.getElements();
				
        Color couleur = piece.getElements().get(0).getCouleur().getCouleurPourAffichage();
        Color couleurLight = teinte(couleur);
        
        for (int i = 0; i < elements.size(); i++) {
        	
            if (i == 0) {
                g2D.setColor(couleurLight);
            } else {
                g2D.setColor(couleur);
            }
            
            g2D.fill3DRect(elements.get(i).getCoordonnees().getAbscisse() * taille, 
            		elements.get(i).getCoordonnees().getOrdonnee() * taille, taille, taille, true);
        }
        
    }
	
	

}
