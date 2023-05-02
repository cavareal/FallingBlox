package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import fr.eseo.e3.poo.projet.blox.controleur.Gravite;
import fr.eseo.e3.poo.projet.blox.controleur.PieceDeplacement;
import fr.eseo.e3.poo.projet.blox.controleur.PieceRotation;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class VuePuits extends JPanel implements PropertyChangeListener{
	
	private static final long serialVersionUID = 1L;
	public static final int TAILLE_PAR_DEFAUT = 15; //AVANT ON AVAIT 20 => CHANGEMENT POUR LE TEST 345
	
	private Puits puits;
	private int taille;
	private VuePiece vuePiece;
	private PieceDeplacement pieceDeplacement;
	private PieceRotation pieceRotation;
	private final VueTas vueTas;
	private Gravite gravite;

	public VuePuits(Puits puits){
		setBackground(Color.WHITE);
		this.puits = puits;
		taille = TAILLE_PAR_DEFAUT;
		this.vuePiece = null;
		setPreferredSize(new Dimension(this.puits.getLargeur() * this.taille, this.puits.getProfondeur()*this.taille));
		puits.addPropertyChangeListener(this);
		this.pieceDeplacement = new PieceDeplacement(this);
		this.pieceRotation = new PieceRotation(this);
		this.addMouseMotionListener(pieceDeplacement);
		this.addMouseListener(pieceDeplacement);
		this.addMouseListener(pieceRotation);
		this.addMouseWheelListener(pieceDeplacement);
		this.addKeyListener(pieceDeplacement);
		this.vueTas = new VueTas(this);
		gravite = new Gravite(this);
		this.setFocusable(true);
		this.requestFocusInWindow();
	}
	
	public VuePuits(Puits puits, int taille){
		setBackground(Color.WHITE);
		this.puits = puits;
		this.taille = taille;
		this.vuePiece = null;
		setPreferredSize(new Dimension(this.puits.getLargeur() * this.taille, this.puits.getProfondeur()*this.taille));
		puits.addPropertyChangeListener(this);
		this.pieceDeplacement = new PieceDeplacement(this);
		this.pieceRotation = new PieceRotation(this);
		this.addMouseMotionListener(pieceDeplacement);
		this.addMouseListener(pieceDeplacement);
		this.addMouseWheelListener(pieceDeplacement);
		this.addMouseListener(pieceRotation);
		this.addKeyListener(pieceDeplacement);
		this.vueTas = new VueTas(this);
		gravite = new Gravite(this);
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
	
	public Gravite getGravite() {
		return this.gravite;
	}
	
	public VuePiece getVuePiece() {
		return vuePiece;
	}

	private void setVuePiece(VuePiece vuePiece) {
		this.vuePiece = vuePiece;
	}

	public VueTas getVueTas() {
		return this.vueTas;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D)g; //.create()

	    g2D.setColor(Color.LIGHT_GRAY);
    	for (int i = 0; i < puits.getProfondeur(); i++) {
	        for (int j = 0; j < puits.getLargeur(); j++) {
	            g2D.drawRect(j * this.taille, i * this.taille, this.taille, this.taille);
	        }
	    }

	    if(vuePiece != null) {
	    	vuePiece.afficherPiece(g2D);
	    }
	    if(vueTas != null) {
	    	vueTas.afficher(g2D);
	    	this.repaint();
	    }

	    this.repaint();
	    this.setBackground(new Color(255,255,255));
	    
		g2D.dispose();
	}
	
	public void propertyChange(PropertyChangeEvent event) {

		if (event.getPropertyName().equals(Puits.MODIFICATION_PIECE_ACTUELLE)) {
			
			setVuePiece(new VuePiece((Piece) event.getNewValue(), taille));
			//setVueOmbre(new VueOmbre((Piece) event.getNewValue(),puits, taille));
            this.repaint();
        } 
		
	}
	
	
}
