package fr.eseo.e3.poo.projet.blox;


import java.awt.Image;

import javax.swing.*;

public class Exemple extends JFrame{


	  public static void main(String argv[]) {
		  
		  JFrame frame = new JFrame("Ma fenêtre");
		  frame.setResizable(false);
		  
		  

	    // Chargement de l'image
	    ImageIcon imageIcon = new ImageIcon("Falling_Blox.jpg");
	    
	    // Création d'un JLabel pour afficher l'image
	    JLabel label = new JLabel(imageIcon);
	    frame.getContentPane().add(label);	
	    frame.pack();
	    frame.setSize(500,500);
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);

	  }
	
}



