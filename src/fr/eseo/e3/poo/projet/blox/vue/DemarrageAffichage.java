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

	public DemarrageAffichage() {
		// Chargement de l'image
	    ImageIcon imageIcon = new ImageIcon("Falling_Blox.jpg");
	    
	    // Création d'un JLabel pour afficher l'image
	    JLabel label = new JLabel(imageIcon);
	    
	    //Modification de la fenetre actuelle 
	    this.setTitle("Demarrage du jeu");
	    getContentPane().add(label, BorderLayout.CENTER);	
	    setSize(500,500);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    // Ajout d'un bouton pour jouer 
	    JButton boutonJouer = new JButton ("Jouer");
	    boutonJouer.setFont(new Font("Arial",Font.BOLD,20));
	    boutonJouer.addActionListener(this);
	    getContentPane().add(boutonJouer, BorderLayout.SOUTH);
	    
	    setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		dispose();
	}
	
}
