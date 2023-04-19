package fr.eseo.e3.poo.projet.blox.modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;


public class Tas {
	
	private Element[][] elements;
	private Puits puits;
	private int nombre = 0;
	
	public Tas(Puits puits) {
		this.puits = puits;
		this.elements = new Element[puits.getProfondeur()][puits.getLargeur()];
		construireTas(0,0, new Random());
	}
	
	public Tas(Puits puits, int nbElements) {
		this.puits = puits;
		int nbLignes = (nbElements / puits.getLargeur())+1;
		this.elements = new Element[puits.getProfondeur()][puits.getLargeur()];
		construireTas(nbElements, nbLignes, new Random());
	}
	
	public Tas(Puits puits, int nbElements, int nbLignes) {
		this.puits = puits;
		this.elements = new  Element[puits.getProfondeur()][puits.getLargeur()];;
		construireTas(nbElements, nbLignes, new Random());
	}
	
	public Tas(Puits puits, int nbElements, int nbLignes, Random rand) {
		this.puits = puits;
		this.elements = new  Element[puits.getProfondeur()][puits.getLargeur()];;
		construireTas(nbElements, nbLignes, rand);
	}

	
	public Element[][] getElements() {
		return this.elements;
	}
	
	public void supprimerElement(int x, int y) {
        this.elements[y][x] = null;
    }

	
	public int getNombre() {
		return this.nombre;
	}

	public Puits getPuits() {
		return this.puits;
	}

	private void construireTas(int nbElements, int nbLignes, Random rand) {
		if(nbElements != 0 && nbElements>=nbLignes*puits.getLargeur()) {
			throw new IllegalArgumentException("on ne peut pas construire le tas");
		}
		else {
			nombre = nbElements;
			nbElements = 0;
			System.out.println(nbLignes);
			while (nbElements < nombre) {
				//nombreAleatoire = rand.nextInt(max - min + 1) + min
				int ordon = puits.getProfondeur()- (rand.nextInt(nbLignes) +1);
				int abscisse =rand.nextInt(this.puits.getLargeur());

				if(this.elements[ordon][abscisse] == null) {
					elements[ordon][abscisse] = new Element(abscisse, ordon,
							Couleur.values()[rand.nextInt(7)]);
					nbElements ++;
				}
			}
		}
	}
	
	public void ajouterElements(Piece piece) {
		List<Element> liste = piece.getElements();
		
		for(Element el : liste) {
			int x = el.getCoordonnees().getAbscisse();
			int y = el.getCoordonnees().getOrdonnee();
			elements[y][x] = el;
		}
	}
	
	
}
