package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceDeplacement extends MouseAdapter implements MouseMotionListener, 
															  MouseListener, 
															  MouseWheelListener {
	private VuePuits vuePuits; 
	private Puits puits; 
	private boolean bEvt = true;
	private int numColonne;
	
	public PieceDeplacement(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		this.puits = this.vuePuits.getPuits();
	}
	
	public void mouseMoved(MouseEvent event){
		int newNumC = 0; 
		if(puits.getPieceActuelle() != null) {
			if(bEvt) {
				numColonne = (int) Math.floor(event.getX()/vuePuits.getTaille());
				bEvt = false;
			}else {
				newNumC = (int) Math.floor(event.getX()/vuePuits.getTaille()); 
				if(newNumC == -1) {
					this.numColonne = newNumC;
				}
				else if (newNumC > numColonne) {
					try {
						if(puits.getPieceActuelle() !=null) {
							puits.getPieceActuelle().deplacerDe(1, 0);
						}
					}catch (IllegalArgumentException exception) {
						// Ne rien faire si le déplacement lève une exception
					}
				}else if (newNumC < numColonne) {
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
		this.vuePuits.repaint();
	}
	
	public void mouseDragged(MouseEvent event) {
		
	}
	
	public void mouseEntered(MouseEvent evt){
		this.numColonne = (int) Math.floor(evt.getX()/vuePuits.getTaille()); 
	}
	/*
	public void mouseExited(MouseEvent evt) {
		
	}
	
	public void mousePressed(MouseEvent evt) {
		
	}
	
	public void mouseReleased(MouseEvent evt) {
		
	}
	
	public void Clicked(MouseEvent evt) {
		
	}
	*/
	public void mouseWheelMoved(MouseWheelEvent event) {
		if(puits.getPieceActuelle() != null && event.getWheelRotation() > 0) {
			try {
				puits.getPieceActuelle().deplacerDe(0, 1);
			} catch (IllegalArgumentException exception) {
				// Ne rien faire si le déplacement lève une exception
			}
			vuePuits.repaint();
		}
	}
}
