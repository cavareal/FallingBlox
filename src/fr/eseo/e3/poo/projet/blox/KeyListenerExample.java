package fr.eseo.e3.poo.projet.blox;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class KeyListenerExample implements KeyListener
{	
	

	@Override
	public void keyReleased(KeyEvent e)	{}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		// on fait rien 
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//int newX = puits.getPieceActuelle().getPosition().getAbscisse();
		//int newY = puits.getPieceActuelle().getPosition().getOrdonnee();
		int codeTouche = e.getKeyCode();
	        switch (codeTouche) {
	            case KeyEvent.VK_LEFT:
	                // déplacer la pièce vers la gauche
	            	System.out.println("flèche gauche");
	            	//newX -= 1;
	                break;
	            case KeyEvent.VK_RIGHT:
	            	System.out.println("flèche droite");
	                 // déplacer la pièce vers la droite
	            	//newX += 1;
	                break;
	            case KeyEvent.VK_DOWN:
	            	System.out.println("flèche du bas");
	                 // déplacer la pièce vers le bas
	            	//newY += 1;
	                break;
	            default:
	                // ne rien faire pour les autres touches
	            	System.out.println("autre touche");
	                break;
	        }
	        // redessiner la pièce avec les nouvelles coordonnées

	        //vuePuits.repaint();
	}
	public static void main(String[] args)
	{
		JFrame f = new JFrame("Puits");
		Puits puits = new Puits(10, 20);
		VuePuits vuePuits = new VuePuits(puits);
		
		puits.setPieceSuivante(UsineDePiece.genererPiece());
		puits.setPieceSuivante(UsineDePiece.genererPiece());
		puits.getPieceActuelle().setPosition(5, 5);
		//Setting the Frame and Labels
		f.setLayout(new FlowLayout());
		f.setSize(500, 500);
		JLabel l = new JLabel();
		l.setText("This is a demonstration");
		f.add(l);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		//Creating and adding the key listener
		KeyListenerExample k = new KeyListenerExample();
		f.addKeyListener(k);
	}
}




