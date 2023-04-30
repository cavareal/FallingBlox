package fr.eseo.e3.poo.projet.blox;


import fr.eseo.e3.poo.projet.blox.modele.Observateur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Tas;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.DemarrageAffichage;
import fr.eseo.e3.poo.projet.blox.vue.JeuAffichage;
import fr.eseo.e3.poo.projet.blox.vue.GameOverAffichage;
import fr.eseo.e3.poo.projet.blox.vue.PanneauInformation;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class FallingBloxVersion2 implements Observateur{

	
	public static void main(String[] args) {
	    int nbElements = 0;
	    int nbLignes = 0;
	    Puits puits = new Puits(10,20);
	    FallingBloxVersion2 instance = new FallingBloxVersion2();

	    if (args.length == 0) {
	        nbElements = 0;
	        puits.getTas().ajouterObservateur(instance);
	    } else if (args.length == 1) {
	        nbElements = Integer.parseInt(args[0]);
	        new Tas(puits, nbElements);
	        puits.getTas().ajouterObservateur(instance);
	    } else if (args.length == 2) {
	        nbElements = Integer.parseInt(args[0]);
	        nbLignes = Integer.parseInt(args[1]);
	        new Tas(puits, nbElements, nbLignes);
	        puits.getTas().ajouterObservateur(instance);
	    }

	    VuePuits vuePuits = new VuePuits(puits);
	    PanneauInformation panneauInfo = new PanneauInformation(puits);
	    puits.setPieceSuivante(UsineDePiece.genererPiece());
	    puits.setPieceSuivante(UsineDePiece.genererPiece());
	    
	    JeuAffichage jeuAffichage = new JeuAffichage(vuePuits, panneauInfo);
	    new DemarrageAffichage(jeuAffichage);
	    

	    new GameOverAffichage(puits);
	}
	
	public void actualiser(int score) {
		JeuAffichage.majScoreLabel(score); // mise à jour de la valeur du JLabel du score
    }
	
}


