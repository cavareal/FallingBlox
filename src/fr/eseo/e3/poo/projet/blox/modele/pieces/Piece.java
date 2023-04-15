package fr.eseo.e3.poo.projet.blox.modele.pieces;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

public abstract class Piece {
	
	private List<Element> elements;
	private Puits puits;
	
	public Piece(Coordonnees coor, Couleur couleur) {
		this.elements = new ArrayList<>();
		this.setElements(coor, couleur);
	}
	
	protected abstract void setElements(Coordonnees coor, Couleur couleur); //signature
	
	public List<Element> getElements(){
		return this.elements;
	}
	
	/*
	public void setPosition(int abscisse, int ordonnee) {
        int decalageX = abscisse - this.elements.get(0).getCoordonnees().getAbscisse();
        int decalageY = ordonnee - this.elements.get(0).getCoordonnees().getOrdonnee();
        for (Element element : elements) {
            int newAbs = element.getCoordonnees().getAbscisse() + decalageX;
            int newOrd = element.getCoordonnees().getOrdonnee() + decalageY;
            element.setCoordonnees(new Coordonnees(newAbs, newOrd));
        }
    }*/
	
	
	
	public void setPosition(int abscisse, int ordonnee) {
		setElements( new Coordonnees(abscisse, ordonnee), elements.get(0).getCouleur());
	}
	
	public void setPuits(Puits puits) {
		this.puits = puits;
	}
	
	public Puits getPuits() {
		return puits;
	}
	
	public Coordonnees getPosition() {
		return elements.get(0).getCoordonnees();
	}
	
	public void deplacerDe(int x, int y) throws IllegalArgumentException{
		if (y < 0 || x>1 || y>1) {
            throw new IllegalArgumentException("Le déplacement doit horizontal avec un y>0 et une seule case");
        }
		else {
			setPosition(elements.get(0).getCoordonnees().getAbscisse()+x,
					elements.get(0).getCoordonnees().getOrdonnee() + y );
		}
	}
	
	public void tourner(boolean sensHoraire) {
		
		double angle = (sensHoraire)? Math.PI/2 : -Math.PI/2;
		
		// ETAPE 1 : translation de l'élément de ref vers l'origine : 
		Coordonnees coor = this.getPosition(); 
		this.setPosition(0, 0);
		
		//ETAPE 2 :  rotation des éléments autour de l'origine
		 for (int i = 0; i<elements.size(); i++) {
	            if (elements != elements.get(0)) {
	                double x = elements.get(i).getCoordonnees().getAbscisse();
	                double y = elements.get(i).getCoordonnees().getOrdonnee();
	                double newX = x * Math.cos(angle) - y * Math.sin(angle);
	                double newY = x * Math.sin(angle) + y * Math.cos(angle);
	                elements.get(i).setCoordonnees(new Coordonnees((int)newX,(int)newY));
	              //ETAPE 3 : on retranslate vers la position d'origine
	                elements.get(i).deplacerDe(coor.getAbscisse(), coor.getOrdonnee());
	            }
	        }
	}
	
	
	@Override 
	public String toString() {
		String str = getClass().getSimpleName() + " :\n";
		for(int i =0; i<elements.size(); i++) {
			str += "\t" + elements.get(i).toString() + "\n" ;
		}
		return str;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((elements == null) ? 0 : elements.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piece other = (Piece) obj;
		if (elements == null) {
			if (other.elements != null)
				return false;
		} else if (!elements.equals(other.elements))
			return false;
		return true;
	}
	
	
	
	
}
