package fr.eseo.e3.poo.projet.blox.vue;


import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fr.eseo.e3.poo.projet.blox.modele.Puits;

public class GameOverAffichage extends JPanel implements PropertyChangeListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Puits puits;
	
	public GameOverAffichage(Puits puits) {
		this.puits = puits;
		puits.addPropertyChangeListener(this);
		super.setPreferredSize(new Dimension(70, 70));
	}
	
	public static void ecranFinDePartie() {
		JFrame frame = new JFrame("Game Over");
        JOptionPane.showMessageDialog(frame, "Game Over!"); // affichage d'une fenetre game over
        
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(puits.getIsGameOver()) {
			ecranFinDePartie();
			
			System.exit(0); // arret du programme 
		}
		
	}
}
