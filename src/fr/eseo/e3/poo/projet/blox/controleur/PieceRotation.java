package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceRotation extends MouseAdapter{
	
	private VuePuits vuePuits;
	private Puits puits;
	
	public PieceRotation(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		this.puits = vuePuits.getPuits();
	}
	
	public void mouseClicked(MouseEvent event) {
		if(SwingUtilities.isRightMouseButton(event)) {
			puits.getPieceActuelle().tourner(true);
			this.vuePuits.repaint();
		}
		else if (SwingUtilities.isLeftMouseButton(event)) {
			puits.getPieceActuelle().tourner(false);
			this.vuePuits.repaint();
		}
	}
}
