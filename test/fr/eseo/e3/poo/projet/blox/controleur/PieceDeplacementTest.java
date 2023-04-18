package fr.eseo.e3.poo.projet.blox.controleur;


import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceDeplacementTest {

	public static void main (String [] args) {
		SwingUtilities.invokeLater(new Runnable () {
			public void run() {
				new PieceDeplacementTest ();
			}
		});
	}
	
	public PieceDeplacementTest() {
		testDeplacement();
	}
	
	private void testDeplacement() {
		JFrame frame = new JFrame("Puits");
		Puits puits = new Puits(10, 20);
		VuePuits vuePuits = new VuePuits(puits);
		puits.setPieceSuivante(UsineDePiece.genererPiece());
		puits.setPieceSuivante(UsineDePiece.genererPiece());
		puits.getPieceActuelle().setPosition(5, 5);
		System.out.println(puits.getPieceActuelle());
		System.out.println(puits.getPieceSuivante());
		
//		PieceDeplacement pD = new PieceDeplacement(vuePuits);
//		
//		vuePuits.addMouseMotionListener(pD);
//		vuePuits.addMouseListener(pD);
//		vuePuits.addMouseWheelListener(pD);
		
		
		//pD.mouseMoved());
        
		frame.getContentPane().add(vuePuits);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // la fenêtre se ferme 
		frame.setVisible(true);
		
		
	}

}
