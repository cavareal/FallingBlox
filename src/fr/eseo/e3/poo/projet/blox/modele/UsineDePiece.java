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
        case ALEATOIRE_COMPLET:
            type = rand.nextInt(7);
            couleur = Couleur.values()[rand.nextInt(7)];
            return choisirPiece(type, couleur);
        case CYCLIC:
        	Piece[] piecesCycliques = {
                    new OPiece(new Coordonnees(2,3), Couleur.ROUGE),
                    new IPiece(new Coordonnees(2,3), Couleur.ORANGE),
                    new TPiece(new Coordonnees(2,3), Couleur.BLEU),
                    new LPiece(new Coordonnees(2,3), Couleur.VERT),
                    new JPiece(new Coordonnees(2,3), Couleur.JAUNE),
                    new ZPiece(new Coordonnees(2,3), Couleur.CYAN),
                    new SPiece(new Coordonnees(2,3), Couleur.VIOLET)
                };
            Piece piece = piecesCycliques[index];
            index = (index + 1) % piecesCycliques.length;
            return piece;
        default:
        	return null;
		}
		
	}
	
	private static Piece choisirPiece(int entier, Couleur couleur) {
		switch(entier) {
		case 0:
			return new OPiece(new Coordonnees(2,3),couleur);
		case 1:
			return new IPiece(new Coordonnees(2,3),couleur);
		case 2:
			return new TPiece(new Coordonnees(2,3),couleur);
		case 3:
			return new LPiece(new Coordonnees(2,3),couleur);
		case 4:
			return new JPiece(new Coordonnees(2,3),couleur);
		case 5:
			return new ZPiece(new Coordonnees(2,3),couleur);
		case 6:
			return new SPiece(new Coordonnees(2,3),couleur);
		default:
			return null;
		}
		
	}
	
}
