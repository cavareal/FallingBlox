package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceDeplacement extends MouseAdapter implements MouseMotionListener, 
															  MouseListener, 
															  MouseWheelListener,
															  KeyListener {
	private VuePuits vuePuits; 
	private Puits puits; 
	private boolean bEvt = true;
	private int numColonne;
	
	public PieceDeplacement(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		this.puits = this.vuePuits.getPuits();
	}
	
	public void mouseMoved(MouseEvent event){
		int newNumC = 0; 
		if(puits.getPieceActuelle() != null) {
			if(bEvt) {
				numColonne = (int) Math.floor(event.getX()/vuePuits.getTaille());
				bEvt = false;
			}else {
				
				newNumC = (int) Math.floor(event.getX()/vuePuits.getTaille()); 
				if(newNumC == -1) {
					this.numColonne = newNumC;
				}
				else if (newNumC > numColonne) {
					newNumCSUPnumColonne();
				}
				else if (newNumC < numColonne) {
					newNumINFnumColonne();
				}
				numColonne = newNumC;
			}
		}
		this.vuePuits.repaint();
	}
	
	public void newNumCSUPnumColonne() {
		try {
			if(puits.getPieceActuelle() !=null) {
				try {
					puits.getPieceActuelle().deplacerDe(1, 0);
				} catch (BloxException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}
		}catch (IllegalArgumentException exception) {
			// Ne rien faire si le déplacement lève une exception
		}
	}
	
	public void newNumINFnumColonne() {
		try {
			if(puits.getPieceActuelle() != null) {
				try {
					puits.getPieceActuelle().deplacerDe(-1, 0);
				} catch (BloxException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}
		}catch (IllegalArgumentException exception) {
			// Ne rien faire si le déplacement lève une exception
		}
	}
	
	public void mouseDragged(MouseEvent event) {
		
	}
	
	public void mouseEntered(MouseEvent evt){
		this.numColonne = (int) Math.floor(evt.getX()/vuePuits.getTaille()); 
	}

	public void mouseWheelMoved(MouseWheelEvent event) {
		if(puits.getPieceActuelle() != null && event.getWheelRotation() > 0) {
			try {
				try {
					puits.getPieceActuelle().deplacerDe(0, 1);
				} catch (BloxException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			} catch (IllegalArgumentException exception) {
				// Ne rien faire si le déplacement lève une exception
			}
			vuePuits.repaint();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		// on fait rien 
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int codeTouche = e.getKeyCode();
	        switch (codeTouche) {
	            case KeyEvent.VK_LEFT:
	                // déplacer la pièce vers la gauche
				try {
					puits.getPieceActuelle().deplacerDe(-1, 0);
				} catch (IllegalArgumentException e2) {
					// TODO Auto-generated catch block
				} catch (BloxException e2) {
					// TODO Auto-generated catch block
				}

	                break;
	            case KeyEvent.VK_RIGHT:
				try {
					puits.getPieceActuelle().deplacerDe(1, 0);
				} catch (IllegalArgumentException e2) {
					// TODO Auto-generated catch block
				} catch (BloxException e2) {
					// TODO Auto-generated catch block
				}
	                break;
	            case KeyEvent.VK_DOWN:
				try {
					puits.getPieceActuelle().deplacerDe(0, 1);
				} catch (IllegalArgumentException e2) {
					// TODO Auto-generated catch block
				} catch (BloxException e2) {
					// TODO Auto-generated catch block
				}
	                break;
	            case KeyEvent.VK_SPACE:
				try {
					puits.getPieceActuelle().tourner(true);
				} catch (BloxException e2) {
					// TODO Auto-generated catch block
				}	
					break;
	            case KeyEvent.VK_ENTER:
	            	puits.getPieceActuelle().descenteDirecte();
	            	break;
	            default:
	                // ne rien faire pour les autres touches
	                break;
	        }
	        vuePuits.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		// on fait rien
	}
	
}
