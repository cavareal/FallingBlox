package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import fr.eseo.e3.poo.projet.blox.controleur.PieceDeplacement;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class VuePuits extends JPanel implements PropertyChangeListener{
	
	private static final long serialVersionUID = 1L;
	public static final int TAILLE_PAR_DEFAUT = 20;
	
	private Puits puits;
	private int taille;
	private VuePiece vuePiece;
	private PieceDeplacement pieceDeplacement;

	public VuePuits(Puits puits){
		this.puits = puits;
		taille = TAILLE_PAR_DEFAUT;
		this.vuePiece = null;
		setPreferredSize(new Dimension(this.puits.getLargeur() * this.taille, this.puits.getProfondeur()*this.taille));
		setBackground(Color.WHITE);
		puits.addPropertyChangeListener(this);
		this.pieceDeplacement = new PieceDeplacement(this);
		this.addMouseMotionListener(pieceDeplacement);
		this.addMouseListener(pieceDeplacement);
		this.addMouseWheelListener(pieceDeplacement);
	}
	
	public VuePuits(Puits puits, int taille){
		this.puits = puits;
		this.taille = taille;
		this.vuePiece = null;
		setPreferredSize(new Dimension(this.puits.getLargeur() * this.taille, this.puits.getProfondeur()*this.taille));
		setBackground(Color.WHITE);
		puits.addPropertyChangeListener(this);
		this.pieceDeplacement = new PieceDeplacement(this);
		this.addMouseMotionListener(pieceDeplacement);
		this.addMouseListener(pieceDeplacement);
		this.addMouseWheelListener(pieceDeplacement);
	}

	public Puits getPuits() {
		return puits;
	}

	public void setPuits(Puits puits) {
		this.puits = puits;
		setPreferredSize(new Dimension(this.puits.getLargeur() * this.taille, this.puits.getProfondeur()*this.taille));
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
		setPreferredSize(new Dimension(this.puits.getLargeur() * this.taille, this.puits.getProfondeur()*this.taille));
		
	}
	
	public VuePiece getVuePiece() {
		return vuePiece;
	}

	private void setVuePiece(VuePiece vuePiece) {
		this.vuePiece = vuePiece;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		/* appel vers super pour remplir le fond du JPanel */
		/*Le paramètre g est copie en utilisant la méthode copie()
		* puis converti en instance de Graphics2D grâce à
		* un transtypage (cast) explicite.
		*/
		Graphics2D g2D = (Graphics2D)g.create();
		/* Nous utiliserons l'instance de Graphics2D*/
		
		// Afficher une grille de couleur gris clair
		
	    g2D.setColor(Color.LIGHT_GRAY);
	    
	    for (int i = 0; i < puits.getProfondeur(); i++) {
	        for (int j = 0; j < puits.getLargeur(); j++) {
	            g2D.drawRect(j * this.taille, i * this.taille, this.taille, this.taille);
	        }
	    }
	    if(vuePiece != null) {
	    	vuePiece.afficherPiece(g2D);
	    }
		/*Puis nous liberons la memoire*/
		g2D.dispose();
	}
	
	public void propertyChange(PropertyChangeEvent event) {

		if (event.getPropertyName().equals(Puits.MODIFICATION_PIECE_ACTUELLE)) {
            setVuePiece(new VuePiece((Piece) event.getNewValue(), taille));
			//setVuePiece(this.vuePiece);
            this.repaint();
        } else if(event.getPropertyName().equals(Puits.MODIFICATION_PIECE_SUIVANTE)) {
            setVuePiece(new VuePiece((Piece)event.getNewValue(), taille));
        	//setVuePiece(this.vuePiece);
        	this.repaint();
        }
		
	}
	
	
}
