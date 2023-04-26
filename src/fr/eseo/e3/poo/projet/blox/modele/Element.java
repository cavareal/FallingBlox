package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Objects;

public class Element {
	
	private Coordonnees coordonnees;
	private Couleur couleur;
	//private Puits puits;

	public Element(Coordonnees coor){
		this.coordonnees = coor;
		this.couleur = Couleur.values()[0]; //Values() crée un tableau de l'enum dans l'ordre de déclaration
	}
	
	public Element(int abscisse, int ordonnee){
		setCoordonnees(new Coordonnees(abscisse, ordonnee));
		this.couleur = Couleur.values()[0];
	}
	
	public Element(Coordonnees coor, Couleur couleur){
		this.coordonnees = coor;
		this.couleur = couleur;
	}
	
	public Element(int abscisse, int ordonnee, Couleur couleur){
		setCoordonnees(new Coordonnees(abscisse, ordonnee));
		this.couleur = couleur;
	}
	
	public Coordonnees getCoordonnees() {
		return this.coordonnees;
	}
	
	public Couleur getCouleur() {
		return this.couleur;
	}
	
	
	public void setCoordonnees(Coordonnees coor) {
		this.coordonnees = coor; 
	}
	
	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}
	
	public String toString() {
		return "(" + coordonnees.getAbscisse() + ", " + coordonnees.getOrdonnee() + ") - " + getCouleur();
	}
	
	public void deplacerDe(int x, int y) throws IllegalArgumentException{
		setCoordonnees(new Coordonnees(this.getCoordonnees().getAbscisse()+x,
					this.getCoordonnees().getOrdonnee() + y ));
	}
	/*
	public void deplacerDeCollision(int x, int y, int profondeur) throws BloxException{
		int newX = this.getCoordonnees().getAbscisse();
		int newY = this.getCoordonnees().getOrdonnee();
		if(newY >= profondeur) {
			throw new BloxException("Collision détectée !", BloxException.BLOX_TAS_COLLISION);
		}
		else {
			deplacerDe(newX, newY);
		}
	}*/
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordonnees == null) ? 0 : coordonnees.hashCode());
		result = prime * result + ((couleur == null) ? 0 : couleur.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Element other = (Element) obj;
	    return Objects.equals(coordonnees, other.coordonnees) && couleur == other.couleur;
	}
	
	
}
