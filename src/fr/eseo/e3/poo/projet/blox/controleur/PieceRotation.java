package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
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
			try {
				puits.getPieceActuelle().tourner(true);
			} catch (BloxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.vuePuits.repaint();
		}
		else if (SwingUtilities.isLeftMouseButton(event)) {
			try {
				puits.getPieceActuelle().tourner(false);
			} catch (BloxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.vuePuits.repaint();
		}
	}
}
