package fr.eseo.e3.poo.projet.blox.modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class Tas {
	
	private Element[][] elements;
	private Puits puits;
	private int nombre = 0;
	private boolean isSupprimerLigne;
	private int ligneSupprimee;
	private int score = 0;
    private List<Observateur> observateurs = new ArrayList<>();
	
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
		this.elements = new  Element[puits.getProfondeur()][puits.getLargeur()];
		construireTas(nbElements, nbLignes, new Random());
	}
	
	public Tas(Puits puits, int nbElements, int nbLignes, Random rand) {
		this.puits = puits;
		this.elements = new  Element[puits.getProfondeur()][puits.getLargeur()];
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
	

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
		notifierObservateurs();
	}
	

	private void construireTas(int nbElements, int nbLignes, Random rand) {
		if(nbElements != 0 && nbElements>=nbLignes*puits.getLargeur()) {
			throw new IllegalArgumentException("on ne peut pas construire le tas");
		}
		else {
			nombre = nbElements;
			nbElements = 0;
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
	
	public void ajouterElements(Piece piece) throws BloxException {
		List<Element> liste = piece.getElements();
		
		for(Element el : liste) {
			int x = el.getCoordonnees().getAbscisse();
			int y = el.getCoordonnees().getOrdonnee();
			if(y < 0) {
				throw new BloxException("GAME OVER", BloxException.BLOX_GAME_OVER);
			}
				elements[y][x] = el;
		}
	}
	
	public int lignePleine() {
		for(int j = 0; j < puits.getProfondeur(); j++) {
			int compteur = 0;
			for (int i =0; i < puits.getLargeur(); i++) {
				if(elements[j][i] == null) break;
				compteur++;
			}
			if(compteur == puits.getLargeur()) {
				this.setScore(score += 10);
				return j;
			}
		}
		return -1;
	}
	
	public void supprimerLignes(int y) {
		if(y != -1) {
			for(int i=0; i < puits.getLargeur(); i++) {
				supprimerElement(i,y);
				isSupprimerLigne = true;
				ligneSupprimee = y;
			}
		}
	}
	
	public void tasGravite() throws BloxException{
		
		if(isSupprimerLigne) {
			for(int j = ligneSupprimee; j > 0; j--) {
				for (int i =0; i < puits.getLargeur(); i++) {
					elements[j][i]= elements[j-1][i];
					if(elements[j-1][i] != null) {
						//elements[j][i].deplacerDeCollision(0, 1, puits.getProfondeur());
						elements[j][i].setCoordonnees(new Coordonnees(i, j));
					}
				}
			}
		}
		isSupprimerLigne = false;
	}
	
    public void ajouterObservateur(Observateur observateur) {
        observateurs.add(observateur);
    }

    private void notifierObservateurs() {
        for (Observateur observateur : observateurs) {
            observateur.actualiser(score);
        }
    }


}

