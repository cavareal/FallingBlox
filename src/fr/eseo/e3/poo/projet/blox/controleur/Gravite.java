package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class Gravite implements ActionListener{
	
	private Timer timer;
	public int periodicite = 5000;
	private final Puits puits;
	private final VuePuits vuePuits;
	private int lastScore ;
	
	public Gravite(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		this.puits = vuePuits.getPuits();
		//timer.setDelay(1000); // 1 sec
		timer = new Timer(this.periodicite , this);
	    timer.start();
	    lastScore = puits.getTas().getScore();
	}
	

	public int getPeriodicite() {
		return periodicite;
	}


	public void setPeriodicite(int periodicite) {
		this.periodicite = periodicite;
		this.timer.setDelay(periodicite);
	}


	public Timer getTimer() {
		return timer;
	}


	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	
	public void stopTimer() {
	    timer.stop();
	}

	public void restartTimer() {
	    timer.start();
	}


	public Puits getPuits() {
		return puits;
	}


	public VuePuits getVuePuits() {
		return vuePuits;
	}
	
	public void augmentationVitesse() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		puits.gravite();
		vuePuits.repaint();
		int currentScore = puits.getTas().getScore();
        
        // Si le score a augmenté de 20 points depuis la dernière vérification
        if (currentScore - lastScore >= 20) {
            lastScore = currentScore;
            // Augmenter la vitesse de 100
            if(getPeriodicite() - 100 >0) {
            setPeriodicite(getPeriodicite() - 100);
            }
        }
	}
	
	
}
