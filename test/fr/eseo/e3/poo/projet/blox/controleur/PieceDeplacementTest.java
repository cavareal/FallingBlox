package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceDeplacementTest {

	public static void main (String [] args) {
		SwingUtilities.invokeLater(new Runnable () {
			@Override
			public void run() {
				new PieceDeplacementTest ();
			}
		});
	}
	
	public PieceDeplacementTest() {
		testConstructeurPuits();
	}
	
	private void testConstructeurPuits() {
		Puits puits = new Puits(10, 20);
		VuePuits vuePuits = new VuePuits(puits);
		puits.setPieceSuivante(UsineDePiece.genererPiece());
		PieceDeplacement pd = new PieceDeplacement(vuePuits);
		JFrame frame = new JFrame("Puits");
		PropertyChangeEvent evt = new PropertyChangeEvent(vuePuits, vuePuits.getPuits().getPieceSuivante().getClass().getSimpleName(), 
				null, vuePuits.getPuits().getPieceSuivante());
		vuePuits.propertyChange(evt);
		//vuePuits.addMouseListener((MouseListener) pd);
        vuePuits.addMouseMotionListener(pd);
		frame.getContentPane().add(vuePuits);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // la fenêtre se ferme 
		frame.setVisible(true);
		
		
	}

}
