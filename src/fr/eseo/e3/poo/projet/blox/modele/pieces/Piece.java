package fr.eseo.e3.poo.projet.blox.modele.pieces;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

public abstract class Piece {
	
	private List<Element> elements;
	private Puits puits;
	
	
	//CONSTRUCTOR
	public Piece(Coordonnees coor, Couleur couleur) {
		this.elements = new ArrayList<>();
		this.setElements(coor, couleur);
	}
	
	//GETTERS N SETTERS
	public List<Element> getElements(){
		return this.elements;
	}
	
	
	public void setPosition(int abscisse, int ordonnee){
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
	
	public int getLargeur() {
		int minX = getElements().get(0).getCoordonnees().getAbscisse();
	    int maxX = getElements().get(0).getCoordonnees().getAbscisse();
	    
	    for (Element el : getElements()) {
	        if (el.getCoordonnees().getAbscisse() < minX) {
	            minX = el.getCoordonnees().getAbscisse();
	        }
	        if (el.getCoordonnees().getAbscisse() > maxX) {
	            maxX = el.getCoordonnees().getAbscisse();
	        }
	    }
	    return maxX - minX + 1;
	}
	
	
	//METHODES
	protected abstract void setElements(Coordonnees coor, Couleur couleur); //signature
	
	public void deplacerDe(int x, int y) throws IllegalArgumentException, BloxException{
		deplacementPb(x,y);
		if(puits != null) {
			for(Element el : this.elements) {
				int newX =  el.getCoordonnees().getAbscisse() + x;
				int newY = el.getCoordonnees().getOrdonnee() + y;
			
				if(sortiePuits(newX)) {
					 throw new BloxException("Sortie du Puits détectée !", BloxException.BLOX_SORTIE_PUITS);
				}
				if(collision(newX,newY) ) {
					throw new BloxException("Collision détectée !", BloxException.BLOX_COLLISION);
				}
			}	
		}
		deplacementOk(x,y);
	}
	
	private void deplacementPb(int x, int y) {
		if (y < 0 || Math.abs(x)>1  || y>1) {
            throw new IllegalArgumentException("Le déplacement doit horizontal avec un y>0 et une seule case");
        }
	}
	
	private void deplacementOk(int x, int y) {
		for(Element el : this.elements) {
			el.deplacerDe(x, y);
		}
	}
	
	public void tourner(boolean sensHoraire) throws BloxException {
				
		// ETAPE 1 : translation de l'élément de ref vers l'origine : 
		Coordonnees coor = this.getPosition(); 
		
		//ETAPE 2 et 3 :  rotation des éléments autour de l'origine + translation
		 for (int i = 0; i<elements.size(); i++) {
	            if (elements != elements.get(0)) {
	            	tournerPb(coor,sensHoraire, i);
	            }
	        }
		 tournerOk(coor,sensHoraire);
	}
	
	private void tournerOk(Coordonnees coor, boolean sensHoraire) {
		 for (int i = 0; i<elements.size(); i++) {
				int x = elements.get(i).getCoordonnees().getAbscisse();
	            int y = elements.get(i).getCoordonnees().getOrdonnee();
	         	int newX = (y - coor.getOrdonnee()) * (sensHoraire ? -1 : 1) + coor.getAbscisse();
	         	int newY = (x - coor.getAbscisse()) * (sensHoraire ? 1 : -1) + coor.getOrdonnee();
	         	elements.get(i).setCoordonnees(new Coordonnees((int)newX,(int)newY));
			 }
	}
	
	private void tournerPb(Coordonnees coor, boolean sensHoraire, int i) throws BloxException {
		int x = elements.get(i).getCoordonnees().getAbscisse();
        int y = elements.get(i).getCoordonnees().getOrdonnee();
    	int newX = (y - coor.getOrdonnee()) * (sensHoraire ? -1 : 1) + coor.getAbscisse();
    	int newY = (x - coor.getAbscisse()) * (sensHoraire ? 1 : -1) + coor.getOrdonnee();
    	if(puits !=null) {
        	if(sortiePuits(newX)) {
				 throw new BloxException("Sortie du Puits détectée !", BloxException.BLOX_SORTIE_PUITS);
			}
			if(collision(newX,newY) ) {
				throw new BloxException("Collision détectée !", BloxException.BLOX_COLLISION);
			}
    	}
	}
	
	public void descenteDirecte() {
		boolean pieceNonStoppee = true;
		
		while(pieceNonStoppee) {
			try {
				deplacerDe(0,1);
			} catch (IllegalArgumentException | BloxException e) {
				// TODO Auto-generated catch block
				pieceNonStoppee = false;
			}
		}
	}
	
	private boolean collision(int newX, int newY) {
		boolean bool = false;	
		if(newY >= puits.getProfondeur()) {
			bool = true;
		}
		else if( puits.getTas() != null && newY >-1 && puits.getTas().getElements()[newY][newX] != null) {
			bool = true;
		}
		return bool;
	}
	
	private boolean sortiePuits(int newX) {
		boolean bool = false;
			if (newX < 0 || newX >= puits.getLargeur()) {
				bool = true;
			}
		return bool;
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
