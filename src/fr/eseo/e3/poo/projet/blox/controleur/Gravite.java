package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class Gravite implements ActionListener{
	
	private Timer timer;
	public int periodicite;
	private final Puits puits;
	private final VuePuits vuePuits;
	
	public Gravite(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		this.puits = vuePuits.getPuits();
		//timer.setDelay(1000); // 1 sec
		Timer timer = new Timer(periodicite, new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            puits.gravite();
	        }
	    });
	    
	    timer.start();
	}
	

	public int getPeriodicite() {
		return periodicite;
	}


	public void setPeriodicite(int periodicite) {
		this.periodicite = periodicite;
	}


	public Timer getTimer() {
		return timer;
	}


	public void setTimer(Timer timer) {
		this.timer = timer;
	}


	public Puits getPuits() {
		return puits;
	}


	public VuePuits getVuePuits() {
		return vuePuits;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
