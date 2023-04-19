package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Tas;

public class VueTas {
	
	public static final double MULTIPLIER_NUANCE = 0.3;
	
	private final VuePuits vuePuits;
	private final Tas tas;
	
	public VueTas(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		this.tas = this.vuePuits.getPuits().getTas();
	}
	
	public VuePuits getVuePuits() {
		return this.vuePuits;
	}
	
	public Tas getTas() {
		return this.tas;
	}
	
	public Color nuance(Color couleur) {
		int r = couleur.getRed();
		int g = couleur.getGreen();
		int b = couleur.getBlue();
		int alpha = couleur.getAlpha(); // opacity
		
		if ( r == 0 && g == 0 && b == 0) {
		return new Color(r, g, b, alpha);
		}
		r = (int) (r * (1 - MULTIPLIER_NUANCE));
        g = (int) (g * (1 - MULTIPLIER_NUANCE));
        b = (int) (b * (1 - MULTIPLIER_NUANCE));
		return new Color(r,g,b);
	}
	
	public void afficher(Graphics2D g2D) {
		
		Element[][] elements = tas.getElements();
		int taille = vuePuits.getTaille();
		
		for (int i = 0; i < elements.length; i++){
			for(int j = 0; j<elements[0].length;j++) {
				if (elements[i][j] != null) {
					g2D.setColor(nuance((elements[i][j].getCouleur().getCouleurPourAffichage())));
					g2D.fill3DRect(elements[i][j].getCoordonnees().getAbscisse() * taille, 
							elements[i][j].getCoordonnees().getOrdonnee() * taille, taille, taille, true);
				}
			}
		}
	}
	
}
