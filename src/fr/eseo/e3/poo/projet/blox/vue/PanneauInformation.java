package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class PanneauInformation extends JPanel implements PropertyChangeListener {


	private static final long serialVersionUID = 1L;
	private Puits puits;
	private VuePiece vuePiece;
	
	public PanneauInformation(Puits puits) {
		this.puits = puits;
		puits.addPropertyChangeListener(this);
		super.setPreferredSize(new Dimension(70, 70));
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D)g;
		g2D.setColor(Color.LIGHT_GRAY);
		
		 if(vuePiece != null) {
		    	vuePiece.afficherPiece(g2D);
		    }
		g2D.dispose();
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		if (evt.getPropertyName().equals(Puits.MODIFICATION_PIECE_SUIVANTE)) {
			Piece newPiece = (Piece) evt.getNewValue();
			if(newPiece != null) {
				this.vuePiece = new VuePiece(newPiece,10);
			}
            this.repaint();
        } 
	}
	
	
}
