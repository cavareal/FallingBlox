package fr.eseo.e3.poo.projet.blox;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Tas;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.PanneauInformation;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;


public class FallingBloxVersion1 {
	
	private FallingBloxVersion1() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nbElements = 0; 
		int nbLignes = 0;
		Puits puits = new Puits(10,20);
		
		if (args.length == 0) {
            nbElements = 0;
        }
		else if (args.length == 1) {
            nbElements = Integer.parseInt(args[0]);
            new Tas(puits, nbElements);
        }
		else if (args.length == 2) {
			nbElements = Integer.parseInt(args[0]);
            nbLignes = Integer.parseInt(args[1]);
            new Tas(puits, nbElements, nbLignes);
        }
		VuePuits vuePuits = new VuePuits(puits);
        PanneauInformation panneauInfo = new PanneauInformation(puits);
        puits.setPieceSuivante(UsineDePiece.genererPiece());
		puits.setPieceSuivante(UsineDePiece.genererPiece());
		
		JFrame frame = new JFrame("Falling Blox");
		frame.getContentPane().add(vuePuits);
		frame.add(vuePuits, BorderLayout.CENTER);
        frame.add(panneauInfo, BorderLayout.EAST);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // la fenêtre se ferme 
		frame.setVisible(true);
	}

}

