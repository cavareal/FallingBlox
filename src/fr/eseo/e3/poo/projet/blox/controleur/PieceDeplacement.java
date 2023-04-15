package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceDeplacement implements MouseMotionListener {
	
	private VuePuits vuePuits; 
	private Puits puits; 
	private boolean bEvt = true;
	private int numColonne;
	
	public PieceDeplacement(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
	}
	
	public void mouseMoved(MouseEvent event){
		int newNumC = 0; 
		if(puits.getPieceActuelle() != null) {
			if(bEvt) {
				numColonne = (int) Math.floor(event.getX()/vuePuits.getTaille());
			}else {
				newNumC = (int) Math.floor(event.getX()/vuePuits.getTaille()); 
				if (newNumC > numColonne) {
					//TODO déplacer à droite
					try {
						if(puits.getPieceActuelle() !=null) {
							puits.getPieceActuelle().deplacerDe(-1, 0);
						}
					}catch (IllegalArgumentException exception) {
						// Ne rien faire si le déplacement lève une exception
					}
					puits.getPieceActuelle().deplacerDe(1, 0);
				}else if (newNumC < numColonne) {
					// TODO déplacer à gauche
					try {
						if(puits.getPieceActuelle() != null) {
							puits.getPieceActuelle().deplacerDe(-1, 0);
						}
					}catch (IllegalArgumentException exception) {
						// Ne rien faire si le déplacement lève une exception
					}
				}
				numColonne = newNumC;
			}
		}
	}
	
	public void mouseDragged(MouseEvent event) {
		
	}
}
