package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DemarrageAffichage extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	public DemarrageAffichage(JeuAffichage jeuAffichage) {
		// CHARGEMENT IMAGE
	    ImageIcon imageIcon = new ImageIcon("Falling_Blox.jpg");
	    JLabel label = new JLabel(imageIcon);
	    
	    //MODIF DE LA FENETRE ACTUELLE 
	    this.setTitle("Demarrage du jeu");
	    getContentPane().add(label, BorderLayout.CENTER);	
	    setSize(500,500);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    // AJOUT D UN BOUTON 
	    JButton boutonJouer = new JButton ("Jouer");
	    boutonJouer.setFont(new Font("Arial",Font.BOLD,20));
	    boutonJouer.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            jeuAffichage.setVisible(true); // affiche la fenêtre de jeu
	            dispose(); // ferme la fenêtre de démarrage
	        }
	    });
	    getContentPane().add(boutonJouer, BorderLayout.SOUTH);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stu
		dispose();
	}
	
}
