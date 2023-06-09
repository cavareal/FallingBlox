package fr.eseo.e3.poo.projet.blox.controleur;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceDeplacementAffichageTest {
	
	public static void main (String [] args) {
		SwingUtilities.invokeLater(new Runnable () {
			public void run() {
				try {
				new PieceDeplacementAffichageTest ();
				}
				catch(BloxException e) {
					
				}
			}
		});
	}
	
	public PieceDeplacementAffichageTest() throws BloxException  {
		testDeplacement();
	}
	
	private void testDeplacement() throws BloxException {
		JFrame frame = new JFrame("Puits");
		Puits puits = new Puits(10, 20);
		VuePuits vuePuits = new VuePuits(puits);
		
		puits.setPieceSuivante(UsineDePiece.genererPiece());
		puits.setPieceSuivante(UsineDePiece.genererPiece());
		puits.getPieceActuelle().setPosition(5, 5);

		frame.getContentPane().add(vuePuits);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // la fenêtre se ferme 
		frame.setVisible(true);
		
		
	}
}
