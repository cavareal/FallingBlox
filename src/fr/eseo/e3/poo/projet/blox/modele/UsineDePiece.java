package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Random;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.JPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.LPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.SPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.TPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.ZPiece;


public class UsineDePiece {
	
	static Random rand = new Random(); 
	//int nombreAleatoire = rand.nextInt(max - min + 1) + min; // nombre aléatoire entre deux valeurs

	public final static int ALEATOIRE_COMPLET = 0;
	public final static int ALEATOIRE_PIECE =  1;
	public final static int CYCLIC = 2;
	
	private static int mode = ALEATOIRE_PIECE;
	
	private static int index = 0;
	
	private static Piece[] piecesCycliques = {
            new OPiece(new Coordonnees(2,3), Couleur.ROUGE),
            new IPiece(new Coordonnees(2,3), Couleur.ORANGE),
            new TPiece(new Coordonnees(2,3), Couleur.BLEU),
            new LPiece(new Coordonnees(2,3), Couleur.VERT),
            new JPiece(new Coordonnees(2,3), Couleur.JAUNE),
            new ZPiece(new Coordonnees(2,3), Couleur.CYAN),
            new SPiece(new Coordonnees(2,3), Couleur.VIOLET)
        };
	
	private UsineDePiece() {
		// Constructeur privé par défaut pour interdire la création d'une instance
    }
	
	public static void setMode(int newMode) {
		mode = newMode;
	}
	
	public static Piece genererPiece() {
		int type = 0; 
		Couleur couleur = null;
		switch(mode) {
		case ALEATOIRE_PIECE:
            type = rand.nextInt(7);
            couleur = Couleur.values()[type];
            return choisirPiece(type, couleur);
        /*case ALEATOIRE_COMPLET:
            type = rand.nextInt(7);
            couleur = Couleur.values()[rand.nextInt(7)];
            return choisirPiece(type, couleur);*/
        case CYCLIC:
            Piece piece = piecesCycliques[index];
            index = (index + 1) % piecesCycliques.length;
            return piece;
        default: // mode  ALEATOIRE_COMPLET
        	type = rand.nextInt(7);
            couleur = Couleur.values()[rand.nextInt(7)];
            return choisirPiece(type, couleur);
		}
		
	}
	
	
	private static Piece choisirPiece(int entier, Couleur couleur) {
		Piece piece = null;
		switch(entier) {
		case 0:
			piece = new OPiece(new Coordonnees(2,3),couleur);
		case 1:
			piece = new IPiece(new Coordonnees(2,3),couleur);
		case 2:
			piece = new TPiece(new Coordonnees(2,3),couleur);
		case 3:
			piece = new LPiece(new Coordonnees(2,3),couleur);
		case 4:
			piece = new JPiece(new Coordonnees(2,3),couleur);
		case 5:
			piece = new ZPiece(new Coordonnees(2,3),couleur);
		case 6:
			piece = new SPiece(new Coordonnees(2,3),couleur);
		default:
			//piece = new OPiece(new Coordonnees(2,3),couleur);
		}
		return piece;
	}
	

	
}
