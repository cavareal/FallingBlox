package fr.eseo.e3.poo.projet.blox;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.eseo.e3.poo.projet.blox.modele.Observateur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Tas;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.GameOverAffichage;
import fr.eseo.e3.poo.projet.blox.vue.PanneauInformation;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class FallingBloxVersion2 implements Observateur{
	
	private static JLabel scoreLabel;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nbElements = 0; 
		int nbLignes = 0;
		Puits puits = new Puits(10,20);
		FallingBloxVersion2 instance = new FallingBloxVersion2();

		
		if (args.length == 0) {
            nbElements = 0;
            puits.getTas().ajouterObservateur(instance);
        }
		else if (args.length == 1) {
            nbElements = Integer.parseInt(args[0]);
            new Tas(puits, nbElements);
            puits.getTas().ajouterObservateur(instance);
        }
		else if (args.length == 2) {
			nbElements = Integer.parseInt(args[0]);
            nbLignes = Integer.parseInt(args[1]);
            new Tas(puits, nbElements, nbLignes);
            puits.getTas().ajouterObservateur(instance);
        }
		
		VuePuits vuePuits = new VuePuits(puits);
        PanneauInformation panneauInfo = new PanneauInformation(puits);
        
        puits.setPieceSuivante(UsineDePiece.genererPiece());
		puits.setPieceSuivante(UsineDePiece.genererPiece());
		
		// AFFICHAGE 

		JFrame frame = new JFrame("Falling Blox");
		
		DemarrageAffichage demarrageAffichage = new DemarrageAffichage();
		JLabel label = new JLabel("Score :");
		scoreLabel = new JLabel(String.valueOf(panneauInfo.getScore()));
		frame.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(panneauInfo);
        panel.add(label);
        panel.add(scoreLabel);
		frame.getContentPane().add(vuePuits);
		frame.add(vuePuits, BorderLayout.CENTER);
        frame.add(panel,BorderLayout.EAST);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // la fenêtre se ferme 
		frame.setVisible(true);
		
		GameOverAffichage goa = new GameOverAffichage(puits);
		
	}
	
	public void actualiser(int score) {
        scoreLabel.setText(String.valueOf(score)); // mise à jour de la valeur du JLabel du score
    }
	

}


