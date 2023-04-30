package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Puits {
	public final static int LARGEUR_PAR_DEFAUT = 5;
	public final static int PROFONDEUR_PAR_DEFAUT = 15;
	public final static String MODIFICATION_PIECE_ACTUELLE = "PieceActuelle";
	public final static String MODIFICATION_PIECE_SUIVANTE = "PieceSuivante";
	
	private int largeur;
	private int profondeur;
	private Piece pieceActuelle;
	private Piece pieceSuivante;
	private PropertyChangeSupport pcs;
	private Tas tas;
	private boolean collisionBool;
	private boolean isGameOver;
	
	public Puits(){
		this.largeur = LARGEUR_PAR_DEFAUT;
		this.profondeur = PROFONDEUR_PAR_DEFAUT;
		pcs = new PropertyChangeSupport(this);
		this.tas = new Tas(this);
	}
	
	public Puits(int largeur, int profondeur) {
		if (largeur < 5 || largeur > 15) {
            throw new IllegalArgumentException("La largeur doit être comprise entre 5 et 15.");
        }
        if (profondeur < 15 || profondeur > 25) {
            throw new IllegalArgumentException("La profondeur doit être comprise entre 15 et 25.");
        }
		this.largeur = largeur;
		this.profondeur = profondeur;
		pcs = new PropertyChangeSupport(this);
		this.tas = new Tas(this);
	}
	
	public Puits(int largeur, int profondeur, int nbElements, int nbLignes) {
		if (largeur < 5 || largeur > 15) {
            throw new IllegalArgumentException("La largeur doit être comprise entre 5 et 15.");
        }
        if (profondeur < 15 || profondeur > 25) {
            throw new IllegalArgumentException("La profondeur doit être comprise entre 15 et 25.");
        }
        this.largeur = largeur;
		this.profondeur = profondeur;
		pcs = new PropertyChangeSupport(this);
		this.tas = new Tas(this, nbElements, nbLignes);
	}
	
	public Piece getPieceActuelle() {
		return this.pieceActuelle;
	}
	
	public Piece getPieceSuivante() {
		return this.pieceSuivante;
	}
	
	public int getLargeur() {
		return this.largeur;
	}
	
	public int getProfondeur() {
		return this.profondeur;
	}
	
	public boolean getIsGameOver() {
		return this.isGameOver;
	}

	
	public void setPieceSuivante(Piece piece) {
		if (pieceSuivante != null) {
			Piece ancien  = pieceActuelle;
			pieceActuelle = pieceSuivante;
			pieceActuelle.setPosition(largeur/2, -4);
			pcs.firePropertyChange(MODIFICATION_PIECE_ACTUELLE, ancien,pieceActuelle);
		}
		Piece ancien = this.pieceSuivante;
		pieceSuivante = piece;	
		pieceSuivante.setPuits(this);
		pcs.firePropertyChange(MODIFICATION_PIECE_SUIVANTE,ancien,pieceSuivante );
	}
	
	public void setProfondeur(int profondeur) {
		if (profondeur < 15 || profondeur > 25) {
            throw new IllegalArgumentException("La profondeur doit être comprise entre 15 et 25.");
        }
		this.profondeur = profondeur;
	}
	
	public void setLargeur(int largeur) {
		if (largeur < 5 || largeur > 15) {
            throw new IllegalArgumentException("La largeur doit être comprise entre 5 et 15.");
        }
		this.largeur = largeur;
	}
	
	public Tas getTas() {
		return this.tas;
	}
	
	public void setTas(Tas tas) {
		this.tas = tas;
	}
	
	public boolean isAppelUsineDePiece() {
		return collisionBool;
	}
	
	public String toString() {
		String str = "Puits : Dimension " + getLargeur() + " x "+getProfondeur() + "\n";
		if(pieceActuelle == null) {
			str += "Piece Actuelle : <aucune>\n";
		}
		else {
			str += "Piece Actuelle : " + pieceActuelle.toString();
		}
		if(pieceSuivante == null) {
			str += "Piece Suivante : <aucune>\n";
		}
		else {
			str += "Piece Suivante : " + pieceSuivante.toString();
		}
		return str;
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}
	
	private void gererCollision() {
		try {
			tas.ajouterElements(pieceActuelle);
		} catch (BloxException e) {
			// TODO Auto-generated catch block
			if(e.getType() == BloxException.BLOX_GAME_OVER) {
				isGameOver = true;
			}
		}
		setPieceSuivante(UsineDePiece.genererPiece());
		collisionBool = true;
	}
	

	public void gravite() {
		try {
			this.pieceActuelle.deplacerDe(0, 1);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (BloxException e) {
			if (e.getType() == BloxException.BLOX_COLLISION) {
				collisionBool = false;
				gererCollision(); 
			}

			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}

}
