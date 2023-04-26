package fr.eseo.e3.poo.projet.blox.modele;

public class BloxException extends Exception {

	
	private static final long serialVersionUID = 1L;
	
	
	public static final int BLOX_COLLISION = 0;
	public static final int BLOX_SORTIE_PUITS = 1; 
	public static final int BLOX_GAME_OVER = 2;
	private int type;
	
	public BloxException(String message, int type) {
		super(message);
		this.type = type;
	}
	
	public int getType() {
		return this.type;
	}
}
