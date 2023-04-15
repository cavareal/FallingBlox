package fr.eseo.e3.poo.projet.blox.vue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.beans.PropertyChangeEvent;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;



public class VuePuitsAffichageTest {
	
	public static void main (String [] args) {
		SwingUtilities.invokeLater(new Runnable () {
			@Override
			public void run() {
				new VuePuitsAffichageTest ();
			}
		});
	}
	
	public VuePuitsAffichageTest() {
		testConstructeurPuits();
		testConstructeurPuitsTaille();
	}
	
	private void testConstructeurPuits() {
		Puits puits = new Puits(10, 20);
		VuePuits vuePuits = new VuePuits(puits);
		puits.setPieceSuivante(UsineDePiece.genererPiece());
		puits.setPieceSuivante(UsineDePiece.genererPiece());
		JFrame frame = new JFrame("Puits");
		
		// Méthode avec setVuePiece();
		//VuePiece vuepiece = new VuePiece(puits.getPieceSuivante(),20);
		//vuePuits.setVuePiece(vuepiece);
		
		//Méthode avec PropertyChange
		PropertyChangeEvent evt = new PropertyChangeEvent(vuePuits, vuePuits.getPuits().getPieceSuivante().getClass().getSimpleName(), 
				null, vuePuits.getPuits().getPieceSuivante());
		vuePuits.propertyChange(evt);
		frame.getContentPane().add(vuePuits);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // la fenêtre se ferme 
		frame.setVisible(true);
		
		/*assertEquals(vuePuits.getPreferredSize(), new Dimension(puits.getLargeur() * VuePuits.TAILLE_PAR_DEFAUT, 
				puits.getProfondeur()*VuePuits.TAILLE_PAR_DEFAUT));
		assertEquals(vuePuits.getBackground(), Color.WHITE);*/
	}
	
	private void testConstructeurPuitsTaille() {
		/*
		Puits puits = new Puits(15, 25);
		puits.setPieceSuivante(UsineDePiece.genererPiece());
		//puits.setPieceSuivante(UsineDePiece.genererPiece());
		int taille = 20;
		VuePuits vuePuits = new VuePuits(puits, taille);
		JFrame frame = new JFrame("Puits et taille");
		//VuePiece vuepiece = new VuePiece(puits.getPieceSuivante(),taille);
		//vuePuits.setVuePiece(vuepiece);
		PropertyChangeEvent evt = new PropertyChangeEvent(vuePuits, vuePuits.getPuits().getPieceSuivante().getClass().getSimpleName(), 
				null, vuePuits.getPuits().getPieceSuivante());
		vuePuits.propertyChange(evt);
		frame.getContentPane().add(vuePuits);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // la fenêtre se ferme 
		frame.setVisible(true);
		
		assertEquals(vuePuits.getPreferredSize(), new Dimension(puits.getLargeur() * taille, puits.getProfondeur()*taille));
		assertEquals(vuePuits.getBackground(), Color.WHITE);
		*/
		Puits puits = new Puits(15, 25);
		VuePuits vuePuits = new VuePuits(puits);
		//puits.setPieceSuivante(UsineDePiece.genererPiece());
		//puits.setPieceSuivante(UsineDePiece.genererPiece());
		IPiece ip = new IPiece(new Coordonnees(5,5), Couleur.BLEU);
		ip.tourner(true);
		puits.setPieceSuivante(ip);
		JFrame frame = new JFrame("Puits et taille");
		//VuePiece vuepiece = new VuePiece(puits.getPieceSuivante(),20);
		//vuePuits.setVuePiece(vuepiece);
		PropertyChangeEvent evt = new PropertyChangeEvent(vuePuits, vuePuits.getPuits().getPieceSuivante().getClass().getSimpleName(), 
				null, vuePuits.getPuits().getPieceSuivante());
		vuePuits.propertyChange(evt);
		frame.getContentPane().add(vuePuits);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // la fenêtre se ferme 
		frame.setVisible(true);
		
	}


}
