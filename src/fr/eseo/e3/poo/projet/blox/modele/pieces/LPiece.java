package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class LPiece extends Piece{
	
	public LPiece(Coordonnees coor, Couleur couleur) {
		super(coor, couleur);
	}
	
	protected void setElements(Coordonnees coor, Couleur couleur) {
		getElements().clear();
		getElements().add(new Element(coor, couleur)); // élement de ref
	    getElements().add(new Element(coor.getAbscisse()+1, coor.getOrdonnee(), couleur )); //élement à droite
		getElements().add(new Element(coor.getAbscisse(), coor.getOrdonnee()-1, couleur )); //élement en dessous
	    getElements().add(new Element(coor.getAbscisse(), coor.getOrdonnee()-2, couleur )); // élément en dessous +1
	}
}
